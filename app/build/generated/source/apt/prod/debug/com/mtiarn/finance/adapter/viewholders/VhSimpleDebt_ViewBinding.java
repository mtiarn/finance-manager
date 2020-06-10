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

public class VhSimpleDebt_ViewBinding implements Unbinder {
  private VhSimpleDebt target;

  @UiThread
  public VhSimpleDebt_ViewBinding(VhSimpleDebt target, View source) {
    this.target = target;

    target.mImageViewIcon = Utils.findRequiredViewAsType(source, R.id.imageViewIcon, "field 'mImageViewIcon'", ImageView.class);
    target.mTextViewName = Utils.findRequiredViewAsType(source, R.id.textViewName, "field 'mTextViewName'", TextView.class);
    target.mTextViewOweMe = Utils.findRequiredViewAsType(source, R.id.textViewOweMe, "field 'mTextViewOweMe'", TextView.class);
    target.mTextViewOweMeTitle = Utils.findRequiredViewAsType(source, R.id.textViewOweMeTitle, "field 'mTextViewOweMeTitle'", TextView.class);
    target.mTextViewIOwe = Utils.findRequiredViewAsType(source, R.id.textViewIOwe, "field 'mTextViewIOwe'", TextView.class);
    target.mTextViewIOweTitle = Utils.findRequiredViewAsType(source, R.id.textViewIOweTitle, "field 'mTextViewIOweTitle'", TextView.class);
    target.mTextViewAccountTotal = Utils.findRequiredViewAsType(source, R.id.textViewAccountTotal, "field 'mTextViewAccountTotal'", TextView.class);
    target.mTextViewTotalTitle = Utils.findRequiredViewAsType(source, R.id.textViewTotalTitle, "field 'mTextViewTotalTitle'", TextView.class);
    target.mSpaceBottom = Utils.findRequiredViewAsType(source, R.id.spaceBottom, "field 'mSpaceBottom'", FrameLayout.class);
    target.mSpaceBottomFinal = Utils.findRequiredViewAsType(source, R.id.spaceBottomFinal, "field 'mSpaceBottomFinal'", FrameLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    VhSimpleDebt target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mImageViewIcon = null;
    target.mTextViewName = null;
    target.mTextViewOweMe = null;
    target.mTextViewOweMeTitle = null;
    target.mTextViewIOwe = null;
    target.mTextViewIOweTitle = null;
    target.mTextViewAccountTotal = null;
    target.mTextViewTotalTitle = null;
    target.mSpaceBottom = null;
    target.mSpaceBottomFinal = null;
  }
}
