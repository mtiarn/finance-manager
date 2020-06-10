package com.mtiarn.finance.interfaces;

import com.mtiarn.finance.model.Transaction;

public interface ITransactionClickListener {
    void onSelectButtonClick();

    void onTransactionItemClick(Transaction transaction);
}
