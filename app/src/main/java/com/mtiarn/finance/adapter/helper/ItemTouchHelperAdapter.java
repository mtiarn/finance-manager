
package com.mtiarn.finance.adapter.helper;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;


public interface ItemTouchHelperAdapter {


    @SuppressWarnings("UnusedReturnValue")
    boolean onItemMove(RecyclerView.ViewHolder vh, int fromPosition, int toPosition);

    void onDrop(RecyclerView.ViewHolder vh, int fromPosition, int toPosition);



    @SuppressWarnings("EmptyMethod")
    void onItemSwypeRight(int position);

}
