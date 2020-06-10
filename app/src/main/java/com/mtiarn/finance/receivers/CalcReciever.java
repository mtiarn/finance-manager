package com.mtiarn.finance.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.mtiarn.finance.calc.CalculatorActivity;
import com.mtiarn.finance.widgets.AmountEditor;

import java.math.BigDecimal;

public class CalcReciever extends BroadcastReceiver {
    AmountEditor mEditor;
    Context mContext;

    public CalcReciever() {
        mEditor = null;
        mContext = null;
    }

    public CalcReciever(AmountEditor editor, Context context) {
        mEditor = editor;
        mContext = context;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (mEditor == null || mContext == null) {
            return;
        }
        String value = intent.getStringExtra(CalculatorActivity.RESULT);
        BigDecimal amount;
        try {
            amount = new BigDecimal(value);
        } catch (Exception e) {
            amount = BigDecimal.ZERO;
        }
        mEditor.setAmount(amount);
        mContext.unregisterReceiver(this);
    }
}
