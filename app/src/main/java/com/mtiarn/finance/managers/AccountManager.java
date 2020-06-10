/*
 * Copyright (c) 2015.
 */

package com.mtiarn.finance.managers;

import android.content.Context;
import android.support.v4.app.FragmentManager;

import com.mtiarn.finance.dao.CabbagesDAO;
import com.mtiarn.finance.FragmentSortAccounts;
import com.mtiarn.finance.model.Account;
import com.mtiarn.finance.model.Cabbage;
import com.mtiarn.finance.R;

public class AccountManager {


    public static Cabbage getCabbage(Account account, Context context) {
        if (account.getCabbageId() < 0) {
            return new Cabbage();
        } else {
            CabbagesDAO cabbagesDAO = CabbagesDAO.getInstance(context);
            return cabbagesDAO.getCabbageByID(account.getCabbageId());
        }
    }

    public static void showSortDialog(FragmentManager fragmentManager, Context context){

        String title = context.getResources().getString(R.string.ttl_sort_accounts);

        FragmentSortAccounts alertDialog = FragmentSortAccounts.newInstance(title);
        alertDialog.show(fragmentManager, "fragment_cabbage_edit");
    }

}
