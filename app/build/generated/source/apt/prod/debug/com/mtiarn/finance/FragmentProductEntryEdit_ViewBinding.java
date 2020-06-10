// Generated code from Butter Knife. Do not modify!
package com.mtiarn.finance;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ImageButton;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.mtiarn.finance.widgets.AmountEditor;
import java.lang.IllegalStateException;
import java.lang.Override;

public class FragmentProductEntryEdit_ViewBinding implements Unbinder {
  private FragmentProductEntryEdit target;

  @UiThread
  public FragmentProductEntryEdit_ViewBinding(FragmentProductEntryEdit target, View source) {
    this.target = target;

    target.mTextViewProduct = Utils.findRequiredViewAsType(source, R.id.textViewProduct, "field 'mTextViewProduct'", AutoCompleteTextView.class);
    target.mTextInputLayoutProduct = Utils.findRequiredViewAsType(source, R.id.textInputLayoutProduct, "field 'mTextInputLayoutProduct'", TextInputLayout.class);
    target.mImageButtonDeleteProduct = Utils.findRequiredViewAsType(source, R.id.imageButtonDeleteProduct, "field 'mImageButtonDeleteProduct'", ImageButton.class);
    target.mTextViewCategory = Utils.findRequiredViewAsType(source, R.id.textViewCategory, "field 'mTextViewCategory'", EditText.class);
    target.mTextInputLayoutCategory = Utils.findRequiredViewAsType(source, R.id.textInputLayoutCategory, "field 'mTextInputLayoutCategory'", TextInputLayout.class);
    target.mImageButtonDeleteCategory = Utils.findRequiredViewAsType(source, R.id.imageButtonDeleteCategory, "field 'mImageButtonDeleteCategory'", ImageButton.class);
    target.mTextViewProject = Utils.findRequiredViewAsType(source, R.id.textViewProject, "field 'mTextViewProject'", EditText.class);
    target.mTextInputLayoutProject = Utils.findRequiredViewAsType(source, R.id.textInputLayoutProject, "field 'mTextInputLayoutProject'", TextInputLayout.class);
    target.mImageButtonDeleteProject = Utils.findRequiredViewAsType(source, R.id.imageButtonDeleteProject, "field 'mImageButtonDeleteProject'", ImageButton.class);
    target.mAmountEditor = Utils.findRequiredViewAsType(source, R.id.amount_editor, "field 'mAmountEditor'", AmountEditor.class);
    target.mTextViewQuantity = Utils.findRequiredViewAsType(source, R.id.textViewQuantity, "field 'mTextViewQuantity'", EditText.class);
    target.mTextInputLayoutQuantity = Utils.findRequiredViewAsType(source, R.id.textInputLayoutQuantity, "field 'mTextInputLayoutQuantity'", TextInputLayout.class);
    target.mImageButtonMore = Utils.findRequiredViewAsType(source, R.id.imageButtonMore, "field 'mImageButtonMore'", ImageButton.class);
    target.mImageButtonLess = Utils.findRequiredViewAsType(source, R.id.imageButtonLess, "field 'mImageButtonLess'", ImageButton.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    FragmentProductEntryEdit target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mTextViewProduct = null;
    target.mTextInputLayoutProduct = null;
    target.mImageButtonDeleteProduct = null;
    target.mTextViewCategory = null;
    target.mTextInputLayoutCategory = null;
    target.mImageButtonDeleteCategory = null;
    target.mTextViewProject = null;
    target.mTextInputLayoutProject = null;
    target.mImageButtonDeleteProject = null;
    target.mAmountEditor = null;
    target.mTextViewQuantity = null;
    target.mTextInputLayoutQuantity = null;
    target.mImageButtonMore = null;
    target.mImageButtonLess = null;
  }
}
