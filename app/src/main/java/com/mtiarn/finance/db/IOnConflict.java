package com.mtiarn.finance.db;

import com.mtiarn.finance.interfaces.IAbstractModel;


public interface IOnConflict {
    void conflict(IAbstractModel model);
}
