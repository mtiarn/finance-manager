/*
 * Copyright (c) 2015.
 */
package com.mtiarn.finance;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.Gravity;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.evernote.android.job.JobManager;
import com.github.omadahealth.lollipin.lib.managers.LockManager;
import com.mtiarn.finance.backup.BackupJob;
import com.mtiarn.finance.backup.BackupJobCreator;
import com.mtiarn.finance.backup.BackupTestJobCreator;
import com.mtiarn.finance.di.AppComponent;
import com.mtiarn.finance.di.DaggerAppComponent;
import com.mtiarn.finance.di.modules.ContextModule;
import com.mtiarn.finance.interfaces.ISyncAnimMethods;
import com.mtiarn.finance.receivers.CustomIntentReceiver;
import com.mtiarn.finance.widgets.CustomPinActivity;

import java.lang.ref.WeakReference;

public class FGApplication extends Application implements ISyncAnimMethods {

    private static final String TAG = "FGApplication";
    public static final int MSG_SHOW_ANIM = 1;
    public static final int MSG_HIDE_ANIM = 2;
    public static final int MSG_SHOW_DIALOG = 3;
    public static final int MSG_HIDE_DIALOG = 4;

    boolean mBound = false;
    ServiceConnection sConn;
    Intent intent;

    // Popup to show persistent view
    public PopupWindow mPopupWindow;
    // View held by Popup
    public LinearLayout mLinearLayout;
    ImageView mImageView;
    CustomIntentReceiver mCustomIntentReceiver;

    public AlertDialog getDialog() {
        return mDialog;
    }

    AlertDialog mDialog;
    RotateAnimation mSpinAnim;

    public boolean mAppPaused = true;

    public UpdateUIHandler mUpdateUIHandler;

    private static AppComponent sAppComponent;

    private static FGApplication mContext;

    public static FGApplication getContext() {
        return mContext;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void onCreate() {
//        Debug.startMethodTracing("Startup");
        super.onCreate();

        sAppComponent = DaggerAppComponent.builder()
                .contextModule(new ContextModule(this))
                .build();

        mContext = this;

        JobManager.create(this).addJobCreator(new BackupJobCreator());
        JobManager.create(this).addJobCreator(new BackupTestJobCreator());

        mUpdateUIHandler = new UpdateUIHandler(this);

        mAppPaused = true;

        LockManager<CustomPinActivity> lockManager = LockManager.getInstance();
        lockManager.enableAppLock(this, CustomPinActivity.class);
        lockManager.getAppLock().setOnlyBackgroundTimeout(true);
        lockManager.getAppLock().setLogoId(R.drawable.ic_main);
        long timeout = Integer.valueOf(
                PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).getString(
                        FgConst.PREF_PIN_LOCK_TIMEOUT, "10"))*1000;
        lockManager.getAppLock().setTimeout(timeout);
        lockManager.getAppLock().setOnlyBackgroundTimeout(true);

        registerActivityLifecycleCallbacks(new FgActivityLifecycleCallbacks());

        mCustomIntentReceiver = new CustomIntentReceiver();

        BackupJob.schedule();
    }

    public static AppComponent getAppComponent() {
        return sAppComponent;
    }

    @Override
    public void onTerminate() {
        if (mBound) {
            unbindService(sConn);
            mBound = false;
        }
        stopService(intent);
        super.onTerminate();
    }

    private final class FgActivityLifecycleCallbacks implements ActivityLifecycleCallbacks {

        int numOfRunning = 0;

        @Override
        public void onActivityCreated(Activity arg0, Bundle arg1) {
            switch (Integer.valueOf(PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).getString("theme", "0"))) {
                case ActivityMain.THEME_LIGHT:
                    arg0.setTheme(R.style.AppThemeLight);
                    break;
                case ActivityMain.THEME_DARK:
                    arg0.setTheme(R.style.AppThemeDark);
                    break;
                default:
                    arg0.setTheme(R.style.AppThemeLight);
                    break;
            }

            AlertDialog.Builder builder = new AlertDialog.Builder(arg0)
//                    .setMessage(getString(R.string.msg_db_upgrade))
                    .setCancelable(false);
            mDialog = builder.create();
        }

        @Override
        public void onActivityDestroyed(Activity arg0) { }

        @Override
        public void onActivityPaused(Activity arg0) {

            // An activity has been paused
            // Decrement count, but wait for a certain
            // period of time, in case another activity
            // from this application is being launched
            numOfRunning--;

            // Delay: 100 ms
            // If no activity's onResumed() was called,
            // its safe to assume that the application
            // has been paused, in which case, dismiss
            // the popup
            new Handler().postDelayed(() -> {
                if (numOfRunning == 0) {
                    hideSyncAnim();
                    mAppPaused = true;
                }
            }, 100L);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                try {
                    unregisterReceiver(mCustomIntentReceiver);
                } catch (Exception e) {
                    Log.d(TAG, "Can't unregister receiver");
                }
            }
        }

        @Override
        public void onActivityResumed(Activity arg0) {

            // If no activities were running, show the popup
            if (numOfRunning == 0) {
//                mPopupWindow.showAtLocation(mLinearLayout, Gravity.BOTTOM, 0, 0);
            }
            mAppPaused = false;
            // Now, one activity is running
            numOfRunning++;

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("com.mtiarn.finance.intent.action.CREATE_TRANSACTION");
                intentFilter.addAction("com.mtiarn.finance.intent.action.CREATE_SMS");
                registerReceiver(mCustomIntentReceiver, intentFilter);
            }
        }

        @Override
        public void onActivitySaveInstanceState(Activity arg0, Bundle arg1) { }

        @Override
        public void onActivityStarted(Activity arg0) { }

        @Override
        public void onActivityStopped(Activity arg0) { }

    }

    public void showSyncAnim() {
        if (!mAppPaused) {
            mPopupWindow.showAtLocation(mLinearLayout, Gravity.BOTTOM, 0, 0);
            mImageView.startAnimation(mSpinAnim);
        }
    }

    public void hideSyncAnim() {
        if (mImageView != null) {
            mImageView.clearAnimation();
            mPopupWindow.dismiss();
        }
    }

    public static class UpdateUIHandler extends Handler {
        WeakReference<FGApplication> mReference;

        UpdateUIHandler(FGApplication activity) {
            mReference = new WeakReference<>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            final FGApplication app = mReference.get();

            switch (msg.what) {
                case MSG_SHOW_ANIM:
//                    app.showSyncAnim();
//                    Toast.makeText(app, "Testttttttttttttt", Toast.LENGTH_SHORT).show();
                    break;
                case MSG_HIDE_ANIM:
//                    app.hideSyncAnim();
//                    Toast.makeText(activity, R.string.msg_db_rebuild_error, Toast.LENGTH_SHORT).show();
                    break;
                case MSG_SHOW_DIALOG:
//                    AlertDialog.Builder builder = new AlertDialog.Builder(app)
//                            .setMessage("UPGRADE")
//                            .setCancelable(false);
//                    app.mDialog = builder.create();
                    app.mDialog.show();
                    break;
                case MSG_HIDE_DIALOG:
                    app.mDialog.setMessage((CharSequence) msg.obj);
                    app.mDialog.dismiss();
                    break;
            }

        }
    }
}
