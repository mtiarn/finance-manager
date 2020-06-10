// Generated code from Butter Knife. Do not modify!
package com.mtiarn.finance.adapter;

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

public class AdapterMenuItems$MenuItemViewHolder_ViewBinding implements Unbinder {
  private AdapterMenuItems.MenuItemViewHolder target;

  @UiThread
  public AdapterMenuItems$MenuItemViewHolder_ViewBinding(AdapterMenuItems.MenuItemViewHolder target,
      View source) {
    this.target = target;

    target.imageViewIcon = Utils.findRequiredViewAsType(source, R.id.imageViewIcon, "field 'imageViewIcon'", ImageView.class);
    target.textViewTitle = Utils.findRequiredViewAsType(source, R.id.textViewTitle, "field 'textViewTitle'", TextView.class);
    target.mSpaceBottom = Utils.findRequiredViewAsType(source, R.id.spaceBottom, "field 'mSpaceBottom'", FrameLayout.class);
    target.mSpaceBottomFinal = Utils.findRequiredViewAsType(source, R.id.spaceBottomFinal, "field 'mSpaceBottomFinal'", FrameLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    AdapterMenuItems.MenuItemViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.imageViewIcon = null;
    target.textViewTitle = null;
    target.mSpaceBottom = null;
    target.mSpaceBottomFinal = null;
  }
}
