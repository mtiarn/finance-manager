// Generated code from Butter Knife. Do not modify!
package com.mtiarn.finance.adapter;

import android.support.annotation.UiThread;
import android.support.v7.widget.AppCompatCheckBox;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import butterknife.internal.Utils;
import com.mtiarn.finance.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AdapterFilters$AmountFilterViewHolder_ViewBinding extends AdapterFilters$BaseViewHolder_ViewBinding {
  private AdapterFilters.AmountFilterViewHolder target;

  @UiThread
  public AdapterFilters$AmountFilterViewHolder_ViewBinding(AdapterFilters.AmountFilterViewHolder target,
      View source) {
    super(target, source);

    this.target = target;

    target.checkBoxOutcome = Utils.findRequiredViewAsType(source, R.id.check_box_outcome, "field 'checkBoxOutcome'", AppCompatCheckBox.class);
    target.checkBoxIncome = Utils.findRequiredViewAsType(source, R.id.check_box_income, "field 'checkBoxIncome'", AppCompatCheckBox.class);
    target.editTextMin = Utils.findRequiredViewAsType(source, R.id.edit_text_min_amount, "field 'editTextMin'", EditText.class);
    target.editTextMax = Utils.findRequiredViewAsType(source, R.id.edit_text_max_amount, "field 'editTextMax'", EditText.class);
    target.radioGroupType = Utils.findRequiredViewAsType(source, R.id.radio_group_type, "field 'radioGroupType'", RadioGroup.class);
    target.radioButtonTypeTransaction = Utils.findRequiredViewAsType(source, R.id.radio_button_type_transaction, "field 'radioButtonTypeTransaction'", RadioButton.class);
    target.radioButtonTypeTransfer = Utils.findRequiredViewAsType(source, R.id.radio_button_type_transfer, "field 'radioButtonTypeTransfer'", RadioButton.class);
    target.radioButtonTypeBoth = Utils.findRequiredViewAsType(source, R.id.radio_button_type_both, "field 'radioButtonTypeBoth'", RadioButton.class);
  }

  @Override
  public void unbind() {
    AdapterFilters.AmountFilterViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.checkBoxOutcome = null;
    target.checkBoxIncome = null;
    target.editTextMin = null;
    target.editTextMax = null;
    target.radioGroupType = null;
    target.radioButtonTypeTransaction = null;
    target.radioButtonTypeTransfer = null;
    target.radioButtonTypeBoth = null;

    super.unbind();
  }
}
