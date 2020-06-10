// Generated code from Butter Knife. Do not modify!
package com.mtiarn.finance.widgets;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.mtiarn.finance.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AmountEditor_ViewBinding implements Unbinder {
  private AmountEditor target;

  private View view2131296604;

  @UiThread
  public AmountEditor_ViewBinding(AmountEditor target) {
    this(target, target);
  }

  @UiThread
  public AmountEditor_ViewBinding(final AmountEditor target, View source) {
    this.target = target;

    View view;
    target.btnAmountSign = Utils.findRequiredViewAsType(source, R.id.imagebutton_amount_sign, "field 'btnAmountSign'", ImageButton.class);
    target.edAmount = Utils.findRequiredViewAsType(source, R.id.edittext_amount, "field 'edAmount'", EditText.class);
    view = Utils.findRequiredView(source, R.id.imageButtonCalc, "field 'btnCalc' and method 'onCalculatorClick'");
    target.btnCalc = Utils.castView(view, R.id.imageButtonCalc, "field 'btnCalc'", ImageButton.class);
    view2131296604 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onCalculatorClick();
      }
    });
    target.spinnerCabbage = Utils.findRequiredViewAsType(source, R.id.editTextCabbage, "field 'spinnerCabbage'", EditText.class);
    target.mTextInputLayoutCabbage = Utils.findRequiredViewAsType(source, R.id.textInputLayoutCabbage, "field 'mTextInputLayoutCabbage'", TextInputLayout.class);
    target.mTextInputLayoutAmount = Utils.findRequiredViewAsType(source, R.id.textInputLayoutAmount, "field 'mTextInputLayoutAmount'", TextInputLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    AmountEditor target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.btnAmountSign = null;
    target.edAmount = null;
    target.btnCalc = null;
    target.spinnerCabbage = null;
    target.mTextInputLayoutCabbage = null;
    target.mTextInputLayoutAmount = null;

    view2131296604.setOnClickListener(null);
    view2131296604 = null;
  }
}
