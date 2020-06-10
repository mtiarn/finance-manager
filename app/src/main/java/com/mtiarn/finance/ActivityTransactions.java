package com.mtiarn.finance;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.TextView;

import com.mtiarn.finance.interfaces.IAbstractModel;
import com.mtiarn.finance.model.BaseModel;
import com.mtiarn.finance.model.Events;
import com.mtiarn.finance.utils.ColorUtils;
import com.mtiarn.finance.utils.Lg;
import com.mtiarn.finance.widgets.ToolbarActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class ActivityTransactions extends ToolbarActivity {

    FragmentTransactions mFragmentTransactions;

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_transactions;
    }

    @Override
    protected String getLayoutTitle() {
        return getString(R.string.ent_transactions);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            String caption = getIntent().getStringExtra("caption");
            TextView textView = findViewById(R.id.textViewSubtitle);
            if (caption != null && !caption.isEmpty()) {
                textView.setVisibility(View.VISIBLE);
                textView.setText(caption);
            } else {
                textView.setVisibility(View.GONE);
            }
            textView.setBackgroundColor(ColorUtils.getBackgroundColor(this));

            mFragmentTransactions = FragmentTransactions.newInstance(FgConst.PREF_FORCE_UPDATE_TRANSACTIONS, R.layout.fragment_transactions);
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.add(R.id.container, mFragmentTransactions, "fragment_transactions").commit();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }

    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void onEvent(Events.EventOnModelChanged event) {
        Lg.log("EventOnModelChanged model class %s", BaseModel.createModelByType(event.getModelType()).getClass().getName());
        switch (event.getModelType()) {
            case IAbstractModel.MODEL_TYPE_ACCOUNT:
            case IAbstractModel.MODEL_TYPE_TRANSACTION:
            case IAbstractModel.MODEL_TYPE_CATEGORY:
            case IAbstractModel.MODEL_TYPE_PAYEE:
            case IAbstractModel.MODEL_TYPE_PROJECT:
            case IAbstractModel.MODEL_TYPE_LOCATION:
            case IAbstractModel.MODEL_TYPE_DEPARTMENT:
                mFragmentTransactions.fullUpdate(-1);
                break;
        }
    }
}
