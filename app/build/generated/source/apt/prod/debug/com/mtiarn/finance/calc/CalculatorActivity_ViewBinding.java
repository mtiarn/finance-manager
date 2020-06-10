// Generated code from Butter Knife. Do not modify!
package com.mtiarn.finance.calc;

import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.internal.Utils;
import com.mtiarn.finance.R;
import com.mtiarn.finance.widgets.ToolbarActivity_ViewBinding;
import java.lang.IllegalStateException;
import java.lang.Override;

public class CalculatorActivity_ViewBinding extends ToolbarActivity_ViewBinding {
  private CalculatorActivity target;

  @UiThread
  public CalculatorActivity_ViewBinding(CalculatorActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public CalculatorActivity_ViewBinding(CalculatorActivity target, View source) {
    super(target, source);

    this.target = target;

    target.mDevelopingOperationInputText = Utils.findRequiredViewAsType(source, R.id.developing_operation_inputText, "field 'mDevelopingOperationInputText'", TextView.class);
    target.mNumberInputText = Utils.findRequiredViewAsType(source, R.id.number_inputText, "field 'mNumberInputText'", NumericEditText.class);
    target.mClearButton = Utils.findRequiredViewAsType(source, R.id.clear_button, "field 'mClearButton'", Button.class);
    target.mSevenButton = Utils.findRequiredViewAsType(source, R.id.seven_button, "field 'mSevenButton'", Button.class);
    target.mFourButton = Utils.findRequiredViewAsType(source, R.id.four_button, "field 'mFourButton'", Button.class);
    target.mOneButton = Utils.findRequiredViewAsType(source, R.id.one_button, "field 'mOneButton'", Button.class);
    target.mZeroButton = Utils.findRequiredViewAsType(source, R.id.zero_button, "field 'mZeroButton'", Button.class);
    target.mDividerButton = Utils.findRequiredViewAsType(source, R.id.divider_button, "field 'mDividerButton'", Button.class);
    target.mEightButton = Utils.findRequiredViewAsType(source, R.id.eight_button, "field 'mEightButton'", Button.class);
    target.mFiveButton = Utils.findRequiredViewAsType(source, R.id.five_button, "field 'mFiveButton'", Button.class);
    target.mTwoButton = Utils.findRequiredViewAsType(source, R.id.two_button, "field 'mTwoButton'", Button.class);
    target.mTwoZeroButton = Utils.findRequiredViewAsType(source, R.id.two_zero_button, "field 'mTwoZeroButton'", Button.class);
    target.mMultiplicationButton = Utils.findRequiredViewAsType(source, R.id.multiplication_button, "field 'mMultiplicationButton'", Button.class);
    target.mNineButton = Utils.findRequiredViewAsType(source, R.id.nine_button, "field 'mNineButton'", Button.class);
    target.mSixButton = Utils.findRequiredViewAsType(source, R.id.six_button, "field 'mSixButton'", Button.class);
    target.mThreeButton = Utils.findRequiredViewAsType(source, R.id.three_button, "field 'mThreeButton'", Button.class);
    target.mPointButton = Utils.findRequiredViewAsType(source, R.id.point_button, "field 'mPointButton'", Button.class);
    target.mDeleteButton = Utils.findRequiredViewAsType(source, R.id.delete_button, "field 'mDeleteButton'", Button.class);
    target.mSubtractionButton = Utils.findRequiredViewAsType(source, R.id.subtraction_button, "field 'mSubtractionButton'", Button.class);
    target.mSumButton = Utils.findRequiredViewAsType(source, R.id.sum_button, "field 'mSumButton'", Button.class);
    target.mEqualButton = Utils.findRequiredViewAsType(source, R.id.equal_button, "field 'mEqualButton'", Button.class);
    target.mSubmitButton = Utils.findRequiredViewAsType(source, R.id.submit_button, "field 'mSubmitButton'", Button.class);
  }

  @Override
  public void unbind() {
    CalculatorActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mDevelopingOperationInputText = null;
    target.mNumberInputText = null;
    target.mClearButton = null;
    target.mSevenButton = null;
    target.mFourButton = null;
    target.mOneButton = null;
    target.mZeroButton = null;
    target.mDividerButton = null;
    target.mEightButton = null;
    target.mFiveButton = null;
    target.mTwoButton = null;
    target.mTwoZeroButton = null;
    target.mMultiplicationButton = null;
    target.mNineButton = null;
    target.mSixButton = null;
    target.mThreeButton = null;
    target.mPointButton = null;
    target.mDeleteButton = null;
    target.mSubtractionButton = null;
    target.mSumButton = null;
    target.mEqualButton = null;
    target.mSubmitButton = null;

    super.unbind();
  }
}
