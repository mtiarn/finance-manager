// Generated code from Butter Knife. Do not modify!
package com.mtiarn.finance;

import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.internal.Utils;
import com.mtiarn.finance.widgets.ToolbarActivity_ViewBinding;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ActivityPro_ViewBinding extends ToolbarActivity_ViewBinding {
  private ActivityPro target;

  @UiThread
  public ActivityPro_ViewBinding(ActivityPro target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ActivityPro_ViewBinding(ActivityPro target, View source) {
    super(target, source);

    this.target = target;

    target.recyclerView = Utils.findRequiredViewAsType(source, R.id.recycler_view, "field 'recyclerView'", RecyclerView.class);
  }

  @Override
  public void unbind() {
    ActivityPro target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.recyclerView = null;

    super.unbind();
  }
}
