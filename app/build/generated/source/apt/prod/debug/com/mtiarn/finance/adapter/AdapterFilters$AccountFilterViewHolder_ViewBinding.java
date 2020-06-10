// Generated code from Butter Knife. Do not modify!
package com.mtiarn.finance.adapter;

import android.support.annotation.UiThread;
import android.view.View;
import butterknife.internal.Utils;
import com.mtiarn.finance.R;
import com.mtiarn.finance.tag.TagView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AdapterFilters$AccountFilterViewHolder_ViewBinding extends AdapterFilters$BaseViewHolder_ViewBinding {
  private AdapterFilters.AccountFilterViewHolder target;

  @UiThread
  public AdapterFilters$AccountFilterViewHolder_ViewBinding(AdapterFilters.AccountFilterViewHolder target,
      View source) {
    super(target, source);

    this.target = target;

    target.tagView = Utils.findRequiredViewAsType(source, R.id.tag_view, "field 'tagView'", TagView.class);
  }

  @Override
  public void unbind() {
    AdapterFilters.AccountFilterViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tagView = null;

    super.unbind();
  }
}
