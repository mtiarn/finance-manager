// Generated code from Butter Knife. Do not modify!
package com.mtiarn.finance.adapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.widget.EditText;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.mtiarn.finance.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AdapterColumnIndex$ColumnIndexViewHolder_ViewBinding implements Unbinder {
  private AdapterColumnIndex.ColumnIndexViewHolder target;

  @UiThread
  public AdapterColumnIndex$ColumnIndexViewHolder_ViewBinding(AdapterColumnIndex.ColumnIndexViewHolder target,
      View source) {
    this.target = target;

    target.mSpinnerIndex = Utils.findRequiredViewAsType(source, R.id.spinnerIndex, "field 'mSpinnerIndex'", EditText.class);
    target.mTextInputLayoutSpinnerIndex = Utils.findRequiredViewAsType(source, R.id.textInputLayoutSpinnerIndex, "field 'mTextInputLayoutSpinnerIndex'", TextInputLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    AdapterColumnIndex.ColumnIndexViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mSpinnerIndex = null;
    target.mTextInputLayoutSpinnerIndex = null;
  }
}
