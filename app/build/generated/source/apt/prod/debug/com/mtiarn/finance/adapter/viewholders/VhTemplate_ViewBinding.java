// Generated code from Butter Knife. Do not modify!
package com.mtiarn.finance.adapter.viewholders;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.mtiarn.finance.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class VhTemplate_ViewBinding implements Unbinder {
  private VhTemplate target;

  @UiThread
  public VhTemplate_ViewBinding(VhTemplate target, View source) {
    this.target = target;

    target.textViewAmount = Utils.findRequiredViewAsType(source, R.id.textViewAmount, "field 'textViewAmount'", TextView.class);
    target.imageViewIcon = Utils.findRequiredViewAsType(source, R.id.imageview_icon, "field 'imageViewIcon'", ImageView.class);
    target.mSpaceBottom = Utils.findRequiredViewAsType(source, R.id.spaceBottom, "field 'mSpaceBottom'", FrameLayout.class);
    target.mSpaceBottomFinal = Utils.findRequiredViewAsType(source, R.id.spaceBottomFinal, "field 'mSpaceBottomFinal'", FrameLayout.class);
    target.textViewName = Utils.findRequiredViewAsType(source, R.id.textViewName, "field 'textViewName'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    VhTemplate target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.textViewAmount = null;
    target.imageViewIcon = null;
    target.mSpaceBottom = null;
    target.mSpaceBottomFinal = null;
    target.textViewName = null;
  }
}
