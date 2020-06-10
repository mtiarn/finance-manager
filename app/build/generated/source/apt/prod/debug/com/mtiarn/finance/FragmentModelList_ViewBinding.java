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

public class FragmentModelList_ViewBinding implements Unbinder {
  private FragmentModelList target;

  @UiThread
  public FragmentModelList_ViewBinding(FragmentModelList target, View source) {
    this.target = target;

    target.mRecyclerView = Utils.findRequiredViewAsType(source, R.id.recycler_view, "field 'mRecyclerView'", ContextMenuRecyclerView.class);
    target.mButtonAddAccountMarker = Utils.findRequiredViewAsType(source, R.id.buttonAddAccountMarker, "field 'mButtonAddAccountMarker'", FloatingActionButton.class);
    target.mButtonAddCabbageMarker = Utils.findRequiredViewAsType(source, R.id.buttonAddCabbageMarker, "field 'mButtonAddCabbageMarker'", FloatingActionButton.class);
    target.mButtonAddTrTypeMarker = Utils.findRequiredViewAsType(source, R.id.buttonAddTrTypeMarker, "field 'mButtonAddTrTypeMarker'", FloatingActionButton.class);
    target.mButtonAddPayeeMarker = Utils.findRequiredViewAsType(source, R.id.buttonAddPayeeMarker, "field 'mButtonAddPayeeMarker'", FloatingActionButton.class);
    target.mButtonAddIgnoreMarker = Utils.findRequiredViewAsType(source, R.id.buttonAddIgnoreMarker, "field 'mButtonAddIgnoreMarker'", FloatingActionButton.class);
    target.mFabBGLayout = Utils.findRequiredView(source, R.id.fabBGLayout, "field 'mFabBGLayout'");
    target.mButtonAddAccountMarkerLayout = Utils.findRequiredViewAsType(source, R.id.buttonAddAccountMarkerLayout, "field 'mButtonAddAccountMarkerLayout'", LinearLayout.class);
    target.mButtonAddCabbageMarkerLayout = Utils.findRequiredViewAsType(source, R.id.buttonAddCabbageMarkerLayout, "field 'mButtonAddCabbageMarkerLayout'", LinearLayout.class);
    target.mButtonAddTrTypeMarkerLayout = Utils.findRequiredViewAsType(source, R.id.buttonAddTrTypeMarkerLayout, "field 'mButtonAddTrTypeMarkerLayout'", LinearLayout.class);
    target.mButtonAddPayeeMarkerLayout = Utils.findRequiredViewAsType(source, R.id.buttonAddPayeeMarkerLayout, "field 'mButtonAddPayeeMarkerLayout'", LinearLayout.class);
    target.mButtonAddIgnoreMarkerLayout = Utils.findRequiredViewAsType(source, R.id.buttonAddIgnoreMarkerLayout, "field 'mButtonAddIgnoreMarkerLayout'", LinearLayout.class);
    target.mFabMenuButtonRoot = Utils.findRequiredViewAsType(source, R.id.fabMenuButtonRoot, "field 'mFabMenuButtonRoot'", FloatingActionButton.class);
    target.mFabMenuButtonRootLayout = Utils.findRequiredViewAsType(source, R.id.fabMenuButtonRootLayout, "field 'mFabMenuButtonRootLayout'", LinearLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    FragmentModelList target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mRecyclerView = null;
    target.mButtonAddAccountMarker = null;
    target.mButtonAddCabbageMarker = null;
    target.mButtonAddTrTypeMarker = null;
    target.mButtonAddPayeeMarker = null;
    target.mButtonAddIgnoreMarker = null;
    target.mFabBGLayout = null;
    target.mButtonAddAccountMarkerLayout = null;
    target.mButtonAddCabbageMarkerLayout = null;
    target.mButtonAddTrTypeMarkerLayout = null;
    target.mButtonAddPayeeMarkerLayout = null;
    target.mButtonAddIgnoreMarkerLayout = null;
    target.mFabMenuButtonRoot = null;
    target.mFabMenuButtonRootLayout = null;
  }
}
