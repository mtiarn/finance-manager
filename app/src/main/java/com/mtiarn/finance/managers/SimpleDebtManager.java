package com.mtiarn.finance.managers;

import android.content.Context;
import android.support.v4.app.FragmentManager;

import com.mtiarn.finance.FragmentSimpleDebtEdit;
import com.mtiarn.finance.R;
import com.mtiarn.finance.model.SimpleDebt;

public class SimpleDebtManager {

    public static void showEditDialog(final SimpleDebt simpleDebt, final FragmentManager fragmentManager, final Context context) {

        String title;
        if (simpleDebt.getID() < 0) {
            title = context.getResources().getString(R.string.ent_new_debt);
        } else {
            title = context.getResources().getString(R.string.ent_edit_debt);
        }

        FragmentSimpleDebtEdit fragmentSimpleDebtEdit = FragmentSimpleDebtEdit.newInstance(title,simpleDebt);
        fragmentSimpleDebtEdit.show(fragmentManager, "fragmentSimpleDebtEdit");
    }
}
