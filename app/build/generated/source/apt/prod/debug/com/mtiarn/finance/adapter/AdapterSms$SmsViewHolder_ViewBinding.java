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

public class AdapterSms$SmsViewHolder_ViewBinding implements Unbinder {
  private AdapterSms.SmsViewHolder target;

  @UiThread
  public AdapterSms$SmsViewHolder_ViewBinding(AdapterSms.SmsViewHolder target, View source) {
    this.target = target;

    target.textViewSender = Utils.findRequiredViewAsType(source, R.id.sender, "field 'textViewSender'", TextView.class);
    target.textViewDate = Utils.findRequiredViewAsType(source, R.id.date, "field 'textViewDate'", TextView.class);
    target.textViewBody = Utils.findRequiredViewAsType(source, R.id.body, "field 'textViewBody'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    AdapterSms.SmsViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.textViewSender = null;
    target.textViewDate = null;
    target.textViewBody = null;
  }
}
