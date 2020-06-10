// Generated code from Butter Knife. Do not modify!
package com.mtiarn.finance.adapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.mtiarn.finance.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AdapterBudget$BudgetViewHolder_ViewBinding implements Unbinder {
  private AdapterBudget.BudgetViewHolder target;

  @UiThread
  public AdapterBudget$BudgetViewHolder_ViewBinding(AdapterBudget.BudgetViewHolder target,
      View source) {
    this.target = target;

    target.textViewCategoryName = Utils.findRequiredViewAsType(source, R.id.textViewModelName, "field 'textViewCategoryName'", TextView.class);
    target.container = Utils.findRequiredViewAsType(source, R.id.container, "field 'container'", LinearLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    AdapterBudget.BudgetViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.textViewCategoryName = null;
    target.container = null;
  }
}
