// Generated code from Butter Knife. Do not modify!
package com.mtiarn.finance;

import android.support.annotation.UiThread;
import android.view.View;
import android.widget.LinearLayout;
import butterknife.internal.Utils;
import com.mtiarn.finance.widgets.ToolbarActivity_ViewBinding;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ActivityModelList_ViewBinding extends ToolbarActivity_ViewBinding {
  private ActivityModelList target;

  @UiThread
  public ActivityModelList_ViewBinding(ActivityModelList target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ActivityModelList_ViewBinding(ActivityModelList target, View source) {
    super(target, source);

    this.target = target;

    target.container = Utils.findRequiredViewAsType(source, R.id.container, "field 'container'", LinearLayout.class);
  }

  @Override
  public void unbind() {
    ActivityModelList target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.container = null;

    super.unbind();
  }
}
