// Generated code from Butter Knife. Do not modify!
package com.mtiarn.finance;

import android.support.annotation.UiThread;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.internal.Utils;
import com.mtiarn.finance.widgets.ToolbarActivity_ViewBinding;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ActivityBackup_ViewBinding extends ToolbarActivity_ViewBinding {
  private ActivityBackup target;

  @UiThread
  public ActivityBackup_ViewBinding(ActivityBackup target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ActivityBackup_ViewBinding(ActivityBackup target, View source) {
    super(target, source);

    this.target = target;

    target.fabBackup = Utils.findRequiredViewAsType(source, R.id.fabBackup, "field 'fabBackup'", FloatingActionButton.class);
    target.fabRestore = Utils.findRequiredViewAsType(source, R.id.fabRestore, "field 'fabRestore'", FloatingActionButton.class);
    target.fabRestoreFromDropbox = Utils.findRequiredViewAsType(source, R.id.fabRestoreFromDropbox, "field 'fabRestoreFromDropbox'", FloatingActionButton.class);
    target.fabMenuButtonRoot = Utils.findRequiredViewAsType(source, R.id.fabMenuButtonRoot, "field 'fabMenuButtonRoot'", FloatingActionButton.class);
    target.mSwitchCompatEnablePasswordProtection = Utils.findRequiredViewAsType(source, R.id.switchCompatEnablePasswordProtection, "field 'mSwitchCompatEnablePasswordProtection'", SwitchCompat.class);
    target.mEditTextPassword = Utils.findRequiredViewAsType(source, R.id.editTextPassword, "field 'mEditTextPassword'", EditText.class);
    target.mEditTextDropboxAccount = Utils.findRequiredViewAsType(source, R.id.editTextDropboxAccount, "field 'mEditTextDropboxAccount'", EditText.class);
    target.mTextInputLayoutDropboxAccount = Utils.findRequiredViewAsType(source, R.id.textInputLayoutDropboxAccount, "field 'mTextInputLayoutDropboxAccount'", TextInputLayout.class);
    target.mTextViewLastBackupToDropbox = Utils.findRequiredViewAsType(source, R.id.textViewLastBackupToDropbox, "field 'mTextViewLastBackupToDropbox'", TextView.class);
    target.mButtonLogoutFromDropbox = Utils.findRequiredViewAsType(source, R.id.buttonLogoutFromDropbox, "field 'mButtonLogoutFromDropbox'", Button.class);
    target.fabBGLayout = Utils.findRequiredView(source, R.id.fabBGLayout, "field 'fabBGLayout'");
    target.mFabBackupLayout = Utils.findRequiredViewAsType(source, R.id.fabBackupLayout, "field 'mFabBackupLayout'", LinearLayout.class);
    target.mFabRestoreLayout = Utils.findRequiredViewAsType(source, R.id.fabRestoreLayout, "field 'mFabRestoreLayout'", LinearLayout.class);
    target.mFabRestoreFromDropboxLayout = Utils.findRequiredViewAsType(source, R.id.fabRestoreFromDropboxLayout, "field 'mFabRestoreFromDropboxLayout'", LinearLayout.class);
  }

  @Override
  public void unbind() {
    ActivityBackup target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.fabBackup = null;
    target.fabRestore = null;
    target.fabRestoreFromDropbox = null;
    target.fabMenuButtonRoot = null;
    target.mSwitchCompatEnablePasswordProtection = null;
    target.mEditTextPassword = null;
    target.mEditTextDropboxAccount = null;
    target.mTextInputLayoutDropboxAccount = null;
    target.mTextViewLastBackupToDropbox = null;
    target.mButtonLogoutFromDropbox = null;
    target.fabBGLayout = null;
    target.mFabBackupLayout = null;
    target.mFabRestoreLayout = null;
    target.mFabRestoreFromDropboxLayout = null;

    super.unbind();
  }
}
