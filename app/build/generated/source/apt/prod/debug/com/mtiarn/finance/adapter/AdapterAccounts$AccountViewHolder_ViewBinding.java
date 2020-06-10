// Generated code from Butter Knife. Do not modify!
package com.mtiarn.finance.adapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.mtiarn.finance.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AdapterAccounts$AccountViewHolder_ViewBinding implements Unbinder {
  private AdapterAccounts.AccountViewHolder target;

  @UiThread
  public AdapterAccounts$AccountViewHolder_ViewBinding(AdapterAccounts.AccountViewHolder target,
      View source) {
    this.target = target;

    target.imageViewIcon = Utils.findRequiredViewAsType(source, R.id.imageViewAccountIcon, "field 'imageViewIcon'", ImageView.class);
    target.textViewName = Utils.findRequiredViewAsType(source, R.id.textViewAccountName, "field 'textViewName'", TextView.class);
    target.textViewType = Utils.findRequiredViewAsType(source, R.id.textViewAccountType, "field 'textViewType'", TextView.class);
    target.textViewCurBalance = Utils.findRequiredViewAsType(source, R.id.textViewAccountCurBalance, "field 'textViewCurBalance'", TextView.class);
    target.textViewIncome = Utils.findRequiredViewAsType(source, R.id.textViewIncome, "field 'textViewIncome'", TextView.class);
    target.textViewOutcome = Utils.findRequiredViewAsType(source, R.id.textViewOutcome, "field 'textViewOutcome'", TextView.class);
    target.mSpaceBottom = Utils.findRequiredViewAsType(source, R.id.spaceBottom, "field 'mSpaceBottom'", FrameLayout.class);
    target.mSpaceBottomFinal = Utils.findRequiredViewAsType(source, R.id.spaceBottomFinal, "field 'mSpaceBottomFinal'", FrameLayout.class);
    target.mProgresBarLayout = Utils.findRequiredViewAsType(source, R.id.progres_bar_layout, "field 'mProgresBarLayout'", ConstraintLayout.class);
    target.mProgressBar = Utils.findRequiredViewAsType(source, R.id.progress_bar, "field 'mProgressBar'", ProgressBar.class);
    target.mProgressBarTextView = Utils.findRequiredViewAsType(source, R.id.progress_bar_text, "field 'mProgressBarTextView'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    AdapterAccounts.AccountViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.imageViewIcon = null;
    target.textViewName = null;
    target.textViewType = null;
    target.textViewCurBalance = null;
    target.textViewIncome = null;
    target.textViewOutcome = null;
    target.mSpaceBottom = null;
    target.mSpaceBottomFinal = null;
    target.mProgresBarLayout = null;
    target.mProgressBar = null;
    target.mProgressBarTextView = null;
  }
}
