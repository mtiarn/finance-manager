// Generated code from Butter Knife. Do not modify!
package com.mtiarn.finance.adapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.mtiarn.finance.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AdapterFilters$BaseViewHolder_ViewBinding implements Unbinder {
  private AdapterFilters.BaseViewHolder target;

  @UiThread
  public AdapterFilters$BaseViewHolder_ViewBinding(AdapterFilters.BaseViewHolder target,
      View source) {
    this.target = target;

    target.textViewCaption = Utils.findRequiredViewAsType(source, R.id.caption, "field 'textViewCaption'", TextView.class);
    target.switchEnabled = Utils.findRequiredViewAsType(source, R.id.switch_enabled, "field 'switchEnabled'", Switch.class);
    target.mButtonDelete = Utils.findRequiredViewAsType(source, R.id.buttonDelete, "field 'mButtonDelete'", ImageButton.class);
    target.mSwitchExclude = Utils.findRequiredViewAsType(source, R.id.switch_exclude, "field 'mSwitchExclude'", Switch.class);
    target.textViewNot = Utils.findRequiredViewAsType(source, R.id.text_view_not, "field 'textViewNot'", TextView.class);
    target.textViewOn = Utils.findRequiredViewAsType(source, R.id.text_view_on, "field 'textViewOn'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    AdapterFilters.BaseViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.textViewCaption = null;
    target.switchEnabled = null;
    target.mButtonDelete = null;
    target.mSwitchExclude = null;
    target.textViewNot = null;
    target.textViewOn = null;
  }
}
