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
import com.mtiarn.finance.tag.TagView;
import eu.davidea.flipview.FlipView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class TransactionViewHolder_ViewBinding implements Unbinder {
  private TransactionViewHolder target;

  @UiThread
  public TransactionViewHolder_ViewBinding(TransactionViewHolder target, View source) {
    this.target = target;

    target.textViewPayee = Utils.findRequiredViewAsType(source, R.id.textViewPayee, "field 'textViewPayee'", TextView.class);
    target.textViewAmount = Utils.findRequiredViewAsType(source, R.id.textViewAmount, "field 'textViewAmount'", TextView.class);
    target.textViewDate = Utils.findRequiredViewAsType(source, R.id.textViewDate, "field 'textViewDate'", TextView.class);
    target.textViewAccount = Utils.findRequiredViewAsType(source, R.id.textViewAccount, "field 'textViewAccount'", TextView.class);
    target.textViewAccountBalance = Utils.findRequiredViewAsType(source, R.id.textViewAccountBalance, "field 'textViewAccountBalance'", TextView.class);
    target.textViewDestAccountBalance = Utils.findRequiredViewAsType(source, R.id.textViewDestAccountBalance, "field 'textViewDestAccountBalance'", TextView.class);
    target.mTagView = Utils.findRequiredViewAsType(source, R.id.layoutTagView, "field 'mTagView'", TagView.class);
    target.imageViewAutoCreated = Utils.findRequiredViewAsType(source, R.id.imageViewAutoCreated, "field 'imageViewAutoCreated'", ImageView.class);
    target.imageViewHasLocation = Utils.findRequiredViewAsType(source, R.id.imageViewHasLocation, "field 'imageViewHasLocation'", ImageView.class);
    target.imageViewHasQR = Utils.findRequiredViewAsType(source, R.id.imageViewHasQR, "field 'imageViewHasQR'", ImageView.class);
    target.imageViewHasProducts = Utils.findRequiredViewAsType(source, R.id.imageViewHasProducts, "field 'imageViewHasProducts'", ImageView.class);
    target.imageViewChevronRight = Utils.findRequiredViewAsType(source, R.id.imageViewChevronRight, "field 'imageViewChevronRight'", ImageView.class);
    target.flipViewIcon = Utils.findRequiredViewAsType(source, R.id.flipViewIcon, "field 'flipViewIcon'", FlipView.class);
    target.textViewComment = Utils.findRequiredViewAsType(source, R.id.textViewComment, "field 'textViewComment'", TextView.class);
    target.spaceBottom = Utils.findRequiredViewAsType(source, R.id.spaceBottom, "field 'spaceBottom'", FrameLayout.class);
    target.mImageViewDestAccount = Utils.findRequiredViewAsType(source, R.id.imageViewDestAccount, "field 'mImageViewDestAccount'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    TransactionViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.textViewPayee = null;
    target.textViewAmount = null;
    target.textViewDate = null;
    target.textViewAccount = null;
    target.textViewAccountBalance = null;
    target.textViewDestAccountBalance = null;
    target.mTagView = null;
    target.imageViewAutoCreated = null;
    target.imageViewHasLocation = null;
    target.imageViewHasQR = null;
    target.imageViewHasProducts = null;
    target.imageViewChevronRight = null;
    target.flipViewIcon = null;
    target.textViewComment = null;
    target.spaceBottom = null;
    target.mImageViewDestAccount = null;
  }
}
