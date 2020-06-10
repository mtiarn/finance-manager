package com.mtiarn.finance.adapter;

import android.annotation.SuppressLint;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;

import com.mtiarn.finance.FgConst;
import com.mtiarn.finance.R;
import com.mtiarn.finance.adapter.viewholders.TransactionViewHolder;
import com.mtiarn.finance.adapter.viewholders.TransactionViewHolderParams;
import com.mtiarn.finance.interfaces.ITransactionClickListener;
import com.mtiarn.finance.interfaces.ITransactionItemEventListener;
import com.mtiarn.finance.model.Transaction;
import com.mtiarn.finance.utils.ScreenUtils;
import com.mtiarn.finance.widgets.ToolbarActivity;

import java.util.ArrayList;
import java.util.List;

public class TransactionsArrayAdapter extends ArrayAdapter<Transaction> implements ITransactionClickListener {
    private final ContextThemeWrapper mContextThemeWrapper;
    private List<Transaction> mTransactionList = new ArrayList<>();
    private TransactionViewHolderParams mParams;
    private ToolbarActivity mActivity;
    private ITransactionItemEventListener mITransactionItemEventListener;

    public TransactionsArrayAdapter(@NonNull ToolbarActivity activity, List<Transaction> list, ITransactionItemEventListener eventListener) {
        super(activity, 0, list);
        mITransactionItemEventListener = eventListener;
        mTransactionList.clear();
        mTransactionList.addAll(list);

        if (PreferenceManager.getDefaultSharedPreferences(activity).getBoolean(FgConst.PREF_COMPACT_VIEW_MODE, false)) {
            mContextThemeWrapper = new ContextThemeWrapper(activity, R.style.StyleListItemTransationsCompact);
        } else {
            mContextThemeWrapper = new ContextThemeWrapper(activity, R.style.StyleListItemTransationsNormal);
        }
        mParams = new TransactionViewHolderParams(activity);
        mParams.mShowDateInsteadOfRunningBalance = true;
        mActivity = activity;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewGroup.LayoutParams lp = parent.getLayoutParams();
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = ScreenUtils.dpToPx(500f, mActivity);
        parent.setLayoutParams(lp);
        @SuppressLint("ViewHolder") View view = LayoutInflater.from(mContextThemeWrapper).inflate(R.layout.list_item_transactions_2, parent, false);
        TransactionViewHolder viewHolder = new TransactionViewHolder(mParams, this, mActivity, view);
        viewHolder.bindTransaction(mTransactionList.get(position));
        return viewHolder.itemView;
    }

    @Override
    public int getCount() {
        return mTransactionList.size();
    }

    @Override
    public void onSelectButtonClick() {

    }

    @Override
    public void onTransactionItemClick(Transaction transaction) {
        mITransactionItemEventListener.onTransactionItemClick(transaction);
    }
}
