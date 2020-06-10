// Generated code from Butter Knife. Do not modify!
package com.mtiarn.finance;

import android.support.annotation.UiThread;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.AppCompatCheckBox;
import android.view.View;
import android.widget.EditText;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.mtiarn.finance.widgets.AmountEditor;
import com.mtiarn.finance.widgets.ToolbarActivity_ViewBinding;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ActivityEditAccount_ViewBinding extends ToolbarActivity_ViewBinding {
  private ActivityEditAccount target;

  private View view2131296376;

  @UiThread
  public ActivityEditAccount_ViewBinding(ActivityEditAccount target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ActivityEditAccount_ViewBinding(final ActivityEditAccount target, View source) {
    super(target, source);

    this.target = target;

    View view;
    target.editTextName = Utils.findRequiredViewAsType(source, R.id.editTextName, "field 'editTextName'", EditText.class);
    target.editTextType = Utils.findRequiredViewAsType(source, R.id.editTextType, "field 'editTextType'", EditText.class);
    target.editTextCabbage = Utils.findRequiredViewAsType(source, R.id.editTextCabbage, "field 'editTextCabbage'", EditText.class);
    target.editTextEmitent = Utils.findRequiredViewAsType(source, R.id.editTextEmitent, "field 'editTextEmitent'", EditText.class);
    target.editTextLast4Digits = Utils.findRequiredViewAsType(source, R.id.editTextLast4Digits, "field 'editTextLast4Digits'", EditText.class);
    target.editTextComment = Utils.findRequiredViewAsType(source, R.id.editTextComment, "field 'editTextComment'", EditText.class);
    target.amountEditorStartBalance = Utils.findRequiredViewAsType(source, R.id.amountEditorStartBalance, "field 'amountEditorStartBalance'", AmountEditor.class);
    target.checkboxAccountClosed = Utils.findRequiredViewAsType(source, R.id.checkboxAccountClosed, "field 'checkboxAccountClosed'", AppCompatCheckBox.class);
    target.amountEditorCreditLimit = Utils.findRequiredViewAsType(source, R.id.amountEditorCreditLimit, "field 'amountEditorCreditLimit'", AmountEditor.class);
    target.mTextInputLayoutEmitent = Utils.findRequiredViewAsType(source, R.id.textInputLayoutEmitent, "field 'mTextInputLayoutEmitent'", TextInputLayout.class);
    target.mTextInputLayoutLast4Digits = Utils.findRequiredViewAsType(source, R.id.textInputLayoutLast4Digits, "field 'mTextInputLayoutLast4Digits'", TextInputLayout.class);
    target.mTextInputLayoutName = Utils.findRequiredViewAsType(source, R.id.textInputLayoutName, "field 'mTextInputLayoutName'", TextInputLayout.class);
    target.mTextInputLayoutCabbage = Utils.findRequiredViewAsType(source, R.id.textInputLayoutCabbage, "field 'mTextInputLayoutCabbage'", TextInputLayout.class);
    view = Utils.findRequiredView(source, R.id.buttonSaveAccount, "method 'onSaveClick'");
    view2131296376 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onSaveClick();
      }
    });
  }

  @Override
  public void unbind() {
    ActivityEditAccount target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.editTextName = null;
    target.editTextType = null;
    target.editTextCabbage = null;
    target.editTextEmitent = null;
    target.editTextLast4Digits = null;
    target.editTextComment = null;
    target.amountEditorStartBalance = null;
    target.checkboxAccountClosed = null;
    target.amountEditorCreditLimit = null;
    target.mTextInputLayoutEmitent = null;
    target.mTextInputLayoutLast4Digits = null;
    target.mTextInputLayoutName = null;
    target.mTextInputLayoutCabbage = null;

    view2131296376.setOnClickListener(null);
    view2131296376 = null;

    super.unbind();
  }
}
