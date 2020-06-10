// Generated code from Butter Knife. Do not modify!
package com.mtiarn.finance.adapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.mtiarn.finance.R;
import com.mtiarn.finance.tag.TagView;
import eu.davidea.flipview.FlipView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AdapterProducts$ProductViewHolder_ViewBinding implements Unbinder {
  private AdapterProducts.ProductViewHolder target;

  @UiThread
  public AdapterProducts$ProductViewHolder_ViewBinding(AdapterProducts.ProductViewHolder target,
      View source) {
    this.target = target;

    target.mTextViewProductName = Utils.findRequiredViewAsType(source, R.id.textViewProductName, "field 'mTextViewProductName'", TextView.class);
    target.mTagView = Utils.findRequiredViewAsType(source, R.id.layoutTagView, "field 'mTagView'", TagView.class);
    target.mImageButtonDeleteProduct = Utils.findRequiredViewAsType(source, R.id.imageButtonDeleteProduct, "field 'mImageButtonDeleteProduct'", ImageButton.class);
    target.mTextViewSum = Utils.findRequiredViewAsType(source, R.id.textViewSum, "field 'mTextViewSum'", TextView.class);
    target.flipViewIcon = Utils.findRequiredViewAsType(source, R.id.flipViewIcon, "field 'flipViewIcon'", FlipView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    AdapterProducts.ProductViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mTextViewProductName = null;
    target.mTagView = null;
    target.mImageButtonDeleteProduct = null;
    target.mTextViewSum = null;
    target.flipViewIcon = null;
  }
}
