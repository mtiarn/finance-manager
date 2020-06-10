// Generated code from Butter Knife. Do not modify!
package com.mtiarn.finance;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class FragmentDestAccount_ViewBinding implements Unbinder {
  private FragmentDestAccount target;

  @UiThread
  public FragmentDestAccount_ViewBinding(FragmentDestAccount target, View source) {
    this.target = target;

    target.textViewDestAccount = Utils.findRequiredViewAsType(source, R.id.textViewDestAccount, "field 'textViewDestAccount'", EditText.class);
    target.imageButtonInvertTransferDirection = Utils.findRequiredViewAsType(source, R.id.imageButtonInvertTransferDirection, "field 'imageButtonInvertTransferDirection'", ImageButton.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    FragmentDestAccount target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.textViewDestAccount = null;
    target.imageButtonInvertTransferDirection = null;
  }
}
