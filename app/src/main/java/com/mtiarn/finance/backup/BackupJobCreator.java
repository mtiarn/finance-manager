package com.mtiarn.finance.backup;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.evernote.android.job.Job;
import com.evernote.android.job.JobCreator;

public class BackupJobCreator implements JobCreator {

    @Override
    @Nullable
    public Job create(@NonNull String tag) {
        switch (tag) {
            case BackupJob.TAG:
                return new BackupJob();
            default:
                return null;
        }
    }
}
