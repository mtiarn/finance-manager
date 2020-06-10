// Generated code from Butter Knife. Do not modify!
package com.mtiarn.finance.fts;

import android.support.annotation.UiThread;
import android.support.constraint.Guideline;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.mtiarn.finance.R;
import com.mtiarn.finance.widgets.ToolbarActivity_ViewBinding;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ActivityFtsLogin_ViewBinding extends ToolbarActivity_ViewBinding {
  private ActivityFtsLogin target;

  private View view2131296371;

  private View view2131296375;

  private View view2131296397;

  @UiThread
  public ActivityFtsLogin_ViewBinding(ActivityFtsLogin target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ActivityFtsLogin_ViewBinding(final ActivityFtsLogin target, View source) {
    super(target, source);

    this.target = target;

    View view;
    target.mTextViewSubtitle = Utils.findRequiredViewAsType(source, R.id.textViewSubtitle, "field 'mTextViewSubtitle'", TextView.class);
    target.mTextViewFtsLoginHtml = Utils.findRequiredViewAsType(source, R.id.textViewFtsLoginHtml, "field 'mTextViewFtsLoginHtml'", TextView.class);
    target.mEditTextPhoneNo = Utils.findRequiredViewAsType(source, R.id.editTextPhoneNo, "field 'mEditTextPhoneNo'", EditText.class);
    target.mTextInputLayoutPhoneNo = Utils.findRequiredViewAsType(source, R.id.textInputLayoutPhoneNo, "field 'mTextInputLayoutPhoneNo'", TextInputLayout.class);
    target.mEditTextCode = Utils.findRequiredViewAsType(source, R.id.editTextCode, "field 'mEditTextCode'", EditText.class);
    target.mTextInputLayoutCode = Utils.findRequiredViewAsType(source, R.id.textInputLayoutCode, "field 'mTextInputLayoutCode'", TextInputLayout.class);
    view = Utils.findRequiredView(source, R.id.buttonNotNow, "field 'mButtonNotNow' and method 'onViewClicked'");
    target.mButtonNotNow = Utils.castView(view, R.id.buttonNotNow, "field 'mButtonNotNow'", Button.class);
    view2131296371 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.buttonSave, "field 'mButtonSave' and method 'onViewClicked'");
    target.mButtonSave = Utils.castView(view, R.id.buttonSave, "field 'mButtonSave'", Button.class);
    view2131296375 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.mGuideline6 = Utils.findRequiredViewAsType(source, R.id.guideline6, "field 'mGuideline6'", Guideline.class);
    target.mTextView4 = Utils.findRequiredViewAsType(source, R.id.textView4, "field 'mTextView4'", TextView.class);
    view = Utils.findRequiredView(source, R.id.checkBox, "field 'mCheckBox' and method 'onViewClicked'");
    target.mCheckBox = Utils.castView(view, R.id.checkBox, "field 'mCheckBox'", CheckBox.class);
    view2131296397 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
  }

  @Override
  public void unbind() {
    ActivityFtsLogin target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mTextViewSubtitle = null;
    target.mTextViewFtsLoginHtml = null;
    target.mEditTextPhoneNo = null;
    target.mTextInputLayoutPhoneNo = null;
    target.mEditTextCode = null;
    target.mTextInputLayoutCode = null;
    target.mButtonNotNow = null;
    target.mButtonSave = null;
    target.mGuideline6 = null;
    target.mTextView4 = null;
    target.mCheckBox = null;

    view2131296371.setOnClickListener(null);
    view2131296371 = null;
    view2131296375.setOnClickListener(null);
    view2131296375 = null;
    view2131296397.setOnClickListener(null);
    view2131296397 = null;

    super.unbind();
  }
}
