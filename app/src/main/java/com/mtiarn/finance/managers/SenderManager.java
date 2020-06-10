package com.mtiarn.finance.managers;

import android.content.Context;
import android.support.v4.app.FragmentManager;

import com.mtiarn.finance.FragmentSenderEdit;
import com.mtiarn.finance.R;
import com.mtiarn.finance.model.Sender;

public class SenderManager {

    public static void showEditDialog(final Sender sender, final FragmentManager fragmentManager, final Context context) {

        String title;
        if (sender.getID() < 0) {
            title = context.getResources().getString(R.string.ent_new_sender);
        } else {
            title = context.getResources().getString(R.string.ent_edit_sender);
        }

        FragmentSenderEdit fragmentSenderEdit = FragmentSenderEdit.newInstance(title,sender);
        fragmentSenderEdit.show(fragmentManager, "fragmentSenderEdit");
    }
}
