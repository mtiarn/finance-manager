package com.mtiarn.finance;


import android.app.Dialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.preference.PreferenceManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import com.mtiarn.finance.adapter.AdapterTrEditConstructor;
import com.mtiarn.finance.adapter.helper.OnStartDragListener;
import com.mtiarn.finance.adapter.helper.SimpleItemTouchHelperCallback;
import com.mtiarn.finance.model.TrEditItem;
import com.mtiarn.finance.utils.PrefUtils;
import com.mtiarn.finance.widgets.ContextMenuRecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class FragmentTrEditConstructorDialog extends DialogFragment implements OnStartDragListener {


    @BindView(R.id.recycler_view)
    ContextMenuRecyclerView mRecyclerView;
    Unbinder unbinder;
    AdapterTrEditConstructor adapter;
    private ItemTouchHelper mItemTouchHelper;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View view = getActivity().getLayoutInflater().inflate(R.layout.fragment_tab_order_dialog, null);
        unbinder = ButterKnife.bind(this, view);

        adapter = new AdapterTrEditConstructor(this);
        adapter.setHasStableIds(true);

        mRecyclerView.setAdapter(adapter);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);

        ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(adapter);
        mItemTouchHelper = new ItemTouchHelper(callback);
        mItemTouchHelper.attachToRecyclerView(mRecyclerView);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
        alertDialogBuilder.setView(view);
        alertDialogBuilder.setTitle(getActivity().getString(R.string.pref_title_tredit_layout_constructor));
        alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String order = "";
                for (TrEditItem item : adapter.getList()) {
                    order = String.format("%s%s&%b&%b;", order, item.getID(), item.isVisible(), item.isHideUnderMore());
                }
                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                preferences.edit().putString(FgConst.PREF_TRANSACTION_EDITOR_CONSTRUCTOR, order).apply();
            }
        });
        alertDialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });


        return alertDialogBuilder.create();
    }

    @Override
    public void onResume() {
        super.onResume();

        loadData();

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);

        Window window = getDialog().getWindow();

        if (window != null) {
//            window.setGravity(Gravity.BOTTOM);
        }

        return view;
    }

    @Override
    public void onStartDrag(RecyclerView.ViewHolder viewHolder) {
        mItemTouchHelper.startDrag(viewHolder);
    }

    private void loadData() {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        adapter.setList(PrefUtils.getTrEditorLayout(preferences, getActivity()));
        adapter.notifyDataSetChanged();
    }
}
