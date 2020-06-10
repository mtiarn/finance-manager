// Generated code from Butter Knife. Do not modify!
package com.mtiarn.finance;

import android.support.annotation.UiThread;
import android.support.v7.widget.AppCompatCheckBox;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.mtiarn.finance.widgets.ToolbarActivity_ViewBinding;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ActivityImportSms_ViewBinding extends ToolbarActivity_ViewBinding {
  private ActivityImportSms target;

  private View view2131296478;

  private View view2131296480;

  private View view2131296481;

  private View view2131296468;

  private View view2131296469;

  @UiThread
  public ActivityImportSms_ViewBinding(ActivityImportSms target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ActivityImportSms_ViewBinding(final ActivityImportSms target, View source) {
    super(target, source);

    this.target = target;

    View view;
    target.progressbar = Utils.findRequiredViewAsType(source, R.id.progressbar, "field 'progressbar'", ProgressBar.class);
    view = Utils.findRequiredView(source, R.id.editTextSender, "field 'editTextSender' and method 'onClick'");
    target.editTextSender = Utils.castView(view, R.id.editTextSender, "field 'editTextSender'", EditText.class);
    view2131296478 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick();
      }
    });
    view = Utils.findRequiredView(source, R.id.editTextStartDate, "field 'editTextStartDate' and method 'onDateClick'");
    target.editTextStartDate = Utils.castView(view, R.id.editTextStartDate, "field 'editTextStartDate'", EditText.class);
    view2131296480 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onDateClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.editTextStartTime, "field 'editTextStartTime' and method 'onTimeClick'");
    target.editTextStartTime = Utils.castView(view, R.id.editTextStartTime, "field 'editTextStartTime'", EditText.class);
    view2131296481 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onTimeClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.editTextEndDate, "field 'editTextEndDate' and method 'onDateClick'");
    target.editTextEndDate = Utils.castView(view, R.id.editTextEndDate, "field 'editTextEndDate'", EditText.class);
    view2131296468 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onDateClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.editTextEndTime, "field 'editTextEndTime' and method 'onTimeClick'");
    target.editTextEndTime = Utils.castView(view, R.id.editTextEndTime, "field 'editTextEndTime'", EditText.class);
    view2131296469 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onTimeClick(p0);
      }
    });
    target.checkboxAutoCreateTransactions = Utils.findRequiredViewAsType(source, R.id.checkboxAutoCreateTransactions, "field 'checkboxAutoCreateTransactions'", AppCompatCheckBox.class);
  }

  @Override
  public void unbind() {
    ActivityImportSms target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.progressbar = null;
    target.editTextSender = null;
    target.editTextStartDate = null;
    target.editTextStartTime = null;
    target.editTextEndDate = null;
    target.editTextEndTime = null;
    target.checkboxAutoCreateTransactions = null;

    view2131296478.setOnClickListener(null);
    view2131296478 = null;
    view2131296480.setOnClickListener(null);
    view2131296480 = null;
    view2131296481.setOnClickListener(null);
    view2131296481 = null;
    view2131296468.setOnClickListener(null);
    view2131296468 = null;
    view2131296469.setOnClickListener(null);
    view2131296469 = null;

    super.unbind();
  }
}
