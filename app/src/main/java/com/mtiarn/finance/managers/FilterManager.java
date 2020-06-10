package com.mtiarn.finance.managers;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.mtiarn.finance.DBHelper;
import com.mtiarn.finance.filters.AbstractFilter;
import com.mtiarn.finance.filters.AccountFilter;
import com.mtiarn.finance.filters.AmountFilter;
import com.mtiarn.finance.filters.DateRangeFilter;
import com.mtiarn.finance.filters.NestedModelFilter;
import com.mtiarn.finance.interfaces.IAbstractModel;
import com.mtiarn.finance.model.BaseModel;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;


public class FilterManager {

    private static final int FILTER_TYPES[] = new int[]{
            IAbstractModel.MODEL_TYPE_AMOUNT_FILTER,
            IAbstractModel.MODEL_TYPE_ACCOUNT,
            IAbstractModel.MODEL_TYPE_DATE_RANGE,
            IAbstractModel.MODEL_TYPE_PAYEE,
            IAbstractModel.MODEL_TYPE_PROJECT,
            IAbstractModel.MODEL_TYPE_SIMPLEDEBT,
            IAbstractModel.MODEL_TYPE_DEPARTMENT,
            IAbstractModel.MODEL_TYPE_LOCATION,
            IAbstractModel.MODEL_TYPE_CATEGORY
    };

    public static List<AbstractFilter> loadFiltersFromPreferences(SharedPreferences preferences, Context context) {
        String filters[] = preferences.getString("filters", "").split(";");
        List<AbstractFilter> filterList = new ArrayList<>();
        AbstractFilter filter;
        String parts[];
        try {
            for (String s : filters) {
                parts = s.split("/");
                if (parts.length != 5) {
                    continue;
                }
                long id = Integer.valueOf(parts[0]);
                int filterType = Integer.valueOf(parts[1]);
                switch (filterType) {
                    case IAbstractModel.MODEL_TYPE_ACCOUNT:
                        filter = new AccountFilter(id);
                        break;
                    case IAbstractModel.MODEL_TYPE_AMOUNT_FILTER:
                        filter = new AmountFilter(id);
                        break;
                    case IAbstractModel.MODEL_TYPE_DATE_RANGE:
                        filter = new DateRangeFilter(id, context);
                        break;
                    case IAbstractModel.MODEL_TYPE_PAYEE:
                    case IAbstractModel.MODEL_TYPE_PROJECT:
                    case IAbstractModel.MODEL_TYPE_SIMPLEDEBT:
                    case IAbstractModel.MODEL_TYPE_DEPARTMENT:
                    case IAbstractModel.MODEL_TYPE_LOCATION:
                    case IAbstractModel.MODEL_TYPE_CATEGORY:
                        filter = new NestedModelFilter(id, filterType);
                        break;
                    default:
                        continue;
                }
                if (filter.loadFromString(parts[4])) {
                    filter.setEnabled(Boolean.valueOf(parts[2]));
                    filter.setInverted(Boolean.valueOf(parts[3]));
                    filterList.add(filter);
                }
            }
        } catch (Exception e) {
            preferences.edit().putString("filters", "").apply();
        }
        return filterList;
    }

    public static HashSet<Long> getAccountsIDsByFilterType(int filterType, List<AbstractFilter> filters, boolean inverted) {
        HashSet<Long> ids = new HashSet<>();
        if (filterType == IAbstractModel.MODEL_TYPE_ACCOUNT) {
            for (AbstractFilter filter : filters) {
                if (filter.getEnabled() && filter.getModelType() == filterType && filter.isInverted() == inverted) {
                    ids.addAll(filter.getIDsSet());
                }
            }
        }
        return ids;
    }

    public static HashSet<Long> getNestedIDsByFilterType(int filterType, List<AbstractFilter> filters, boolean inverted, Context context) {
        HashSet<Long> ids = new HashSet<>();
        switch (filterType) {
            case IAbstractModel.MODEL_TYPE_PAYEE:
            case IAbstractModel.MODEL_TYPE_PROJECT:
            case IAbstractModel.MODEL_TYPE_SIMPLEDEBT:
            case IAbstractModel.MODEL_TYPE_DEPARTMENT:
            case IAbstractModel.MODEL_TYPE_LOCATION:
            case IAbstractModel.MODEL_TYPE_CATEGORY:
                for (AbstractFilter filter : filters) {
                    if (filter.getEnabled() && filter.getModelType() == filterType && filter.isInverted() == inverted) {
                        ids.addAll(((NestedModelFilter) filter).getIDsSetWithNestedIDs(context));
                    }
                }
                break;
        }
        return ids;
    }

    public static HashSet<Long> getAccountIDsFromFilters(List<AbstractFilter> filters, HashSet<Long> allIDs) {
        HashSet<Long> ids;
        HashSet<Long> posIDs = getAccountsIDsByFilterType(IAbstractModel.MODEL_TYPE_ACCOUNT, filters, false);
        if (posIDs.isEmpty()) {
            HashSet<Long> negIDs = getAccountsIDsByFilterType(IAbstractModel.MODEL_TYPE_ACCOUNT, filters, true);
            ids = new HashSet<>(allIDs);
            if (!negIDs.isEmpty()) {
                ids.removeAll(negIDs);
            }
        } else {
            ids = posIDs;
        }
        return ids;
    }

