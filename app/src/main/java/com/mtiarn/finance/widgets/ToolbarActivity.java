package com.mtiarn.finance.widgets;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

//import com.arellomobile.mvp.MvpDelegate;
import com.github.omadahealth.lollipin.lib.PinCompatActivity;
import com.mtiarn.finance.ActivityMain;
import com.mtiarn.finance.BuildConfig;
import com.mtiarn.finance.FGApplication;
import com.mtiarn.finance.R;
import com.mtiarn.finance.interfaces.IUnsubscribeOnDestroy;
import com.mtiarn.finance.utils.ViewServer;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract class ToolbarActivity extends PinCompatActivity implements IUnsubscribeOnDestroy {
//    private MvpDelegate<? extends ToolbarActivity> mMvpDelegate;

    protected final String TAG = this.getClass().getName();
    @BindView(R.id.toolbar)
    public Toolbar toolbar;
    private CompositeDisposable mCompositeDisposable;

    @Inject
    public SharedPreferences mPreferences;

    @Override
    public void unsubscribeOnDestroy(Disposable disposable) {
        mCompositeDisposable.add(disposable);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        getMvpDelegate().onCreate(savedInstanceState);

        setContentView(getLayoutResourceId());
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        FGApplication.getAppComponent().inject(this);

        mCompositeDisposable = new CompositeDisposable();

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setHomeAsUpIndicator(ContextCompat.getDrawable(this, R.drawable.ic_arrow_back_white));
            getSupportActionBar().setTitle(getLayoutTitle());
        }
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToolbarActivity.this.onBackPressed();
            }
        });

        ViewServer.get(this).addWindow(this);
    }

    @Override
    protected void onStart() {
        super.onStart();

//        getMvpDelegate().onAttach();
    }

    @Override
    protected void onStop() {
        super.onStop();

//        getMvpDelegate().onDetach();

        mCompositeDisposable.clear();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

//        getMvpDelegate().onDestroyView();

        if (isFinishing()) {
//            getMvpDelegate().onDestroy();
        }

        ViewServer.get(this).removeWindow(this);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

//        getMvpDelegate().onSaveInstanceState(outState);
//        getMvpDelegate().onDetach();
    }

    @Override
    public void onResume() {
        super.onResume();

//        getMvpDelegate().onAttach();

        ViewServer.get(this).setFocusedWindow(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    protected abstract int getLayoutResourceId();

    protected abstract String getLayoutTitle();

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        final MenuItem item = menu.findItem(R.id.action_go_home);
        Boolean showHomeButton = getIntent().getBooleanExtra("showHomeButton", true);
        if (showHomeButton) {
            item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item1) {
                    Intent intent = new Intent(ToolbarActivity.this, ActivityMain.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    ToolbarActivity.this.startActivity(intent);
                    return true;
                }
            });
        } else {
            item.setVisible(false);
        }

        final MenuItem itemHelp = menu.findItem(R.id.action_show_help);
        Boolean showHelpButton = getIntent().getBooleanExtra("showHelpButton", false);
        itemHelp.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item1) {
                return ToolbarActivity.this.showHelp();
            }
        });
        if (!showHelpButton) {
            itemHelp.setVisible(false);
        }

        final MenuItem itemTheme = menu.findItem(R.id.action_change_theme);
        itemTheme.setVisible(BuildConfig.DEBUG);
//        itemTheme.setVisible(false);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_change_theme:
                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
                int theme = Integer.valueOf(preferences.getString("theme", "0"));
                switch (theme) {
                    case ActivityMain.THEME_LIGHT:
                        theme = ActivityMain.THEME_DARK;
                        break;
                    case ActivityMain.THEME_DARK:
                        theme = ActivityMain.THEME_LIGHT;
                        break;
                }
                preferences.edit().putString("theme", String.valueOf(theme)).apply();
                recreate();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public boolean showHelp() {
        return true;
    }

//    public MvpDelegate getMvpDelegate() {
//        if (mMvpDelegate == null) {
//            mMvpDelegate = new MvpDelegate<>(this);
//        }
//        return mMvpDelegate;
//    }

}