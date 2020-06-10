// Generated code from Butter Knife. Do not modify!
package com.mtiarn.finance.adapter.viewholders;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.mtiarn.finance.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class VhSmsMarker_ViewBinding implements Unbinder {
  private VhSmsMarker target;

  @UiThread
  public VhSmsMarker_ViewBinding(VhSmsMarker target, View source) {
    this.target = target;

    target.textViewType = Utils.findRequiredViewAsType(source, R.id.textViewType, "field 'textViewType'", TextView.class);
    target.textViewObject = Utils.findRequiredViewAsType(source, R.id.textViewObject, "field 'textViewObject'", TextView.class);
    target.textViewValue = Utils.findRequiredViewAsType(source, R.id.textViewMarker, "field 'textViewValue'", TextView.class);
    target.mImageViewIcon = Utils.findRequiredViewAsType(source, R.id.imageViewIcon, "field 'mImageViewIcon'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    VhSmsMarker target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.textViewType = null;
    target.textViewObject = null;
    target.textViewValue = null;
    target.mImageViewIcon = null;
  }
}
