// Generated code from Butter Knife. Do not modify!
package com.mtiarn.finance.widgets;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.Toolbar;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.mtiarn.finance.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ToolbarActivity_ViewBinding implements Unbinder {
  private ToolbarActivity target;

  @UiThread
  public ToolbarActivity_ViewBinding(ToolbarActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ToolbarActivity_ViewBinding(ToolbarActivity target, View source) {
    this.target = target;

    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ToolbarActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.toolbar = null;
  }
}
