// Generated code from Butter Knife. Do not modify!
package com.mtiarn.finance.adapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.mtiarn.finance.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AdapterTransactions$HeaderViewHolder_ViewBinding implements Unbinder {
  private AdapterTransactions.HeaderViewHolder target;

  @UiThread
  public AdapterTransactions$HeaderViewHolder_ViewBinding(AdapterTransactions.HeaderViewHolder target,
      View source) {
    this.target = target;

    target.text = Utils.findRequiredViewAsType(source, R.id.text, "field 'text'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    AdapterTransactions.HeaderViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.text = null;
  }
}
