// Generated code from Butter Knife. Do not modify!
package com.mtiarn.finance;

import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.mtiarn.finance.widgets.ToolbarActivity_ViewBinding;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ActivityEditCredit_ViewBinding extends ToolbarActivity_ViewBinding {
  private ActivityEditCredit target;

  private View view2131296607;

  private View view2131296378;

  @UiThread
  public ActivityEditCredit_ViewBinding(ActivityEditCredit target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ActivityEditCredit_ViewBinding(final ActivityEditCredit target, View source) {
    super(target, source);

    this.target = target;

    View view;
    target.textViewAccount = Utils.findRequiredViewAsType(source, R.id.textViewAccount, "field 'textViewAccount'", EditText.class);
    target.textViewCategory = Utils.findRequiredViewAsType(source, R.id.textViewCategory, "field 'textViewCategory'", EditText.class);
    target.textViewComment = Utils.findRequiredViewAsType(source, R.id.editTextComment, "field 'textViewComment'", EditText.class);
    view = Utils.findRequiredView(source, R.id.imageButtonDeleteCategory, "field 'mImageButtonDeleteCategory' and method 'onClick'");
    target.mImageButtonDeleteCategory = Utils.castView(view, R.id.imageButtonDeleteCategory, "field 'mImageButtonDeleteCategory'", ImageButton.class);
    view2131296607 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick();
      }
    });
    view = Utils.findRequiredView(source, R.id.buttonSaveTransaction, "field 'mButtonSaveTransaction' and method 'onSaveClick'");
    target.mButtonSaveTransaction = Utils.castView(view, R.id.buttonSaveTransaction, "field 'mButtonSaveTransaction'", Button.class);
    view2131296378 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onSaveClick();
      }
    });
  }

  @Override
  public void unbind() {
    ActivityEditCredit target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.textViewAccount = null;
    target.textViewCategory = null;
    target.textViewComment = null;
    target.mImageButtonDeleteCategory = null;
    target.mButtonSaveTransaction = null;

    view2131296607.setOnClickListener(null);
    view2131296607 = null;
    view2131296378.setOnClickListener(null);
    view2131296378 = null;

    super.unbind();
  }
}
