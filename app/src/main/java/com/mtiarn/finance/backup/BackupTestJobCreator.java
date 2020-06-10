package com.mtiarn.finance.backup;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.evernote.android.job.Job;
import com.evernote.android.job.JobCreator;

public class BackupTestJobCreator implements JobCreator {
    @Override
    @Nullable
    public Job create(@NonNull String tag) {
        switch (tag) {
            case BackupTestJob.TAG:
                return new BackupTestJob();
            default:
                return null;
        }
    }
}
