package com.mtiarn.finance.interfaces;

import com.mtiarn.finance.model.Transaction;

public interface ITransactionItemEventListener {
    void onTransactionItemClick(Transaction transaction);

    void onSelectionChange(int selectedCount);
}
