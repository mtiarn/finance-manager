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

public class AdapterProducts$MoveResidueViewHolder_ViewBinding implements Unbinder {
  private AdapterProducts.MoveResidueViewHolder target;

  @UiThread
  public AdapterProducts$MoveResidueViewHolder_ViewBinding(AdapterProducts.MoveResidueViewHolder target,
      View source) {
    this.target = target;

    target.mTextViewAddProduct = Utils.findRequiredViewAsType(source, R.id.textViewAddProduct, "field 'mTextViewAddProduct'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    AdapterProducts.MoveResidueViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mTextViewAddProduct = null;
  }
}
