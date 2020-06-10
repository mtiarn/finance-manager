package com.mtiarn.finance.adapter.viewholders;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.preference.PreferenceManager;
import android.support.v4.content.ContextCompat;
import android.util.LongSparseArray;
import android.view.ContextThemeWrapper;

import com.mtiarn.finance.FGApplication;
import com.mtiarn.finance.FgConst;
import com.mtiarn.finance.R;
import com.mtiarn.finance.dao.AccountsDAO;
import com.mtiarn.finance.dao.CabbagesDAO;
import com.mtiarn.finance.dao.CategoriesDAO;
import com.mtiarn.finance.dao.DepartmentsDAO;
import com.mtiarn.finance.dao.LocationsDAO;
import com.mtiarn.finance.dao.PayeesDAO;
import com.mtiarn.finance.dao.ProjectsDAO;
import com.mtiarn.finance.model.Account;
import com.mtiarn.finance.model.Category;
import com.mtiarn.finance.model.Department;
import com.mtiarn.finance.model.Location;
import com.mtiarn.finance.model.Payee;
import com.mtiarn.finance.model.Project;
import com.mtiarn.finance.utils.AmountColorizer;
import com.mtiarn.finance.utils.CabbageFormatter;
import com.mtiarn.finance.utils.DateTimeFormatter;
import com.mtiarn.finance.utils.ScreenUtils;

import javax.inject.Inject;

public class TransactionViewHolderParams {

    public final AmountColorizer mAmountColorizer;
    public final Drawable iconSelected;
    public final DateTimeFormatter mDateTimeFormatter;
    public final int mColorSpan;
    public final int mWhiteColor;
    public int mPositiveAmountColor;
    public int mNegativeAmountColor;
    public int mColorInactive;
    public int mColorSplit;
    public int mColorTag;
    public String mSplitStringCategory;
    public String mSplitStringProject;
    public LongSparseArray<Account> mAccountCache;
    public LongSparseArray<Payee> mPayeeCache;
    public LongSparseArray<Category> mCategoryCache;
    public LongSparseArray<Department> mDepartmentCache;
    public LongSparseArray<Project> mProjectCache;
    public LongSparseArray<Location> mLocationCache;
    public LongSparseArray<CabbageFormatter> mCabbageCache;
    public String mSearchString;
    public ContextThemeWrapper mContextThemeWrapper;
    public Float mTagTextSize;
    public boolean isTagsColored;
    public boolean mShowDateInsteadOfRunningBalance;
    @Inject
    public AccountsDAO mAccountsDAO;
    @Inject
    public DepartmentsDAO mDepartmentsDAO;
    @Inject
    public CabbagesDAO mCabbagesDAO;
    @Inject
    public PayeesDAO mPayeesDAO;
    @Inject
    public LocationsDAO mLocationsDAO;
    @Inject
    public CategoriesDAO mCategoriesDAO;
    @Inject
    public ProjectsDAO  mProjectsDAO;

    public TransactionViewHolderParams(Activity context) {
        FGApplication.getAppComponent().inject(this);
        mSearchString = "";

        mAmountColorizer = new AmountColorizer(context);
        iconSelected = ContextCompat.getDrawable(context, R.drawable.ic_check_circle_blue);

        mDateTimeFormatter = DateTimeFormatter.getInstance(context);

        mPositiveAmountColor = ContextCompat.getColor(context, R.color.positive_color);
        mNegativeAmountColor = ContextCompat.getColor(context, R.color.negative_color);
        mColorInactive = ContextCompat.getColor(context, R.color.light_gray_text);
        mColorSplit = ContextCompat.getColor(context, R.color.blue_color);
        mColorTag = ContextCompat.getColor(context, R.color.ColorAccent);
        mColorSpan = ContextCompat.getColor(context, R.color.ColorPrimary);
        mWhiteColor = ContextCompat.getColor(context, R.color.fg_white_color);
        mSplitStringCategory = context.getString(R.string.ent_split_category);
        mSplitStringProject = context.getString(R.string.ent_split_project);
        mAccountCache = new LongSparseArray<>();
        mPayeeCache = new LongSparseArray<>();
        mCategoryCache = new LongSparseArray<>();
        mDepartmentCache = new LongSparseArray<>();
        mProjectCache = new LongSparseArray<>();
        mLocationCache = new LongSparseArray<>();
        mCabbageCache = new LongSparseArray<>();

        if (PreferenceManager.getDefaultSharedPreferences(context).getBoolean(FgConst.PREF_COMPACT_VIEW_MODE, false)) {
            mContextThemeWrapper = new ContextThemeWrapper(context, R.style.StyleListItemTransationsCompact);
        } else {
            mContextThemeWrapper = new ContextThemeWrapper(context, R.style.StyleListItemTransationsNormal);
        }

        isTagsColored = PreferenceManager.getDefaultSharedPreferences(context).getBoolean(FgConst.PREF_COLORED_TAGS, true);
        mTagTextSize = ScreenUtils.PxToDp(context, context.getResources().getDimension(R.dimen.text_size_micro));
    }

    public void clearCaches() {
        mAccountCache.clear();
        mPayeeCache.clear();
        mCategoryCache.clear();
        mDepartmentCache.clear();
        mProjectCache.clear();
        mLocationCache.clear();
        mCabbageCache.clear();
    }
}
