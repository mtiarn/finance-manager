// Generated code from Butter Knife. Do not modify!
package com.mtiarn.finance.adapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.mtiarn.finance.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AdapterSku$SkuDetailsItemViewHolder_ViewBinding implements Unbinder {
  private AdapterSku.SkuDetailsItemViewHolder target;

  @UiThread
  public AdapterSku$SkuDetailsItemViewHolder_ViewBinding(AdapterSku.SkuDetailsItemViewHolder target,
      View source) {
    this.target = target;

    target.imageViewIcon = Utils.findRequiredViewAsType(source, R.id.imageViewSkuIcon, "field 'imageViewIcon'", ImageView.class);
    target.textViewSkuTitle = Utils.findRequiredViewAsType(source, R.id.textViewSkuTitle, "field 'textViewSkuTitle'", TextView.class);
    target.textViewSkuDescription = Utils.findRequiredViewAsType(source, R.id.textViewSkuDescription, "field 'textViewSkuDescription'", TextView.class);
    target.textViewSkuPrice = Utils.findRequiredViewAsType(source, R.id.textViewSkuPrice, "field 'textViewSkuPrice'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    AdapterSku.SkuDetailsItemViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.imageViewIcon = null;
    target.textViewSkuTitle = null;
    target.textViewSkuDescription = null;
    target.textViewSkuPrice = null;
  }
}
