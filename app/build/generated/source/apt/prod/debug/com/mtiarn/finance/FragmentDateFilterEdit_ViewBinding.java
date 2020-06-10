// Generated code from Butter Knife. Do not modify!
package com.mtiarn.finance;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class FragmentDateFilterEdit_ViewBinding implements Unbinder {
  private FragmentDateFilterEdit target;

  @UiThread
  public FragmentDateFilterEdit_ViewBinding(FragmentDateFilterEdit target, View source) {
    this.target = target;

    target.mRadioButtonDateRangeCurrent = Utils.findRequiredViewAsType(source, R.id.radioButtonDateRangeCurrent, "field 'mRadioButtonDateRangeCurrent'", RadioButton.class);
    target.mRadioButtonDateRangePast = Utils.findRequiredViewAsType(source, R.id.radioButtonDateRangeLast, "field 'mRadioButtonDateRangePast'", RadioButton.class);
    target.mRadioButtonDateRangeCurrentAndPast = Utils.findRequiredViewAsType(source, R.id.radioButtonDateRangeCurrentAndLast, "field 'mRadioButtonDateRangeCurrentAndPast'", RadioButton.class);
    target.mRadioGroupModifier = Utils.findRequiredViewAsType(source, R.id.radioGroupModifier, "field 'mRadioGroupModifier'", RadioGroup.class);
    target.mRadioButtonDateRangeDay = Utils.findRequiredViewAsType(source, R.id.radioButtonDateRangeDay, "field 'mRadioButtonDateRangeDay'", RadioButton.class);
    target.mRadioButtonDateRangeWeek = Utils.findRequiredViewAsType(source, R.id.radioButtonDateRangeWeek, "field 'mRadioButtonDateRangeWeek'", RadioButton.class);
    target.mRadioButtonDateRangeMonth = Utils.findRequiredViewAsType(source, R.id.radioButtonDateRangeMonth, "field 'mRadioButtonDateRangeMonth'", RadioButton.class);
    target.mRadioButtonDateRangeYear = Utils.findRequiredViewAsType(source, R.id.radioButtonDateRangeYear, "field 'mRadioButtonDateRangeYear'", RadioButton.class);
    target.mRadioGroupRange = Utils.findRequiredViewAsType(source, R.id.radioGroupRange, "field 'mRadioGroupRange'", RadioGroup.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    FragmentDateFilterEdit target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mRadioButtonDateRangeCurrent = null;
    target.mRadioButtonDateRangePast = null;
    target.mRadioButtonDateRangeCurrentAndPast = null;
    target.mRadioGroupModifier = null;
    target.mRadioButtonDateRangeDay = null;
    target.mRadioButtonDateRangeWeek = null;
    target.mRadioButtonDateRangeMonth = null;
    target.mRadioButtonDateRangeYear = null;
    target.mRadioGroupRange = null;
  }
}