    private static String getAccountsFilterString(List<AbstractFilter> filters, HashSet<Long> allAccountIDS, boolean filtersForList, boolean src, Context context) {
        HashSet<Long> ids = getAccountIDsFromFilters(filters, allAccountIDS);

        if (ids.isEmpty()) {
            return String.format("(%s = -1 AND %s = -1)", DBHelper.C_LOG_TRANSACTIONS_SRCACCOUNT, DBHelper.C_LOG_TRANSACTIONS_DESTACCOUNT);
        } else {
            String s = TextUtils.join(",", ids);
            if (filtersForList) {
                return String.format("(%s IN (%s) OR %s IN (%s))", DBHelper.C_LOG_TRANSACTIONS_SRCACCOUNT, s, DBHelper.C_LOG_TRANSACTIONS_DESTACCOUNT, s);
            } else {
                if (src) {
                    return String.format("%s IN (%s)", DBHelper.C_LOG_TRANSACTIONS_SRCACCOUNT, s);
                } else {
                    return String.format("%s IN (%s)", DBHelper.C_LOG_TRANSACTIONS_DESTACCOUNT, s);
                }
            }
        }
    }

    /**
     *
     * @param filterType
     * @param filters
     * @param useForList - если тру, то строка для отображения списка транзакций, иначе для вычисления сумм и отчетов
     * @param context
     * @return
     */
    private static String getNestedModelFilterString(int filterType, List<AbstractFilter> filters, boolean useForList, Context context) {
        HashSet<Long> posIds = getNestedIDsByFilterType(filterType, filters, false, context);
        HashSet<Long> negIds = getNestedIDsByFilterType(filterType, filters, true, context);
        String posIDsString = TextUtils.join(",", posIds);
        String negIDsString = TextUtils.join(",", negIds);
        String posCondition = "";
        String negCondition = "";
        String field = BaseModel.createModelByType(filterType).getLogTransactionsField();
        switch (filterType) {
            case IAbstractModel.MODEL_TYPE_PAYEE:
            case IAbstractModel.MODEL_TYPE_SIMPLEDEBT:
            case IAbstractModel.MODEL_TYPE_DEPARTMENT:
            case IAbstractModel.MODEL_TYPE_LOCATION:
                if (!posIds.isEmpty()) {
                    posCondition = String.format("%s IN (%s)", field, posIDsString);
                }
                if (!negIds.isEmpty()) {
                    negCondition = String.format("%s NOT IN (%s)", field, negIDsString);
                }
                break;
            case IAbstractModel.MODEL_TYPE_PROJECT:
                if (useForList) {
                    if (!posIds.isEmpty()) {
                        posCondition = String.format(
                                "CASE WHEN" +
                                        " lt.Split\n" +
                                        "THEN" +
                                        " EXISTS(SELECT CASE WHEN ProjectID < 0 THEN Project ELSE ProjectID END AS cID FROM log_Products WHERE TransactionID = lt._id AND cID IN(%s) LIMIT 1)\n" +
                                        "ELSE" +
                                        " Project IN (%s) " +
                                        "END",
                                posIDsString, posIDsString);
                    }
                    if (!negIds.isEmpty()) {
                        negCondition = String.format(
                                "CASE WHEN" +
                                        " lt.Split\n" +
                                        "THEN" +
                                        " EXISTS(SELECT CASE WHEN ProjectID < 0 THEN Project ELSE ProjectID END AS cID FROM log_Products WHERE TransactionID = lt._id AND cID NOT IN (%s) LIMIT 1)\n" +
                                        "ELSE" +
                                        " Project NOT IN (%s) " +
                                        "END",
                                negIDsString, negIDsString);
                    }
                } else {
                    if (!posIds.isEmpty()) {
                        posCondition = String.format("Project IN (%s)", posIDsString);
                    }
                    if (!negIds.isEmpty()) {
                        negCondition = String.format("Project NOT IN (%s)", negIDsString);
                    }
                }

                break;
            case IAbstractModel.MODEL_TYPE_CATEGORY:
                if (useForList) {
                    if (!posIds.isEmpty()) {
                        posCondition = String.format(
                                "CASE WHEN" +
                                " lt.Split\n" +
                                "THEN" +
                                " EXISTS(SELECT CASE WHEN CategoryID < 0 THEN Category ELSE CategoryID END AS cID FROM log_Products WHERE TransactionID = lt._id AND cID IN(%s) LIMIT 1)\n" +
                                "ELSE" +
                                " Category IN (%s) " +
                                "END",
                                posIDsString, posIDsString);
                    }
                    if (!negIds.isEmpty()) {
                        negCondition = String.format(
                                "CASE WHEN" +
                                        " lt.Split\n" +
                                        "THEN" +
                                        " EXISTS(SELECT CASE WHEN CategoryID < 0 THEN Category ELSE CategoryID END AS cID FROM log_Products WHERE TransactionID = lt._id AND cID NOT IN (%s) LIMIT 1)\n" +
                                        "ELSE" +
                                        " Category NOT IN (%s) " +
                                        "END",
                                negIDsString, negIDsString);
                    }
                } else {
                    if (!posIds.isEmpty()) {
                        posCondition = String.format("Category IN (%s)", posIDsString);
                    }
                    if (!negIds.isEmpty()) {
                        negCondition = String.format("Category NOT IN (%s)", negIDsString);
                    }
                }

                break;
        }
        String condition;
        if (!posCondition.isEmpty() & !negCondition.isEmpty()) {
            condition = String.format("(%s) AND (%s)", posCondition, negCondition);
        } else if (!posCondition.isEmpty() & negCondition.isEmpty()) {
            condition = posCondition;
        } else if (posCondition.isEmpty() & !negCondition.isEmpty()) {
            condition = negCondition;
        } else {
            condition = "";
        }
        return condition;
    }

