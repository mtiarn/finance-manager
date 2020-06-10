// Generated code from Butter Knife. Do not modify!
package com.mtiarn.finance;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.widget.EditText;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class FragmentSmsMarkerEdit_ViewBinding implements Unbinder {
  private FragmentSmsMarkerEdit target;

  @UiThread
  public FragmentSmsMarkerEdit_ViewBinding(FragmentSmsMarkerEdit target, View source) {
    this.target = target;

    target.editTextObject = Utils.findRequiredViewAsType(source, R.id.editTextObject, "field 'editTextObject'", EditText.class);
    target.editTextValue = Utils.findRequiredViewAsType(source, R.id.editTextValue, "field 'editTextValue'", EditText.class);
    target.textViewObject = Utils.findRequiredViewAsType(source, R.id.textViewObject, "field 'textViewObject'", EditText.class);
    target.editTextType = Utils.findRequiredViewAsType(source, R.id.editTextType, "field 'editTextType'", EditText.class);
    target.mTextInputLayoutEditTextObject = Utils.findRequiredViewAsType(source, R.id.textInputLayoutEditTextObject, "field 'mTextInputLayoutEditTextObject'", TextInputLayout.class);
    target.mTextInputLayoutTextViewObject = Utils.findRequiredViewAsType(source, R.id.textInputLayoutTextViewObject, "field 'mTextInputLayoutTextViewObject'", TextInputLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    FragmentSmsMarkerEdit target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.editTextObject = null;
    target.editTextValue = null;
    target.textViewObject = null;
    target.editTextType = null;
    target.mTextInputLayoutEditTextObject = null;
    target.mTextInputLayoutTextViewObject = null;
  }
}
