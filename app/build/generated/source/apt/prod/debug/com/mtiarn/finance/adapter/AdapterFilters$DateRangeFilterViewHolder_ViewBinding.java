// Generated code from Butter Knife. Do not modify!
package com.mtiarn.finance.adapter;

import android.support.annotation.UiThread;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import butterknife.internal.Utils;
import com.mtiarn.finance.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AdapterFilters$DateRangeFilterViewHolder_ViewBinding extends AdapterFilters$BaseViewHolder_ViewBinding {
  private AdapterFilters.DateRangeFilterViewHolder target;

  @UiThread
  public AdapterFilters$DateRangeFilterViewHolder_ViewBinding(AdapterFilters.DateRangeFilterViewHolder target,
      View source) {
    super(target, source);

    this.target = target;

    target.buttonStartDate = Utils.findRequiredViewAsType(source, R.id.edit_text_start_date, "field 'buttonStartDate'", EditText.class);
    target.buttonEndDate = Utils.findRequiredViewAsType(source, R.id.edit_text_end_date, "field 'buttonEndDate'", EditText.class);
    target.buttonMore = Utils.findRequiredViewAsType(source, R.id.button_more, "field 'buttonMore'", ImageButton.class);
  }

  @Override
  public void unbind() {
    AdapterFilters.DateRangeFilterViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.buttonStartDate = null;
    target.buttonEndDate = null;
    target.buttonMore = null;

    super.unbind();
  }
}
