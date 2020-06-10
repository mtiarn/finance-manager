package com.mtiarn.finance.model;

import com.mtiarn.finance.classes.ListSumsByCabbage;

public class BudgetForCategory {
    private ListSumsByCabbage mSums;
    private final int mType;

    public BudgetForCategory(ListSumsByCabbage mSums, int mType) {
        this.mSums = mSums;
        this.mType = mType;
    }

    public int getmType() {
        return mType;
    }

    public ListSumsByCabbage getmSums() {
        return mSums;
    }

    public void setmSums(ListSumsByCabbage mSums) {
        this.mSums = mSums;
    }
}
