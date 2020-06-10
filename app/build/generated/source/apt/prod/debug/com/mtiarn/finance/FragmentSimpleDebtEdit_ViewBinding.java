// Generated code from Butter Knife. Do not modify!
package com.mtiarn.finance;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.mtiarn.finance.widgets.AmountEditor;
import java.lang.IllegalStateException;
import java.lang.Override;

public class FragmentSimpleDebtEdit_ViewBinding implements Unbinder {
  private FragmentSimpleDebtEdit target;

  @UiThread
  public FragmentSimpleDebtEdit_ViewBinding(FragmentSimpleDebtEdit target, View source) {
    this.target = target;

    target.editTextName = Utils.findRequiredViewAsType(source, R.id.edit_text_name, "field 'editTextName'", EditText.class);
    target.mCheckBoxClosed = Utils.findRequiredViewAsType(source, R.id.checkBoxClosed, "field 'mCheckBoxClosed'", CheckBox.class);
    target.amountEditorStartAmount = Utils.findRequiredViewAsType(source, R.id.amountEditorStartAmount, "field 'amountEditorStartAmount'", AmountEditor.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    FragmentSimpleDebtEdit target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.editTextName = null;
    target.mCheckBoxClosed = null;
    target.amountEditorStartAmount = null;
  }
}
