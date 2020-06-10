// Generated code from Butter Knife. Do not modify!
package com.mtiarn.finance;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.github.mikephil.charting.charts.PieChart;
import java.lang.IllegalStateException;
import java.lang.Override;

public class FragmentPieChart_ViewBinding implements Unbinder {
  private FragmentPieChart target;

  @UiThread
  public FragmentPieChart_ViewBinding(FragmentPieChart target, View source) {
    this.target = target;

    target.mPieChart = Utils.findRequiredViewAsType(source, R.id.pieChart, "field 'mPieChart'", PieChart.class);
    target.mFab = Utils.findRequiredViewAsType(source, R.id.fab, "field 'mFab'", FloatingActionButton.class);
    target.mTextViewSelected = Utils.findRequiredViewAsType(source, R.id.textViewSelected, "field 'mTextViewSelected'", TextView.class);
    target.mImageViewColor = Utils.findRequiredViewAsType(source, R.id.imageViewColor, "field 'mImageViewColor'", ImageView.class);
    target.mFabLayout = Utils.findRequiredViewAsType(source, R.id.fabLayout, "field 'mFabLayout'", LinearLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    FragmentPieChart target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mPieChart = null;
    target.mFab = null;
    target.mTextViewSelected = null;
    target.mImageViewColor = null;
    target.mFabLayout = null;
  }
}
