package com.mtiarn.finance.model;

public class StringIntItem {
    private int mID;
    private String mName;

    public StringIntItem(String name, int ID) {
        mID = ID;
        mName = name;
    }

    public int getID() {
        return mID;
    }

    public String getName() {
        return mName;
    }

    @Override
    public String toString() {
        return mName;
    }
}
