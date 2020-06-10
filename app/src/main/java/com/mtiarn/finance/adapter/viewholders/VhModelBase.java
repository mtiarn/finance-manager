package com.mtiarn.finance.adapter.viewholders;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;


public class VhModelBase extends RecyclerView.ViewHolder implements View.OnClickListener {


    public final IOnItemClickListener mOnItemClickListener;
    private int mPosition;
    final Context mContext;

    public VhModelBase(View itemView, IOnItemClickListener onItemClickListener, Context mContext) {
        super(itemView);
        mOnItemClickListener = onItemClickListener;
        itemView.setOnClickListener(this);
        this.mContext = mContext;
    }

    public void bindViewHolder(List<?> mModelList, int position) {
        mPosition = position;
        itemView.setLongClickable(true);
    }

    @Override
    public void onClick(View v) {
        if (mOnItemClickListener != null) {
            mOnItemClickListener.OnItemClick(mPosition);
        }
    }

    public interface IOnItemClickListener {
        void OnItemClick(int position);
    }
}
