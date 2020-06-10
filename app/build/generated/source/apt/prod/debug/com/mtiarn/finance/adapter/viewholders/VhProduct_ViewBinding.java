// Generated code from Butter Knife. Do not modify!
package com.mtiarn.finance.adapter.viewholders;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.mtiarn.finance.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class VhProduct_ViewBinding implements Unbinder {
  private VhProduct target;

  @UiThread
  public VhProduct_ViewBinding(VhProduct target, View source) {
    this.target = target;

    target.textViewName = Utils.findRequiredViewAsType(source, R.id.textViewName, "field 'textViewName'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    VhProduct target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.textViewName = null;
  }
}
