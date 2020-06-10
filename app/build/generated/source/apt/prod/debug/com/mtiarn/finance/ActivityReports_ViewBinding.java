// Generated code from Butter Knife. Do not modify!
package com.mtiarn.finance;

import android.support.annotation.UiThread;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TextInputLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.internal.Utils;
import com.mtiarn.finance.widgets.ToolbarActivity_ViewBinding;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ActivityReports_ViewBinding extends ToolbarActivity_ViewBinding {
  private ActivityReports target;

  @UiThread
  public ActivityReports_ViewBinding(ActivityReports target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ActivityReports_ViewBinding(ActivityReports target, View source) {
    super(target, source);

    this.target = target;

    target.mTextInputLayoutData = Utils.findRequiredViewAsType(source, R.id.textInputLayoutData, "field 'mTextInputLayoutData'", TextInputLayout.class);
    target.mTextInputLayoutDateRange = Utils.findRequiredViewAsType(source, R.id.textInputLayoutDateRange, "field 'mTextInputLayoutDateRange'", TextInputLayout.class);
    target.viewPager = Utils.findRequiredViewAsType(source, R.id.pager, "field 'viewPager'", ViewPager.class);
    target.tabLayout = Utils.findRequiredViewAsType(source, R.id.tabLayout, "field 'tabLayout'", TabLayout.class);
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    target.mTextViewDateRange = Utils.findRequiredViewAsType(source, R.id.textViewDateRange, "field 'mTextViewDateRange'", TextView.class);
    target.mEditTextCabbage = Utils.findRequiredViewAsType(source, R.id.editTextCabbage, "field 'mEditTextCabbage'", EditText.class);
    target.mEditTextData = Utils.findRequiredViewAsType(source, R.id.editTextData, "field 'mEditTextData'", EditText.class);
    target.mEditTextShow = Utils.findRequiredViewAsType(source, R.id.editTextShow, "field 'mEditTextShow'", EditText.class);
    target.mEditTextDateRange = Utils.findRequiredViewAsType(source, R.id.editTextDateRange, "field 'mEditTextDateRange'", EditText.class);
  }

  @Override
  public void unbind() {
    ActivityReports target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mTextInputLayoutData = null;
    target.mTextInputLayoutDateRange = null;
    target.viewPager = null;
    target.tabLayout = null;
    target.toolbar = null;
    target.mTextViewDateRange = null;
    target.mEditTextCabbage = null;
    target.mEditTextData = null;
    target.mEditTextShow = null;
    target.mEditTextDateRange = null;

    super.unbind();
  }
}
