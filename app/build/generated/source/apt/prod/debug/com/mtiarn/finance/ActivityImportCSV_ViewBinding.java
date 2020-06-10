// Generated code from Butter Knife. Do not modify!
package com.mtiarn.finance;

import android.support.annotation.UiThread;
import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.mtiarn.finance.widgets.ToolbarActivity_ViewBinding;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ActivityImportCSV_ViewBinding extends ToolbarActivity_ViewBinding {
  private ActivityImportCSV target;

  private View view2131296470;

  @UiThread
  public ActivityImportCSV_ViewBinding(ActivityImportCSV target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ActivityImportCSV_ViewBinding(final ActivityImportCSV target, View source) {
    super(target, source);

    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.editTextFileName, "field 'editTextFileName' and method 'OnSelectFileClick'");
    target.editTextFileName = Utils.castView(view, R.id.editTextFileName, "field 'editTextFileName'", EditText.class);
    view2131296470 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.OnSelectFileClick();
      }
    });
    target.progressbar = Utils.findRequiredViewAsType(source, R.id.progressbar, "field 'progressbar'", ProgressBar.class);
    target.mSwitchCompatSkipDuplicates = Utils.findRequiredViewAsType(source, R.id.switchCompatSkipDuplicates, "field 'mSwitchCompatSkipDuplicates'", SwitchCompat.class);
  }

  @Override
  public void unbind() {
    ActivityImportCSV target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.editTextFileName = null;
    target.progressbar = null;
    target.mSwitchCompatSkipDuplicates = null;

    view2131296470.setOnClickListener(null);
    view2131296470 = null;

    super.unbind();
  }
}
