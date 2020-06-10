package com.mtiarn.finance.adapter.viewholders;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.mtiarn.finance.dao.AccountsDAO;
import com.mtiarn.finance.managers.AccountManager;
import com.mtiarn.finance.model.Account;
import com.mtiarn.finance.model.Template;
import com.mtiarn.finance.R;
import com.mtiarn.finance.utils.AmountColorizer;
import com.mtiarn.finance.utils.CabbageFormatter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class VhTemplate extends VhModelBase {


    @BindView(R.id.textViewAmount)TextView textViewAmount;
    @BindView(R.id.imageview_icon)ImageView imageViewIcon;
    @BindView(R.id.spaceBottom)
    FrameLayout mSpaceBottom;
    @BindView(R.id.spaceBottomFinal)
    FrameLayout mSpaceBottomFinal;


    @BindView(R.id.textViewName)
    TextView textViewName;
    //    @BindView(R.id.textViewAmount)
//    TextView textViewAmount;
    private final AmountColorizer mAmountColorizer;

    public VhTemplate(View itemView, IOnItemClickListener onItemClickListener, Context mContext) {
        super(itemView, onItemClickListener, mContext);
        ButterKnife.bind(this, itemView);
        mAmountColorizer = new AmountColorizer(mContext);
    }

    @Override
    public void bindViewHolder(List<?> mModelList, int position) {
        super.bindViewHolder(mModelList, position);
        Template template = (Template) mModelList.get(position);

        textViewName.setText(template.getName());

        AccountsDAO accountsDAO = AccountsDAO.getInstance(mContext);
        Account srcAccount = accountsDAO.getAccountByID(template.getAccountID());
        CabbageFormatter cabbageFormatter = new CabbageFormatter(AccountManager.getCabbage(srcAccount, mContext));
        textViewAmount.setText(cabbageFormatter.format(template.getAmount()));

        textViewAmount.setTextColor(mAmountColorizer.getTransactionColor(template.getTrType()));
        imageViewIcon.setImageDrawable(mAmountColorizer.getTransactionIcon(template.getTrType()));

        if (position == mModelList.size() - 1) {
            mSpaceBottom.setVisibility(View.GONE);
            mSpaceBottomFinal.setVisibility(View.VISIBLE);
        } else {
            mSpaceBottom.setVisibility(View.VISIBLE);
            mSpaceBottomFinal.setVisibility(View.GONE);
        }
    }
}
