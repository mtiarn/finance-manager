// Generated code from Butter Knife. Do not modify!
package com.mtiarn.finance;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.EditText;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class FragmentSortAccounts_ViewBinding implements Unbinder {
  private FragmentSortAccounts target;

  @UiThread
  public FragmentSortAccounts_ViewBinding(FragmentSortAccounts target, View source) {
    this.target = target;

    target.spinnerSortType = Utils.findRequiredViewAsType(source, R.id.spinnerSortType, "field 'spinnerSortType'", EditText.class);
    target.spinnerSortOrder = Utils.findRequiredViewAsType(source, R.id.spinnerSortOrder, "field 'spinnerSortOrder'", EditText.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    FragmentSortAccounts target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.spinnerSortType = null;
    target.spinnerSortOrder = null;
  }
}
