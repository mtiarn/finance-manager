// Generated code from Butter Knife. Do not modify!
package com.mtiarn.finance.adapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.mtiarn.finance.R;
import eu.davidea.flipview.FlipView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AdapterAccountsSets$AccountsSetViewHolder_ViewBinding implements Unbinder {
  private AdapterAccountsSets.AccountsSetViewHolder target;

  @UiThread
  public AdapterAccountsSets$AccountsSetViewHolder_ViewBinding(AdapterAccountsSets.AccountsSetViewHolder target,
      View source) {
    this.target = target;

    target.dragHandle = Utils.findRequiredViewAsType(source, R.id.radioButton, "field 'dragHandle'", FlipView.class);
    target.textViewModelName = Utils.findRequiredViewAsType(source, R.id.textViewModelName, "field 'textViewModelName'", TextView.class);
    target.container = Utils.findRequiredViewAsType(source, R.id.container, "field 'container'", ConstraintLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    AdapterAccountsSets.AccountsSetViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.dragHandle = null;
    target.textViewModelName = null;
    target.container = null;
  }
}