    private static String joinAmountFilterConditions(int filterType, HashSet<Long> filteredAccountIDS, List<AbstractFilter> filters) {
        List<String> conditions = new ArrayList<>();
        for (AbstractFilter filter : filters) {
            if (filter.getModelType() == IAbstractModel.MODEL_TYPE_AMOUNT_FILTER) {
                String condition = ((AmountFilter)filter).getSelectionString(filteredAccountIDS);
                if (!condition.isEmpty()) {
                    conditions.add(condition);
                }
            }
        }
        return TextUtils.join(" AND ", conditions);
    }

    private static String joinDateRangeFilterConditions(int filterType, List<AbstractFilter> filters) {
        List<String> conditions = new ArrayList<>();
        for (AbstractFilter filter : filters) {
            if (filter.getModelType() == filterType) {
                String condition = filter.getSelectionString(null);
                if (!condition.isEmpty()) {
                    conditions.add(condition);
                }
            }
        }
        return TextUtils.join(" AND ", conditions);
    }

    public static String createSelectionString(List<AbstractFilter> filters, HashSet<Long> allAccountIDS, boolean filtersForList, boolean src, boolean useForList, Context context) {
        List<String> conditions = new ArrayList<>();
        String condition;
        boolean isAmountFilterActive = false;
        for (int type : FILTER_TYPES) {
            condition = "";
            switch (type) {
                case IAbstractModel.MODEL_TYPE_AMOUNT_FILTER:
                    condition = joinAmountFilterConditions(type, getAccountIDsFromFilters(filters, allAccountIDS), filters);
                    isAmountFilterActive = !condition.isEmpty();
                    break;
                case IAbstractModel.MODEL_TYPE_DATE_RANGE:
                    condition = joinDateRangeFilterConditions(type, filters);
                    break;
                case IAbstractModel.MODEL_TYPE_ACCOUNT:
                    if (!isAmountFilterActive) {
                        condition = getAccountsFilterString(filters, allAccountIDS, filtersForList, src, context);
                    }
                    break;
                case IAbstractModel.MODEL_TYPE_PAYEE:
                case IAbstractModel.MODEL_TYPE_PROJECT:
                case IAbstractModel.MODEL_TYPE_SIMPLEDEBT:
                case IAbstractModel.MODEL_TYPE_DEPARTMENT:
                case IAbstractModel.MODEL_TYPE_LOCATION:
                case IAbstractModel.MODEL_TYPE_CATEGORY:
                    condition = getNestedModelFilterString(type, filters, useForList, context);
                    break;
            }
            if (!condition.isEmpty()) {
                conditions.add(String.format("(%s)", condition));
            }
        }

        condition = TextUtils.join(" AND ", conditions);



        return condition;
    }

    public static AbstractFilter createFilter(int modelType, long modelID) {
        AbstractFilter filter;
        switch (modelType) {
            case IAbstractModel.MODEL_TYPE_ACCOUNT:
                filter = new AccountFilter(new Random().nextInt(Integer.MAX_VALUE));
                break;
            case IAbstractModel.MODEL_TYPE_PAYEE:
            case IAbstractModel.MODEL_TYPE_PROJECT:
            case IAbstractModel.MODEL_TYPE_SIMPLEDEBT:
            case IAbstractModel.MODEL_TYPE_DEPARTMENT:
            case IAbstractModel.MODEL_TYPE_LOCATION:
            case IAbstractModel.MODEL_TYPE_CATEGORY:
                filter = new NestedModelFilter(new Random().nextInt(Integer.MAX_VALUE), modelType);
                break;
            default:
                return null;
        }
        filter.getIDsSet().add(modelID);
        return filter;
    }

    public static ArrayList<AbstractFilter> createFilterList(int modelType, long modelID) {
        ArrayList<AbstractFilter> filters = new ArrayList<>();
        AbstractFilter filter = createFilter(modelType, modelID);
        if (filter != null) {
            filters.add(filter);
        }
        return filters;
    }
}
