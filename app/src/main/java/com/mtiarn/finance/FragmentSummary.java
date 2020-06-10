package com.mtiarn.finance;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.mtiarn.finance.adapter.AdapterSummary;
import com.mtiarn.finance.classes.ListSumsByCabbage;
import com.mtiarn.finance.dao.CabbagesDAO;
import com.mtiarn.finance.dao.TransactionsDAO;
import com.mtiarn.finance.filters.AbstractFilter;
import com.mtiarn.finance.filters.AccountFilter;
import com.mtiarn.finance.filters.DateRangeFilter;
import com.mtiarn.finance.filters.FilterListHelper;
import com.mtiarn.finance.iab.BillingService;
import com.mtiarn.finance.managers.AccountsSetManager;
import com.mtiarn.finance.model.AccountsSet;
import com.mtiarn.finance.model.SummaryItem;
import com.mtiarn.finance.utils.DateTimeFormatter;
import com.mtiarn.finance.utils.Lg;
import com.mtiarn.finance.utils.LocaleUtils;
import com.mtiarn.finance.widgets.ContextMenuRecyclerView;
import com.mtiarn.finance.widgets.ToolbarActivity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.Set;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class FragmentSummary extends BaseListFragment {

    private static final int INTERVAL_TODAY = 1;
    private static final int INTERVAL_YESTERDAY = 2;
    private static final int INTERVAL_THIS_WEEK = 3;
    private static final int INTERVAL_LAST_WEEK = 4;
    private static final int INTERVAL_THIS_MONTH = 5;
    private static final int INTERVAL_LAST_MONTH = 6;
    private static final int INTERVAL_THIS_YEAR = 7;
    private static final int INTERVAL_LAST_YEAR = 8;

    private AdapterSummary adapter;

    @Inject
    BillingService mBillingService;
    @Inject
    TransactionsDAO mTransactionsDAO;
    @Inject
    CabbagesDAO mCabbagesDAO;
    @Inject
    SharedPreferences mPreferences;

    public static FragmentSummary newInstance(String forceUpdateParam, int layoutID) {
        Lg.log("FragmentSummary newInstance");
        FragmentSummary fragment = new FragmentSummary();
        Bundle args = new Bundle();
        args.putString(FORCE_UPDATE_PARAM, forceUpdateParam);
        args.putInt(LAYOUT_NAME_PARAM, layoutID);
        fragment.setArguments(args);
        Lg.log("FragmentSummary setUpdateListsEvents");
//        fragment.setUpdateListsEvents(fragment);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);

        FGApplication.getAppComponent().inject(this);
        adapter = new AdapterSummary(getActivity());
        adapter.setHasStableIds(true);
        recyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = Objects.requireNonNull(getActivity()).getMenuInflater();
        menuInflater.inflate(R.menu.context_menu_summary, menu);
        final MenuItem item = menu.findItem(R.id.action_show_report);
        ((ToolbarActivity) getActivity()).unsubscribeOnDestroy(
                mBillingService.getReportsIapInfo()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                skuDetailsWrapper -> {
                                    if (skuDetailsWrapper.isPurchased()) {
                                        item.setVisible(true);
                                    } else {
                                        item.setVisible(false);
                                    }
                                },
                                throwable -> item.setVisible(false)));
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        ContextMenuRecyclerView.RecyclerContextMenuInfo info = (ContextMenuRecyclerView.RecyclerContextMenuInfo) item.getMenuInfo();
        if (info == null) return false;
        SummaryItem summaryItem = getSummaryItemByID((int) info.id);
        DateRangeFilter filter = new DateRangeFilter(new Random().nextInt(),getActivity());
        filter.setRange(summaryItem.getIntervalFirst(), summaryItem.getIntervalSecond(), getActivity());
        ArrayList<AbstractFilter> filters = new ArrayList<>();
        filters.add(filter);
        Intent intent;
        if (getUserVisibleHint()) {
            switch (item.getItemId()) {
                case R.id.action_show_transactions:
                    intent = new Intent(getActivity(), ActivityTransactions.class);
                    intent.putParcelableArrayListExtra("filter_list", filters);
                    intent.putExtra("caption", summaryItem.getName());
                    intent.putExtra(FgConst.HIDE_FAB, true);
                    intent.putExtra(FgConst.LOCK_SLIDINGUP_PANEL, true);
                    Objects.requireNonNull(getActivity()).startActivity(intent);
                    break;
                case R.id.action_show_report:
                    intent = new Intent(getActivity(), ActivityReports.class);
                    intent.putParcelableArrayListExtra("filter_list", filters);
                    startActivity(intent);
                    break;
            }
            return true;
        } else
            return false;
    }

    private SummaryItem getSummaryItemByID(int id) {
        Resources res = Objects.requireNonNull(getActivity()).getResources();
        DateTimeFormatter df = DateTimeFormatter.getInstance(getActivity());
        SimpleDateFormat dateFormat;
        Calendar cal = Calendar.getInstance();
        String text;
        switch (id) {
            case INTERVAL_TODAY:
                text = String.format("%s (%s)", res.getString(R.string.ent_today), df.getDateLongStringWithDayOfWeekName(new Date()));
                return new SummaryItem(id, DateRangeFilter.DATE_RANGE_DAY, DateRangeFilter.DATE_RANGE_MODIFIER_CURRENT, new ListSumsByCabbage(), text);
            case INTERVAL_YESTERDAY:
                cal.add(Calendar.DATE, -1);
                text = String.format("%s (%s)", res.getString(R.string.ent_yesterday), df.getDateLongStringWithDayOfWeekName(cal.getTime()));
                return new SummaryItem(INTERVAL_YESTERDAY, DateRangeFilter.DATE_RANGE_DAY, DateRangeFilter.DATE_RANGE_MODIFIER_LAST, new ListSumsByCabbage(), text);
            case INTERVAL_THIS_WEEK:
                text = String.format("%s (%s)", res.getString(R.string.ent_this_week), String.valueOf(cal.get(Calendar.WEEK_OF_YEAR)));
                return new SummaryItem(INTERVAL_THIS_WEEK, DateRangeFilter.DATE_RANGE_WEEK, DateRangeFilter.DATE_RANGE_MODIFIER_CURRENT, new ListSumsByCabbage(), text);
            case INTERVAL_LAST_WEEK:
                cal.add(Calendar.WEEK_OF_YEAR, -1);
                text = String.format("%s (%s)", res.getString(R.string.ent_last_week), String.valueOf(cal.get(Calendar.WEEK_OF_YEAR)));
                return new SummaryItem(INTERVAL_LAST_WEEK, DateRangeFilter.DATE_RANGE_WEEK, DateRangeFilter.DATE_RANGE_MODIFIER_LAST, new ListSumsByCabbage(), text);
            case INTERVAL_THIS_MONTH:
                dateFormat = new SimpleDateFormat("LLLL", LocaleUtils.getLocale(getActivity()));
                text = String.format("%s (%s)", res.getString(R.string.ent_this_month), dateFormat.format(new Date()));
                return new SummaryItem(INTERVAL_THIS_MONTH, DateRangeFilter.DATE_RANGE_MONTH, DateRangeFilter.DATE_RANGE_MODIFIER_CURRENT, new ListSumsByCabbage(), text);
            case INTERVAL_LAST_MONTH:
                cal.add(Calendar.MONTH, -1);
                dateFormat = new SimpleDateFormat("LLLL", LocaleUtils.getLocale(getActivity()));
                text = String.format("%s (%s)", res.getString(R.string.ent_last_month), dateFormat.format(cal.getTime()));
                return new SummaryItem(INTERVAL_LAST_MONTH, DateRangeFilter.DATE_RANGE_MONTH, DateRangeFilter.DATE_RANGE_MODIFIER_LAST, new ListSumsByCabbage(), text);
            case INTERVAL_THIS_YEAR:
                text = String.format("%s (%s)", res.getString(R.string.ent_this_year), String.valueOf(cal.get(Calendar.YEAR)));
                return new SummaryItem(INTERVAL_THIS_YEAR, DateRangeFilter.DATE_RANGE_YEAR, DateRangeFilter.DATE_RANGE_MODIFIER_CURRENT, new ListSumsByCabbage(), text);
            case INTERVAL_LAST_YEAR:
                cal.add(Calendar.YEAR, -1);
                text = String.format("%s (%s)", res.getString(R.string.ent_last_year), String.valueOf(cal.get(Calendar.YEAR)));
                return new SummaryItem(INTERVAL_LAST_YEAR, DateRangeFilter.DATE_RANGE_YEAR, DateRangeFilter.DATE_RANGE_MODIFIER_LAST, new ListSumsByCabbage(), text);
            default:
                text = String.format("%s (%s)", res.getString(R.string.ent_today), df.getDateLongStringWithDayOfWeekName(new Date()));
                return new SummaryItem(INTERVAL_TODAY, DateRangeFilter.DATE_RANGE_DAY, DateRangeFilter.DATE_RANGE_MODIFIER_CURRENT, new ListSumsByCabbage(), text);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public void loadData(long itemID) {
        Set<String> defValues = new HashSet<>(Arrays.asList(Objects.requireNonNull(getActivity()).getResources().getStringArray(R.array.pref_summary_items_values)));
        Set<String> set = mPreferences.getStringSet("summary_items", defValues);

        List<SummaryItem> items = new ArrayList<>();

        if (set.contains("today")) {
            items.add(getSummaryItemByID(INTERVAL_TODAY));
        }
        if (set.contains("yesterday")) {
            items.add(getSummaryItemByID(INTERVAL_YESTERDAY));
        }
        if (set.contains("this_week")) {
            items.add(getSummaryItemByID(INTERVAL_THIS_WEEK));
        }
        if (set.contains("last_week")) {
            items.add(getSummaryItemByID(INTERVAL_LAST_WEEK));
        }
        if (set.contains("this_month")) {
            items.add(getSummaryItemByID(INTERVAL_THIS_MONTH));
        }
        if (set.contains("last_month")) {
            items.add(getSummaryItemByID(INTERVAL_LAST_MONTH));
        }
        if (set.contains("this_year")) {
            items.add(getSummaryItemByID(INTERVAL_THIS_YEAR));
        }
        if (set.contains("last_year")) {
            items.add(getSummaryItemByID(INTERVAL_LAST_YEAR));
        }

        AccountsSet currentAccountsSet = AccountsSetManager.getInstance().getCurrentAccountSet(getContext());
        List<Long> accountsIDs = currentAccountsSet.getAccountsIDsList();
        AccountFilter accountFilter = new AccountFilter(0);
        accountFilter.addList(accountsIDs);
        List<AbstractFilter> filters = new ArrayList<>();
        filters.add(accountFilter);

        ToolbarActivity activity = (ToolbarActivity) getActivity();
        Objects.requireNonNull(activity).unsubscribeOnDestroy(
                mTransactionsDAO.getSummaryGroupedSumsRx(
                        items, new FilterListHelper(filters, "", getActivity()),
                        getActivity())
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(summaryItems -> {
                            adapter.setList(items, mCabbagesDAO.getCabbagesMap());
                            adapter.notifyDataSetChanged();
                        })
        );
    }
}
