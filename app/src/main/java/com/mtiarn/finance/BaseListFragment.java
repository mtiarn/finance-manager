package com.mtiarn.finance;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.preference.PreferenceManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mtiarn.finance.utils.Lg;
import com.mtiarn.finance.widgets.ContextMenuRecyclerView;
import com.mtiarn.finance.widgets.FgLinearLayoutManager;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Базовый фрагмент, от которого наследуются фрагменты на главном экране (те, что во ViewPager)
 */

public class BaseListFragment extends Fragment {

    public static final String FORCE_UPDATE_PARAM = "forceUpdateParam";
    public static final String LAYOUT_NAME_PARAM = "layoutID";

    @BindView(R.id.recycler_view)
    ContextMenuRecyclerView recyclerView;

    private Unbinder unbinder;
    private boolean isUpdating = false;
    private String mForceUpdateParam;

    protected void loadData(long itemID) {
        throw new UnsupportedOperationException("Method loadData must be implemented");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Lg.log("%s onCreate", getClass().getName());
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mForceUpdateParam = getArguments().getString(FORCE_UPDATE_PARAM);
        }

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Lg.log("%s onCreateView", getClass().getName());
        View view = inflater.inflate(Objects.requireNonNull(getArguments()).getInt(LAYOUT_NAME_PARAM), container, false);
        unbinder = ButterKnife.bind(this, view);
        FgLinearLayoutManager layoutManager = new FgLinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        return view;
    }

    @Override
    public void onDestroyView() {
        Lg.log("%s onDestroyView", getClass().getName());
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onResume() {
        Lg.log("%s onResume", getClass().getName());
        super.onResume();
        registerForContextMenu(recyclerView);
        fullUpdate(-1);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        Lg.log("%s setUserVisibleHint %s ", getClass().getName(), String.valueOf(isVisibleToUser));
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            if (getView() != null) {
                updateIfNecessary(-1);
            }
        }
    }

    @Override
    public void onPause() {
        Lg.log("%s onPause", getClass().getName());
        unregisterForContextMenu(recyclerView);
        super.onPause();
    }

    public void fullUpdate(long itemID) {
        Lg.log("%s fullUpdate", getClass().getName());
        if (getView() != null && getUserVisibleHint() && !isUpdating) {
            update(itemID);
        } else {
            PreferenceManager.getDefaultSharedPreferences(Objects.requireNonNull(getActivity())).edit().putBoolean(mForceUpdateParam, true).apply();
        }
    }

    private void updateIfNecessary(long itemID) {
        Lg.log("%s updateIfNecessary", getClass().getName());
        if (getView() != null && getUserVisibleHint() && !isUpdating && PreferenceManager.getDefaultSharedPreferences(Objects.requireNonNull(getActivity())).getBoolean(mForceUpdateParam, false)) {
            update(itemID);
        }
    }

    private void update(long itemID) {
        isUpdating = true;

        loadData(itemID);

        PreferenceManager.getDefaultSharedPreferences(Objects.requireNonNull(getActivity())).edit().putBoolean(mForceUpdateParam, false).apply();

        isUpdating = false;
    }

}
