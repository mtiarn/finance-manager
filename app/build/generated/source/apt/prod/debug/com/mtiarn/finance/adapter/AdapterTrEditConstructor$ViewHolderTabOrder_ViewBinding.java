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

public class AdapterTrEditConstructor$ViewHolderTabOrder_ViewBinding implements Unbinder {
  private AdapterTrEditConstructor.ViewHolderTabOrder target;

  @UiThread
  public AdapterTrEditConstructor$ViewHolderTabOrder_ViewBinding(AdapterTrEditConstructor.ViewHolderTabOrder target,
      View source) {
    this.target = target;

    target.dragHandle = Utils.findRequiredViewAsType(source, R.id.drag_handle, "field 'dragHandle'", ImageView.class);
    target.textViewModelName = Utils.findRequiredViewAsType(source, R.id.textViewModelName, "field 'textViewModelName'", TextView.class);
    target.container = Utils.findRequiredViewAsType(source, R.id.container, "field 'container'", ConstraintLayout.class);
    target.mFlipViewVisible = Utils.findRequiredViewAsType(source, R.id.flip_view_visible, "field 'mFlipViewVisible'", FlipView.class);
    target.mflipViewHideUnderMore = Utils.findRequiredViewAsType(source, R.id.flip_view_hide_under_more, "field 'mflipViewHideUnderMore'", FlipView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    AdapterTrEditConstructor.ViewHolderTabOrder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.dragHandle = null;
    target.textViewModelName = null;
    target.container = null;
    target.mFlipViewVisible = null;
    target.mflipViewHideUnderMore = null;
  }
}
