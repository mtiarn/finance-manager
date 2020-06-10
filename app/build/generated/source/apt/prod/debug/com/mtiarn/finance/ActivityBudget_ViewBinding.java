// Generated code from Butter Knife. Do not modify!
package com.mtiarn.finance;

import android.support.annotation.UiThread;
import android.support.v4.view.ViewPager;
import android.view.View;
import butterknife.internal.Utils;
import com.mtiarn.finance.widgets.ToolbarActivity_ViewBinding;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ActivityBudget_ViewBinding extends ToolbarActivity_ViewBinding {
  private ActivityBudget target;

  @UiThread
  public ActivityBudget_ViewBinding(ActivityBudget target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ActivityBudget_ViewBinding(ActivityBudget target, View source) {
    super(target, source);

    this.target = target;

    target.viewPager = Utils.findRequiredViewAsType(source, R.id.viewPager, "field 'viewPager'", ViewPager.class);
  }

  @Override
  public void unbind() {
    ActivityBudget target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.viewPager = null;

    super.unbind();
  }
}
