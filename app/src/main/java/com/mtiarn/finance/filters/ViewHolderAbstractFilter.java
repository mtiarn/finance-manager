/*
 * Copyright (c) 2015.
 */

package com.mtiarn.finance.filters;

import android.support.v7.widget.RecyclerView;
import android.view.View;

public abstract class ViewHolderAbstractFilter extends RecyclerView.ViewHolder {

    public ViewHolderAbstractFilter(View itemView) {
        super(itemView);
    }

    public abstract AbstractFilter getFilter();

    public abstract void setFilter(AbstractFilter filter);

    public abstract void bindViewHolder();
}
