// Generated code from Butter Knife. Do not modify!
package com.mtiarn.finance;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class FragmentSenderEdit_ViewBinding implements Unbinder {
  private FragmentSenderEdit target;

  private View view2131296457;

  private View view2131296458;

  private View view2131296621;

  private View view2131296398;

  @UiThread
  public FragmentSenderEdit_ViewBinding(final FragmentSenderEdit target, View source) {
    this.target = target;

    View view;
    target.mEditTextName = Utils.findRequiredViewAsType(source, R.id.editTextName, "field 'mEditTextName'", EditText.class);
    target.mEditTextPhoneNo = Utils.findRequiredViewAsType(source, R.id.editTextPhoneNo, "field 'mEditTextPhoneNo'", EditText.class);
    view = Utils.findRequiredView(source, R.id.editTextAmountPos, "field 'mEditTextAmountPos' and method 'onClick'");
    target.mEditTextAmountPos = Utils.castView(view, R.id.editTextAmountPos, "field 'mEditTextAmountPos'", EditText.class);
    view2131296457 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.editTextBalancePos, "field 'mEditTextBalancePos' and method 'onClick'");
    target.mEditTextBalancePos = Utils.castView(view, R.id.editTextBalancePos, "field 'mEditTextBalancePos'", EditText.class);
    view2131296458 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.imageButtonSelectSender, "field 'mImageButtonSelectSender' and method 'onClick'");
    target.mImageButtonSelectSender = Utils.castView(view, R.id.imageButtonSelectSender, "field 'mImageButtonSelectSender'", ImageButton.class);
    view2131296621 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.checkBoxAddCreditLimitToBalance, "field 'mCheckBoxAddCreditLimitToBalance' and method 'onClick'");
    target.mCheckBoxAddCreditLimitToBalance = Utils.castView(view, R.id.checkBoxAddCreditLimitToBalance, "field 'mCheckBoxAddCreditLimitToBalance'", CheckBox.class);
    view2131296398 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    FragmentSenderEdit target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mEditTextName = null;
    target.mEditTextPhoneNo = null;
    target.mEditTextAmountPos = null;
    target.mEditTextBalancePos = null;
    target.mImageButtonSelectSender = null;
    target.mCheckBoxAddCreditLimitToBalance = null;

    view2131296457.setOnClickListener(null);
    view2131296457 = null;
    view2131296458.setOnClickListener(null);
    view2131296458 = null;
    view2131296621.setOnClickListener(null);
    view2131296621 = null;
    view2131296398.setOnClickListener(null);
    view2131296398 = null;
  }
}
