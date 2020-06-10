// Generated code from Butter Knife. Do not modify!
package com.mtiarn.finance.adapter.viewholders;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.mtiarn.finance.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class UserPermissionViewHolder_ViewBinding implements Unbinder {
  private UserPermissionViewHolder target;

  @UiThread
  public UserPermissionViewHolder_ViewBinding(UserPermissionViewHolder target, View source) {
    this.target = target;

    target.imageViewIcon = Utils.findRequiredViewAsType(source, R.id.imageViewIcon, "field 'imageViewIcon'", ImageView.class);
    target.mTextViewEmail = Utils.findRequiredViewAsType(source, R.id.textViewEmail, "field 'mTextViewEmail'", TextView.class);
    target.mCheckBoxRead = Utils.findRequiredViewAsType(source, R.id.checkBoxRead, "field 'mCheckBoxRead'", CheckBox.class);
    target.mCheckBoxWrite = Utils.findRequiredViewAsType(source, R.id.checkBoxWrite, "field 'mCheckBoxWrite'", CheckBox.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    UserPermissionViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.imageViewIcon = null;
    target.mTextViewEmail = null;
    target.mCheckBoxRead = null;
    target.mCheckBoxWrite = null;
  }
}
