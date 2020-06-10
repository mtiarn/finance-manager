// Generated code from Butter Knife. Do not modify!
package com.mtiarn.finance;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.ImageButton;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class FragmentPayee_ViewBinding implements Unbinder {
  private FragmentPayee target;

  @UiThread
  public FragmentPayee_ViewBinding(FragmentPayee target, View source) {
    this.target = target;

    target.edPayee = Utils.findRequiredViewAsType(source, R.id.editTextPayee, "field 'edPayee'", AutoCompleteTextView.class);
    target.mTextInputLayoutPayee = Utils.findRequiredViewAsType(source, R.id.textInputLayoutPayee, "field 'mTextInputLayoutPayee'", TextInputLayout.class);
    target.mImageButtonDeletePayee = Utils.findRequiredViewAsType(source, R.id.imageButtonDeletePayee, "field 'mImageButtonDeletePayee'", ImageButton.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    FragmentPayee target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.edPayee = null;
    target.mTextInputLayoutPayee = null;
    target.mImageButtonDeletePayee = null;
  }
}
