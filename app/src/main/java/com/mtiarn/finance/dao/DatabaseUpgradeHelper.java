package com.mtiarn.finance.dao;


public class DatabaseUpgradeHelper {
    private static DatabaseUpgradeHelper mInstance = null;
    private boolean isUpgrading;

    public synchronized static DatabaseUpgradeHelper getInstance() {
        if (mInstance == null) {
            mInstance = new DatabaseUpgradeHelper();
        }
        return mInstance;
    }

    public DatabaseUpgradeHelper() {
        isUpgrading = false;
    }

    public boolean isUpgrading() {
        return isUpgrading;
    }

    public void setUpgrading(boolean upgrading) {
        isUpgrading = upgrading;
    }
}
