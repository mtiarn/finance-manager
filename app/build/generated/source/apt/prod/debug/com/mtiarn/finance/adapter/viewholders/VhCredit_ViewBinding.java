// Generated code from Butter Knife. Do not modify!
package com.mtiarn.finance.adapter.viewholders;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.mtiarn.finance.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class VhCredit_ViewBinding implements Unbinder {
  private VhCredit target;

  @UiThread
  public VhCredit_ViewBinding(VhCredit target, View source) {
    this.target = target;

    target.imageViewIcon = Utils.findRequiredViewAsType(source, R.id.imageViewAccountIcon, "field 'imageViewIcon'", ImageView.class);
    target.mTextViewName = Utils.findRequiredViewAsType(source, R.id.textViewAccountName, "field 'mTextViewName'", TextView.class);
    target.mTextViewType = Utils.findRequiredViewAsType(source, R.id.textViewAccountType, "field 'mTextViewType'", TextView.class);
    target.mTextViewCurBalance = Utils.findRequiredViewAsType(source, R.id.textViewAccountCurBalance, "field 'mTextViewCurBalance'", TextView.class);
    target.mTextViewIncome = Utils.findRequiredViewAsType(source, R.id.textViewIncome, "field 'mTextViewIncome'", TextView.class);
    target.mTextViewExpense = Utils.findRequiredViewAsType(source, R.id.textViewOutcome, "field 'mTextViewExpense'", TextView.class);
    target.mSpaceBottom = Utils.findRequiredViewAsType(source, R.id.spaceBottom, "field 'mSpaceBottom'", FrameLayout.class);
    target.mSpaceBottomFinal = Utils.findRequiredViewAsType(source, R.id.spaceBottomFinal, "field 'mSpaceBottomFinal'", FrameLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    VhCredit target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.imageViewIcon = null;
    target.mTextViewName = null;
    target.mTextViewType = null;
    target.mTextViewCurBalance = null;
    target.mTextViewIncome = null;
    target.mTextViewExpense = null;
    target.mSpaceBottom = null;
    target.mSpaceBottomFinal = null;
  }
}
