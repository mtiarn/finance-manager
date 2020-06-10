package com.mtiarn.finance.model;

public class AutocompleteItem {
    private long mID;
    private String mFullName;

    public AutocompleteItem(long ID, String fullName) {
        mID = ID;
        mFullName = fullName;
    }

    public long getID() {
        return mID;
    }

    public String getFullName() {
        return mFullName;
    }

    @Override
    public String toString() {
        return mFullName;
    }
}
