package com.mtiarn.finance.iab;

import android.support.annotation.NonNull;

import com.anjlab.android.iab.v3.TransactionDetails;

public interface IBillingEventsListener {
    public void onProductPurchased(@NonNull String productId, TransactionDetails details);

    public void onBillingError(int errorCode, Throwable error);
}
