package com.mtiarn.finance.utils;

import com.mtiarn.finance.model.Cabbage;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;

import io.reactivex.Single;

public class CabbageFormatter {
    private final RoundingMode mRoundingMode = RoundingMode.HALF_UP;
    private final Cabbage mCabbage;
    private NumberFormat mNumberFormat;

    public CabbageFormatter(Cabbage mCabbage) {
        this.mCabbage = mCabbage;
        mNumberFormat = NumberFormat.getCurrencyInstance();
    }

    public synchronized String format(BigDecimal amount){
        if (mCabbage != null) {
            mNumberFormat.setMinimumFractionDigits(mCabbage.getDecimalCount());
            mNumberFormat.setMaximumFractionDigits(mCabbage.getDecimalCount());
            DecimalFormatSymbols dfs = new DecimalFormatSymbols();
            dfs.setCurrencySymbol(mCabbage.getSimbol());
            dfs.setGroupingSeparator(' ');
            dfs.setMonetaryDecimalSeparator('.');
            ((DecimalFormat) mNumberFormat).setDecimalFormatSymbols(dfs);

            return mNumberFormat.format(amount.setScale(mCabbage.getDecimalCount(), mRoundingMode));
        } else {
            return "";
        }
    }

    public Single<String> formatRx(BigDecimal amount){
        return Single.fromCallable(() -> format(amount));

    }
}
