// Generated code from Butter Knife. Do not modify!
package com.mtiarn.finance;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.LinearLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import java.lang.IllegalStateException;
import java.lang.Override;

public class FragmentBarChart_ViewBinding implements Unbinder {
  private FragmentBarChart target;

  @UiThread
  public FragmentBarChart_ViewBinding(FragmentBarChart target, View source) {
    this.target = target;

    target.mBarChart = Utils.findRequiredViewAsType(source, R.id.barChart, "field 'mBarChart'", HorizontalBarChart.class);
    target.mFab = Utils.findRequiredViewAsType(source, R.id.fab, "field 'mFab'", FloatingActionButton.class);
    target.mFabLayout = Utils.findRequiredViewAsType(source, R.id.fabLayout, "field 'mFabLayout'", LinearLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    FragmentBarChart target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mBarChart = null;
    target.mFab = null;
    target.mFabLayout = null;
  }
}
