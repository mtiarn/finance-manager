// Generated code from Butter Knife. Do not modify!
package com.mtiarn.finance;

import android.support.annotation.UiThread;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.mtiarn.finance.widgets.ToolbarActivity_ViewBinding;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ActivityExportCSV_ViewBinding extends ToolbarActivity_ViewBinding {
  private ActivityExportCSV target;

  private View view2131296465;

  @UiThread
  public ActivityExportCSV_ViewBinding(ActivityExportCSV target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ActivityExportCSV_ViewBinding(final ActivityExportCSV target, View source) {
    super(target, source);

    this.target = target;

    View view;
    target.progressbar = Utils.findRequiredViewAsType(source, R.id.progressbar, "field 'progressbar'", ProgressBar.class);
    view = Utils.findRequiredView(source, R.id.editTextDirectory, "field 'mEditTextDirectory' and method 'OnSelectFileClick'");
    target.mEditTextDirectory = Utils.castView(view, R.id.editTextDirectory, "field 'mEditTextDirectory'", EditText.class);
    view2131296465 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.OnSelectFileClick();
      }
    });
    target.mEditTextFileName = Utils.findRequiredViewAsType(source, R.id.editTextFileName, "field 'mEditTextFileName'", EditText.class);
    target.mTextInputLayoutDir = Utils.findRequiredViewAsType(source, R.id.textInputLayoutDir, "field 'mTextInputLayoutDir'", TextInputLayout.class);
    target.mTextInputLayoutFileName = Utils.findRequiredViewAsType(source, R.id.textInputLayoutFileName, "field 'mTextInputLayoutFileName'", TextInputLayout.class);
    target.mCheckBoxExportProducts = Utils.findRequiredViewAsType(source, R.id.checkBoxExportProducts, "field 'mCheckBoxExportProducts'", CheckBox.class);
  }

  @Override
  public void unbind() {
    ActivityExportCSV target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.progressbar = null;
    target.mEditTextDirectory = null;
    target.mEditTextFileName = null;
    target.mTextInputLayoutDir = null;
    target.mTextInputLayoutFileName = null;
    target.mCheckBoxExportProducts = null;

    view2131296465.setOnClickListener(null);
    view2131296465 = null;

    super.unbind();
  }
}
