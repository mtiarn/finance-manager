package com.mtiarn.finance;

import android.content.Context;
import android.view.ViewTreeObserver;
import android.widget.TableLayout;

import com.sothree.slidinguppanel.SlidingUpPanelLayout;
import com.mtiarn.finance.utils.ScreenUtils;

public class SumsTableOnGlobalLayoutListener implements ViewTreeObserver.OnGlobalLayoutListener {
    private Context mContext;
    private TableLayout mLayoutSumTable;
    private SlidingUpPanelLayout mSlidingUpPanelLayout;

    SumsTableOnGlobalLayoutListener(Context context, TableLayout layoutSumTable, SlidingUpPanelLayout slidingUpPanelLayout) {
        mContext = context;
        mLayoutSumTable = layoutSumTable;
        mSlidingUpPanelLayout = slidingUpPanelLayout;
    }

    @Override
    public void onGlobalLayout() {
        if (mLayoutSumTable != null && mSlidingUpPanelLayout != null && mLayoutSumTable.getChildCount() >= 2) {
            int height = mLayoutSumTable.getChildAt(0).getHeight()
                    + mLayoutSumTable.getChildAt(1).getHeight()
                    + ScreenUtils.dpToPx(4, mContext);
            if (height != 0) {
                mSlidingUpPanelLayout.setPanelHeight(height);
            }
        }
    }
}
