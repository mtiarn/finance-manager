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

public class AdapterProducts$AddProductViewHolder_ViewBinding implements Unbinder {
  private AdapterProducts.AddProductViewHolder target;

  @UiThread
  public AdapterProducts$AddProductViewHolder_ViewBinding(AdapterProducts.AddProductViewHolder target,
      View source) {
    this.target = target;

    target.mTextViewAddProduct = Utils.findRequiredViewAsType(source, R.id.textViewAddProduct, "field 'mTextViewAddProduct'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    AdapterProducts.AddProductViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mTextViewAddProduct = null;
  }
}
