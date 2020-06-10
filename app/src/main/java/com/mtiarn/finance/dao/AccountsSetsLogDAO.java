package com.mtiarn.finance.dao;

import android.content.Context;
import android.database.Cursor;

import com.mtiarn.finance.DBHelper;
import com.mtiarn.finance.interfaces.IAbstractModel;
import com.mtiarn.finance.interfaces.IDaoInheritor;
import com.mtiarn.finance.model.AccountsSet;
import com.mtiarn.finance.model.AccountsSetLog;

import java.util.ArrayList;
import java.util.List;


public class AccountsSetsLogDAO extends BaseDAO implements AbstractDAO, IDaoInheritor {
    private static AccountsSetsLogDAO sInstance;

    private AccountsSetsLogDAO(Context context) {
        super(context, DBHelper.T_LOG_ACCOUNTS_SETS, -1, DBHelper.T_LOG_ACCOUNTS_SETS_ALL_COLUMNS);
        super.setDaoInheritor(this);
    }

    public synchronized static AccountsSetsLogDAO getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new AccountsSetsLogDAO(context);
        }
        return sInstance;
    }

    @Override
    public IAbstractModel cursorToModel(Cursor cursor) {
        return cursorToAccountsSet(cursor);
    }

    private AccountsSetLog cursorToAccountsSet(Cursor cursor) {
        AccountsSetLog accountsSetLog = new AccountsSetLog();
        accountsSetLog.setID(cursor.getLong(mColumnIndexes.get(DBHelper.C_ID)));
        accountsSetLog.setAccountID(cursor.getLong(mColumnIndexes.get(DBHelper.C_LOG_ACCOUNTS_SETS_ACCOUNT)));
        accountsSetLog.setAccountSetID(cursor.getLong(mColumnIndexes.get(DBHelper.C_LOG_ACCOUNTS_SETS_SET)));

        return accountsSetLog;
    }

    @SuppressWarnings("unchecked")
    public List<AccountsSetLog> getAccountsBySet(long accountSetRefID) throws Exception {
        return (List<AccountsSetLog>) getItems(getTableName(), null,
                String.format("%s = %s", DBHelper.C_LOG_ACCOUNTS_SETS_SET, String.valueOf(accountSetRefID)), null, null, null);
    }

    public void createAccountsSet(AccountsSet accountsSet) throws Exception {
        List<IAbstractModel> itemsToDelete = new ArrayList<>();
        for (AccountsSetLog accountsSetLog : getAccountsBySet(accountsSet.getAccountsSetRef().getID())) {
            itemsToDelete.add(accountsSetLog);
        }
        bulkDeleteModel(itemsToDelete, true);

        List<IAbstractModel> itemsToCreate = new ArrayList<>();
        for (AccountsSetLog accountsSetLog : accountsSet.getAccountsSetLogList()) {
            itemsToCreate.add(accountsSetLog);
        }
        bulkCreateModel(itemsToCreate, null, true);
    }
}
