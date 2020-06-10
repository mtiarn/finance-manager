// Generated code from Butter Knife. Do not modify!
package com.mtiarn.finance;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.mtiarn.finance.widgets.ContextMenuRecyclerView;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;
import java.lang.IllegalStateException;
import java.lang.Override;

public class FragmentBudget_ViewBinding implements Unbinder {
  private FragmentBudget target;

  @UiThread
  public FragmentBudget_ViewBinding(FragmentBudget target, View source) {
    this.target = target;

    target.recyclerView = Utils.findRequiredViewAsType(source, R.id.recycler_view, "field 'recyclerView'", ContextMenuRecyclerView.class);
    target.recyclerViewSummary = Utils.findRequiredViewAsType(source, R.id.recycler_view_summary, "field 'recyclerViewSummary'", RecyclerView.class);
    target.layoutSumTable = Utils.findRequiredViewAsType(source, R.id.layoutSummaryTable, "field 'layoutSumTable'", TableLayout.class);
    target.fabAddCategory = Utils.findRequiredViewAsType(source, R.id.fabAddModel, "field 'fabAddCategory'", FloatingActionButton.class);
    target.fabAddDebt = Utils.findRequiredViewAsType(source, R.id.fabAddDebt, "field 'fabAddDebt'", FloatingActionButton.class);
    target.fabCopyBudget = Utils.findRequiredViewAsType(source, R.id.fabCopyBudget, "field 'fabCopyBudget'", FloatingActionButton.class);
    target.fabCreateFromFact = Utils.findRequiredViewAsType(source, R.id.fabCreateFromFact, "field 'fabCreateFromFact'", FloatingActionButton.class);
    target.fabClearBudget = Utils.findRequiredViewAsType(source, R.id.fabClearBudget, "field 'fabClearBudget'", FloatingActionButton.class);
    target.mSlidingUpPanelLayout = Utils.findRequiredViewAsType(source, R.id.sliding_layout, "field 'mSlidingUpPanelLayout'", SlidingUpPanelLayout.class);
    target.mImageViewPullMe = Utils.findRequiredViewAsType(source, R.id.imageViewPullMe, "field 'mImageViewPullMe'", ImageView.class);
    target.mFabBGLayout = Utils.findRequiredView(source, R.id.fabBGLayout, "field 'mFabBGLayout'");
    target.mFabAddModelLayout = Utils.findRequiredViewAsType(source, R.id.fabAddModelLayout, "field 'mFabAddModelLayout'", LinearLayout.class);
    target.mFabAddDebtLayout = Utils.findRequiredViewAsType(source, R.id.fabAddDebtLayout, "field 'mFabAddDebtLayout'", LinearLayout.class);
    target.mFabCopyBudgetLayout = Utils.findRequiredViewAsType(source, R.id.fabCopyBudgetLayout, "field 'mFabCopyBudgetLayout'", LinearLayout.class);
    target.mFabCreateFromFactLayout = Utils.findRequiredViewAsType(source, R.id.fabCreateFromFactLayout, "field 'mFabCreateFromFactLayout'", LinearLayout.class);
    target.mFabClearBudgetLayout = Utils.findRequiredViewAsType(source, R.id.fabClearBudgetLayout, "field 'mFabClearBudgetLayout'", LinearLayout.class);
    target.mFabMenuButtonRoot = Utils.findRequiredViewAsType(source, R.id.fabMenuButtonRoot, "field 'mFabMenuButtonRoot'", FloatingActionButton.class);
    target.mFabMenuButtonRootLayout = Utils.findRequiredViewAsType(source, R.id.fabMenuButtonRootLayout, "field 'mFabMenuButtonRootLayout'", LinearLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    FragmentBudget target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.recyclerView = null;
    target.recyclerViewSummary = null;
    target.layoutSumTable = null;
    target.fabAddCategory = null;
    target.fabAddDebt = null;
    target.fabCopyBudget = null;
    target.fabCreateFromFact = null;
    target.fabClearBudget = null;
    target.mSlidingUpPanelLayout = null;
    target.mImageViewPullMe = null;
    target.mFabBGLayout = null;
    target.mFabAddModelLayout = null;
    target.mFabAddDebtLayout = null;
    target.mFabCopyBudgetLayout = null;
    target.mFabCreateFromFactLayout = null;
    target.mFabClearBudgetLayout = null;
    target.mFabMenuButtonRoot = null;
    target.mFabMenuButtonRootLayout = null;
  }
}
