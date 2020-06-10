package com.mtiarn.finance.db;

import java.io.IOException;

import io.requery.android.database.sqlite.SQLiteDatabase;


public interface IUpdateRunningBalance {
    void updateRunningBalance(SQLiteDatabase database) throws IOException;
}
