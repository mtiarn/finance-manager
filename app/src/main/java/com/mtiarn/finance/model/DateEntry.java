package com.mtiarn.finance.model;

import java.math.BigDecimal;
import java.util.Date;


public class DateEntry {
    private final Date mDate;
    private final BigDecimal mIncome;
    private final BigDecimal mExpense;

    public DateEntry(Date date, BigDecimal income, BigDecimal expense) {
        mDate = date;
        mIncome = income;
        mExpense = expense;
    }

    public Date getDate() {
        return mDate;
    }

    public BigDecimal getIncome() {
        return mIncome;
    }

    public BigDecimal getExpense() {
        return mExpense;
    }
}
