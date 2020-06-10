// Generated code from Butter Knife. Do not modify!
package com.mtiarn.finance;

import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.internal.Utils;
import com.mtiarn.finance.widgets.ToolbarActivity_ViewBinding;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ActivityAbout_ViewBinding extends ToolbarActivity_ViewBinding {
  private ActivityAbout target;

  @UiThread
  public ActivityAbout_ViewBinding(ActivityAbout target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ActivityAbout_ViewBinding(ActivityAbout target, View source) {
    super(target, source);

    this.target = target;

    target.mTextViewVersion = Utils.findRequiredViewAsType(source, R.id.textViewVersion, "field 'mTextViewVersion'", TextView.class);
    target.mTextViewLicense = Utils.findRequiredViewAsType(source, R.id.textViewLicense, "field 'mTextViewLicense'", TextView.class);
    target.mButtonLicenses = Utils.findRequiredViewAsType(source, R.id.buttonLicenses, "field 'mButtonLicenses'", TextView.class);
    target.mButtonChangeLog = Utils.findRequiredViewAsType(source, R.id.buttonChangeLog, "field 'mButtonChangeLog'", TextView.class);
    target.mTextViewSQLiteVersion = Utils.findRequiredViewAsType(source, R.id.textViewSQLiteVersion, "field 'mTextViewSQLiteVersion'", TextView.class);
    target.mButtonRebuildDB = Utils.findRequiredViewAsType(source, R.id.buttonRebuildDB, "field 'mButtonRebuildDB'", Button.class);
  }

  @Override
  public void unbind() {
    ActivityAbout target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mTextViewVersion = null;
    target.mTextViewLicense = null;
    target.mButtonLicenses = null;
    target.mButtonChangeLog = null;
    target.mTextViewSQLiteVersion = null;
    target.mButtonRebuildDB = null;

    super.unbind();
  }
}
