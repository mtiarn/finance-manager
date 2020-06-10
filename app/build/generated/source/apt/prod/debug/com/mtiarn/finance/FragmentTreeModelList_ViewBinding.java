// Generated code from Butter Knife. Do not modify!
package com.mtiarn.finance;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.LinearLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.mtiarn.finance.widgets.ContextMenuRecyclerView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class FragmentTreeModelList_ViewBinding implements Unbinder {
  private FragmentTreeModelList target;

  @UiThread
  public FragmentTreeModelList_ViewBinding(FragmentTreeModelList target, View source) {
    this.target = target;

    target.mRecyclerView = Utils.findRequiredViewAsType(source, R.id.recycler_view, "field 'mRecyclerView'", ContextMenuRecyclerView.class);
    target.fabAddModel = Utils.findRequiredViewAsType(source, R.id.fabAddModel, "field 'fabAddModel'", FloatingActionButton.class);
    target.fabAddNestedModel = Utils.findRequiredViewAsType(source, R.id.fabAddNestedModel, "field 'fabAddNestedModel'", FloatingActionButton.class);
    target.mFabBGLayout = Utils.findRequiredView(source, R.id.fabBGLayout, "field 'mFabBGLayout'");
    target.mFabAddModelLayout = Utils.findRequiredViewAsType(source, R.id.fabAddModelLayout, "field 'mFabAddModelLayout'", LinearLayout.class);
    target.mFabAddNestedModelLayout = Utils.findRequiredViewAsType(source, R.id.fabAddNestedModelLayout, "field 'mFabAddNestedModelLayout'", LinearLayout.class);
    target.mFabMenuButtonRoot = Utils.findRequiredViewAsType(source, R.id.fabMenuButtonRoot, "field 'mFabMenuButtonRoot'", FloatingActionButton.class);
    target.mFabMenuButtonRootLayout = Utils.findRequiredViewAsType(source, R.id.fabMenuButtonRootLayout, "field 'mFabMenuButtonRootLayout'", LinearLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    FragmentTreeModelList target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mRecyclerView = null;
    target.fabAddModel = null;
    target.fabAddNestedModel = null;
    target.mFabBGLayout = null;
    target.mFabAddModelLayout = null;
    target.mFabAddNestedModelLayout = null;
    target.mFabMenuButtonRoot = null;
    target.mFabMenuButtonRootLayout = null;
  }
}
