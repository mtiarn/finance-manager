// Generated code from Butter Knife. Do not modify!
package com.mtiarn.finance;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.AppCompatCheckBox;
import android.view.View;
import android.widget.EditText;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class FragmentCopyBudget_ViewBinding implements Unbinder {
  private FragmentCopyBudget target;

  @UiThread
  public FragmentCopyBudget_ViewBinding(FragmentCopyBudget target, View source) {
    this.target = target;

    target.editTextYear = Utils.findRequiredViewAsType(source, R.id.editTextYear, "field 'editTextYear'", EditText.class);
    target.textViewMonth = Utils.findRequiredViewAsType(source, R.id.textViewMonth, "field 'textViewMonth'", EditText.class);
    target.checkboxReplaceExists = Utils.findRequiredViewAsType(source, R.id.checkboxReplaceExists, "field 'checkboxReplaceExists'", AppCompatCheckBox.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    FragmentCopyBudget target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.editTextYear = null;
    target.textViewMonth = null;
    target.checkboxReplaceExists = null;
  }
}
