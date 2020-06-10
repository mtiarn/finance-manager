package com.mtiarn.finance.iab.models;

import android.view.View;

public class ReportsItem {
    private final SkuDetailsWrapper mSkuDetailsWrapper;
    private final int mIconID;
    private final View.OnClickListener mOnClickListener;

    public ReportsItem(SkuDetailsWrapper skuDetailsWrapper, int iconID, View.OnClickListener onClickListener) {
        mSkuDetailsWrapper = skuDetailsWrapper;
        mIconID = iconID;
        mOnClickListener = onClickListener;
    }

    public SkuDetailsWrapper getSkuDetailsWrapper() {
        return mSkuDetailsWrapper;
    }

    public int getIconID() {
        return mIconID;
    }

    public View.OnClickListener getOnClickListener() {
        return mOnClickListener;
    }

    public long getID() {
        return 0;
    }
}
