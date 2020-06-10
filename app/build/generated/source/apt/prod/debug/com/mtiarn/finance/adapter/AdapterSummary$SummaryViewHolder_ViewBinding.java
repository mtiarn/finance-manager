// Generated code from Butter Knife. Do not modify!
package com.mtiarn.finance.adapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.mtiarn.finance.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AdapterSummary$SummaryViewHolder_ViewBinding implements Unbinder {
  private AdapterSummary.SummaryViewHolder target;

  @UiThread
  public AdapterSummary$SummaryViewHolder_ViewBinding(AdapterSummary.SummaryViewHolder target,
      View source) {
    this.target = target;

    target.mTextView = Utils.findRequiredViewAsType(source, R.id.textView, "field 'mTextView'", TextView.class);
    target.mLayoutSummaryTable = Utils.findRequiredViewAsType(source, R.id.layoutSummaryTable, "field 'mLayoutSummaryTable'", TableLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    AdapterSummary.SummaryViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mTextView = null;
    target.mLayoutSummaryTable = null;
  }
}
