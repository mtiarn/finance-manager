// Generated code from Butter Knife. Do not modify!
package com.mtiarn.finance;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class FragmentCabbageEdit_ViewBinding implements Unbinder {
  private FragmentCabbageEdit target;

  private View view2131296384;

  @UiThread
  public FragmentCabbageEdit_ViewBinding(final FragmentCabbageEdit target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.button_system_currencies, "field 'buttonSystemCurrencies' and method 'selectSystemCurrencyClick'");
    target.buttonSystemCurrencies = Utils.castView(view, R.id.button_system_currencies, "field 'buttonSystemCurrencies'", Button.class);
    view2131296384 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.selectSystemCurrencyClick();
      }
    });
    target.editTextName = Utils.findRequiredViewAsType(source, R.id.edit_text_name, "field 'editTextName'", EditText.class);
    target.editTextCode = Utils.findRequiredViewAsType(source, R.id.edit_text_code, "field 'editTextCode'", EditText.class);
    target.editTextSymbol = Utils.findRequiredViewAsType(source, R.id.edit_text_symbol, "field 'editTextSymbol'", EditText.class);
    target.editTextScale = Utils.findRequiredViewAsType(source, R.id.edit_text_scale, "field 'editTextScale'", EditText.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    FragmentCabbageEdit target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.buttonSystemCurrencies = null;
    target.editTextName = null;
    target.editTextCode = null;
    target.editTextSymbol = null;
    target.editTextScale = null;

    view2131296384.setOnClickListener(null);
    view2131296384 = null;
  }
}
