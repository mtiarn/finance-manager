// Generated code from Butter Knife. Do not modify!
package com.mtiarn.finance;

import android.support.annotation.UiThread;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import butterknife.internal.Utils;
import com.mtiarn.finance.widgets.ContextMenuRecyclerView;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;
import java.lang.IllegalStateException;
import java.lang.Override;

public class FragmentTransactions_ViewBinding extends BaseListFragment_ViewBinding {
  private FragmentTransactions target;

  @UiThread
  public FragmentTransactions_ViewBinding(FragmentTransactions target, View source) {
    super(target, source);

    this.target = target;

    target.layoutSumTable = Utils.findRequiredViewAsType(source, R.id.layoutSummaryTable, "field 'layoutSumTable'", TableLayout.class);
    target.switchAllFilters = Utils.findRequiredViewAsType(source, R.id.switch_all_filters, "field 'switchAllFilters'", SwitchCompat.class);
    target.recyclerViewFilters = Utils.findRequiredViewAsType(source, R.id.recycler_view_filters, "field 'recyclerViewFilters'", ContextMenuRecyclerView.class);
    target.mFabGoTop = Utils.findRequiredViewAsType(source, R.id.fabGoTop, "field 'mFabGoTop'", FloatingActionButton.class);
    target.mFabSelectAll = Utils.findRequiredViewAsType(source, R.id.fabSelectAll, "field 'mFabSelectAll'", FloatingActionButton.class);
    target.mFabUnselectAll = Utils.findRequiredViewAsType(source, R.id.fabUnselectAll, "field 'mFabUnselectAll'", FloatingActionButton.class);
    target.mFabEditSelected = Utils.findRequiredViewAsType(source, R.id.fabEditSelected, "field 'mFabEditSelected'", FloatingActionButton.class);
    target.mFabExportSelected = Utils.findRequiredViewAsType(source, R.id.fabExportSelected, "field 'mFabExportSelected'", FloatingActionButton.class);
    target.mFabDeleteSelected = Utils.findRequiredViewAsType(source, R.id.fabDeleteSelected, "field 'mFabDeleteSelected'", FloatingActionButton.class);
    target.mSlidingLayoutTransactions = Utils.findRequiredViewAsType(source, R.id.sliding_layout_transactions, "field 'mSlidingLayoutTransactions'", SlidingUpPanelLayout.class);
    target.mEditTextSearch = Utils.findRequiredViewAsType(source, R.id.editTextSearch, "field 'mEditTextSearch'", EditText.class);
    target.mImageButtonClearSearchString = Utils.findRequiredViewAsType(source, R.id.imageButtonClearSearchString, "field 'mImageButtonClearSearchString'", ImageButton.class);
    target.mCardViewSearch = Utils.findRequiredViewAsType(source, R.id.cardViewSearch, "field 'mCardViewSearch'", ConstraintLayout.class);
    target.mDragView = Utils.findRequiredViewAsType(source, R.id.dragView, "field 'mDragView'", LinearLayout.class);
    target.mTextViewSelectedCount = Utils.findRequiredViewAsType(source, R.id.textViewSelectedCount, "field 'mTextViewSelectedCount'", TextView.class);
    target.mImageViewPullMe = Utils.findRequiredViewAsType(source, R.id.imageViewPullMe, "field 'mImageViewPullMe'", ImageView.class);
    target.mSlidingPanelHeader = Utils.findRequiredView(source, R.id.sliding_panel_header, "field 'mSlidingPanelHeader'");
    target.mButtonSearch = Utils.findRequiredViewAsType(source, R.id.buttonSearch, "field 'mButtonSearch'", Button.class);
    target.mButtonReports = Utils.findRequiredViewAsType(source, R.id.buttonReports, "field 'mButtonReports'", Button.class);
    target.mButtonAddFilter = Utils.findRequiredViewAsType(source, R.id.buttonAddFilter, "field 'mButtonAddFilter'", Button.class);
    target.mButtonClearFilters = Utils.findRequiredViewAsType(source, R.id.buttonClearfilters, "field 'mButtonClearFilters'", Button.class);
    target.mFabSelectAllLayout = Utils.findRequiredViewAsType(source, R.id.fabSelectAllLayout, "field 'mFabSelectAllLayout'", LinearLayout.class);
    target.mFabUnselectAllLayout = Utils.findRequiredViewAsType(source, R.id.fabUnselectAllLayout, "field 'mFabUnselectAllLayout'", LinearLayout.class);
    target.mFabEditSelectedLayout = Utils.findRequiredViewAsType(source, R.id.fabEditSelectedLayout, "field 'mFabEditSelectedLayout'", LinearLayout.class);
    target.mFabExportSelectedLayout = Utils.findRequiredViewAsType(source, R.id.fabExportSelectedLayout, "field 'mFabExportSelectedLayout'", LinearLayout.class);
    target.mFabDeleteSelectedLayout = Utils.findRequiredViewAsType(source, R.id.fabDeleteSelectedLayout, "field 'mFabDeleteSelectedLayout'", LinearLayout.class);
    target.mFabMenuButtonRoot = Utils.findRequiredViewAsType(source, R.id.fabMenuButtonRoot, "field 'mFabMenuButtonRoot'", FloatingActionButton.class);
    target.mFabMenuButtonRootLayout = Utils.findRequiredViewAsType(source, R.id.fabMenuButtonRootLayout, "field 'mFabMenuButtonRootLayout'", LinearLayout.class);
    target.mFabBGLayout = Utils.findRequiredView(source, R.id.fabBGLayout, "field 'mFabBGLayout'");
  }

  @Override
  public void unbind() {
    FragmentTransactions target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.layoutSumTable = null;
    target.switchAllFilters = null;
    target.recyclerViewFilters = null;
    target.mFabGoTop = null;
    target.mFabSelectAll = null;
    target.mFabUnselectAll = null;
    target.mFabEditSelected = null;
    target.mFabExportSelected = null;
    target.mFabDeleteSelected = null;
    target.mSlidingLayoutTransactions = null;
    target.mEditTextSearch = null;
    target.mImageButtonClearSearchString = null;
    target.mCardViewSearch = null;
    target.mDragView = null;
    target.mTextViewSelectedCount = null;
    target.mImageViewPullMe = null;
    target.mSlidingPanelHeader = null;
    target.mButtonSearch = null;
    target.mButtonReports = null;
    target.mButtonAddFilter = null;
    target.mButtonClearFilters = null;
    target.mFabSelectAllLayout = null;
    target.mFabUnselectAllLayout = null;
    target.mFabEditSelectedLayout = null;
    target.mFabExportSelectedLayout = null;
    target.mFabDeleteSelectedLayout = null;
    target.mFabMenuButtonRoot = null;
    target.mFabMenuButtonRootLayout = null;
    target.mFabBGLayout = null;

    super.unbind();
  }
}
