package com.mtiarn.finance.classes;


public class TableInfo {
    private final String mTableName;
    private final String mTableCreateSQL;
    private final String mTableFields;

    public TableInfo(String tableName, String tableCreateSQL, String tableFields) {
        mTableName = tableName;
        mTableCreateSQL = tableCreateSQL;
        mTableFields = tableFields;
    }

    public String getTableName() {
        return mTableName;
    }

    public String getTableCreateSQL() {
        return mTableCreateSQL;
    }

    public String getTableFields() {
        return mTableFields;
    }



}
