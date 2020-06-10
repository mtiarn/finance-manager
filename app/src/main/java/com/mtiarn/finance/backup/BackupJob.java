package com.mtiarn.finance.backup;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.preference.PreferenceManager;

import com.dropbox.core.DbxException;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.WriteMode;
import com.evernote.android.job.DailyJob;
import com.evernote.android.job.JobRequest;
import com.mtiarn.finance.BuildConfig;
import com.mtiarn.finance.DBHelper;
import com.mtiarn.finance.FGApplication;
import com.mtiarn.finance.FgConst;
import com.mtiarn.finance.dropbox.DropboxClient;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public class BackupJob extends DailyJob {

    public static final String TAG = "job_backup_tag";

    public static int schedule() {
        // schedule between 1 and 6 AM
        return DailyJob.schedule(new JobRequest.Builder(TAG),
                TimeUnit.HOURS.toMillis(1) + TimeUnit.MINUTES.toMillis(00),
                TimeUnit.HOURS.toMillis(6) + TimeUnit.MINUTES.toMillis(00));
    }

    @NonNull
    @Override
    protected DailyJobResult onRunDailyJob(Params params) {
        if (!BuildConfig.FLAVOR.equals("nd")) {
            Context context = FGApplication.getContext();
            SharedPreferences dropboxPrefs = context.getSharedPreferences("com.mtiarn.finance.dropbox", Context.MODE_PRIVATE);
            String token = dropboxPrefs.getString("dropbox-token", null);
            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
            // Do the task here
            try {
                File zip = DBHelper.getInstance(context).backupDB(true);
                if (token != null && zip != null) {
                    DbxClientV2 dbxClient = DropboxClient.getClient(token);
                    // Upload to Dropbox
                    InputStream inputStream = new FileInputStream(zip);
                    try {
                        dbxClient.files().uploadBuilder("/" + zip.getName()) //Path in the user's Dropbox to save the file.
                                .withMode(WriteMode.OVERWRITE) //always overwrite existing file
                                .uploadAndFinish(inputStream);
                        prefs.edit().putLong(FgConst.PREF_SHOW_LAST_SUCCESFUL_BACKUP_TO_DROPBOX, new Date().getTime()).apply();
                    } catch (DbxException e) {
                        e.printStackTrace();
                    }
//                Log.d("Upload Status", "Success");

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return DailyJobResult.SUCCESS;
    }
}
