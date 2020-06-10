// Generated code from Butter Knife. Do not modify!
package com.mtiarn.finance.adapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.mtiarn.finance.R;
import eu.davidea.flipview.FlipView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AdapterTabOrder$ViewHolderTabOrder_ViewBinding implements Unbinder {
  private AdapterTabOrder.ViewHolderTabOrder target;

  @UiThread
  public AdapterTabOrder$ViewHolderTabOrder_ViewBinding(AdapterTabOrder.ViewHolderTabOrder target,
      View source) {
    this.target = target;

    target.dragHandle = Utils.findRequiredViewAsType(source, R.id.drag_handle, "field 'dragHandle'", FlipView.class);
    target.textViewModelName = Utils.findRequiredViewAsType(source, R.id.textViewModelName, "field 'textViewModelName'", TextView.class);
    target.expandableIndicator = Utils.findRequiredViewAsType(source, R.id.expandableIndicator, "field 'expandableIndicator'", ImageView.class);
    target.container = Utils.findRequiredViewAsType(source, R.id.container, "field 'container'", ConstraintLayout.class);
    target.colorTag = Utils.findRequiredViewAsType(source, R.id.color_tag, "field 'colorTag'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    AdapterTabOrder.ViewHolderTabOrder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.dragHandle = null;
    target.textViewModelName = null;
    target.expandableIndicator = null;
    target.container = null;
    target.colorTag = null;
  }
}