package com.mtiarn.finance.csv;

import android.content.Context;
import android.util.SparseArray;

import com.mtiarn.finance.dao.AbstractDAO;
import com.mtiarn.finance.dao.BaseDAO;
import com.mtiarn.finance.dao.CabbagesDAO;
import com.mtiarn.finance.interfaces.IAbstractModel;
import com.mtiarn.finance.model.Account;
import com.mtiarn.finance.model.Cabbage;


class CsvImportCache {
    private SparseArray<IAbstractModel> mCache;
    private AbstractDAO mDAO;
    private int mModelType;

    CsvImportCache(int modelType, Context context) {
        mModelType = modelType;
        mDAO = BaseDAO.getDAO(modelType, context);
        mCache = new SparseArray<>();
    }

    void add(int key, IAbstractModel object) {
        mCache.put(key, object);
    }

    IAbstractModel getNestedModelByName(String name) throws Exception {
        IAbstractModel model = mCache.get(name.hashCode());
        if (model == null) {
            model = mDAO.getModelByFullName(name);
            if (model.getID() >= 0) {
                mCache.put(name.hashCode(), model);
            }
        }
        return model;
    }

    Account getAccountByName(String name) throws Exception {
        Account account = (Account) mCache.get(name.hashCode());
        if (account == null) {
            account = (Account) mDAO.getModelByName(name);
            if (account.getID() >= 0) {
                mCache.put(name.hashCode(), account);
            }
        }
        return account;
    }

    Cabbage getCabbageByCode(String code) throws Exception {
        Cabbage cabbage = (Cabbage) mCache.get(code.hashCode());
        if (cabbage== null) {
            cabbage = ((CabbagesDAO) mDAO).getCabbageByCode(code);
            if (cabbage.getID() >= 0) {
                mCache.put(code.hashCode(), cabbage);
            }
        }
        return cabbage;
    }
}
