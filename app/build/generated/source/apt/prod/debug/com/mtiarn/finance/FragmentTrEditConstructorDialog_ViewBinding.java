// Generated code from Butter Knife. Do not modify!
package com.mtiarn.finance;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.mtiarn.finance.widgets.ContextMenuRecyclerView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class FragmentTrEditConstructorDialog_ViewBinding implements Unbinder {
  private FragmentTrEditConstructorDialog target;

  @UiThread
  public FragmentTrEditConstructorDialog_ViewBinding(FragmentTrEditConstructorDialog target,
      View source) {
    this.target = target;

    target.mRecyclerView = Utils.findRequiredViewAsType(source, R.id.recycler_view, "field 'mRecyclerView'", ContextMenuRecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    FragmentTrEditConstructorDialog target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mRecyclerView = null;
  }
}
