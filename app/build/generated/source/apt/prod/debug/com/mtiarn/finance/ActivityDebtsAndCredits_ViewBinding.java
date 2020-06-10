// Generated code from Butter Knife. Do not modify!
package com.mtiarn.finance;

import android.support.annotation.UiThread;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import butterknife.internal.Utils;
import com.mtiarn.finance.widgets.ToolbarActivity_ViewBinding;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ActivityDebtsAndCredits_ViewBinding extends ToolbarActivity_ViewBinding {
  private ActivityDebtsAndCredits target;

  @UiThread
  public ActivityDebtsAndCredits_ViewBinding(ActivityDebtsAndCredits target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ActivityDebtsAndCredits_ViewBinding(ActivityDebtsAndCredits target, View source) {
    super(target, source);

    this.target = target;

    target.viewPager = Utils.findRequiredViewAsType(source, R.id.viewPager, "field 'viewPager'", ViewPager.class);
    target.tabLayout = Utils.findRequiredViewAsType(source, R.id.tabLayout, "field 'tabLayout'", TabLayout.class);
  }

  @Override
  public void unbind() {
    ActivityDebtsAndCredits target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.viewPager = null;
    target.tabLayout = null;

    super.unbind();
  }
}
