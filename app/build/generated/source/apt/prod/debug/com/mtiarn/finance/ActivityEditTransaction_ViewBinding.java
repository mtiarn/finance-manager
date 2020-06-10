// Generated code from Butter Knife. Do not modify!
package com.mtiarn.finance;

import android.support.annotation.UiThread;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.mtiarn.finance.widgets.AmountEditor;
import com.mtiarn.finance.widgets.MyViewPager;
import com.mtiarn.finance.widgets.SmsEditText;
import com.mtiarn.finance.widgets.ToolbarActivity_ViewBinding;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ActivityEditTransaction_ViewBinding extends ToolbarActivity_ViewBinding {
  private ActivityEditTransaction target;

  private View view2131296609;

  private View view2131296608;

  private View view2131296367;

  private View view2131296610;

  private View view2131296607;

  private View view2131296613;

  private View view2131296378;

  @UiThread
  public ActivityEditTransaction_ViewBinding(ActivityEditTransaction target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ActivityEditTransaction_ViewBinding(final ActivityEditTransaction target, View source) {
    super(target, source);

    this.target = target;

    View view;
    target.teLayDateTime = Utils.findRequiredViewAsType(source, R.id.te_lay_DateTime, "field 'teLayDateTime'", LinearLayout.class);
    target.editTextTemplateName = Utils.findRequiredViewAsType(source, R.id.editTextTemplateName, "field 'editTextTemplateName'", EditText.class);
    target.layoutCategory = Utils.findRequiredViewAsType(source, R.id.layoutCategory, "field 'layoutCategory'", RelativeLayout.class);
    target.layoutSms = Utils.findRequiredViewAsType(source, R.id.layoutSms, "field 'layoutSms'", RelativeLayout.class);
    target.layoutProject = Utils.findRequiredViewAsType(source, R.id.layoutProject, "field 'layoutProject'", RelativeLayout.class);
    target.layoutLocation = Utils.findRequiredViewAsType(source, R.id.layoutLocation, "field 'layoutLocation'", RelativeLayout.class);
    target.textViewSrcAmount = Utils.findRequiredViewAsType(source, R.id.textViewSrcAmount, "field 'textViewSrcAmount'", EditText.class);
    target.edDepartment = Utils.findRequiredViewAsType(source, R.id.textViewDepartment, "field 'edDepartment'", EditText.class);
    view = Utils.findRequiredView(source, R.id.imageButtonDeleteDepartment, "field 'imageButtonDeleteDepartment' and method 'onTrashButtonClick'");
    target.imageButtonDeleteDepartment = Utils.castView(view, R.id.imageButtonDeleteDepartment, "field 'imageButtonDeleteDepartment'", ImageButton.class);
    view2131296609 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onTrashButtonClick(p0);
      }
    });
    target.layoutDepartment = Utils.findRequiredViewAsType(source, R.id.layoutDepartment, "field 'layoutDepartment'", RelativeLayout.class);
    target.mTextViewSimpleDebt = Utils.findRequiredViewAsType(source, R.id.textViewSimpleDebt, "field 'mTextViewSimpleDebt'", EditText.class);
    view = Utils.findRequiredView(source, R.id.imageButtonDeleteDebt, "field 'mImageButtonDeleteDebt' and method 'onTrashButtonClick'");
    target.mImageButtonDeleteDebt = Utils.castView(view, R.id.imageButtonDeleteDebt, "field 'mImageButtonDeleteDebt'", ImageButton.class);
    view2131296608 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onTrashButtonClick(p0);
      }
    });
    target.layoutSimpleDebt = Utils.findRequiredViewAsType(source, R.id.layoutSimpleDebt, "field 'layoutSimpleDebt'", RelativeLayout.class);
    view = Utils.findRequiredView(source, R.id.buttonMore, "field 'mButtonMore' and method 'onClick'");
    target.mButtonMore = Utils.castView(view, R.id.buttonMore, "field 'mButtonMore'", Button.class);
    view2131296367 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick();
      }
    });
    target.mTextInputLayoutTemplateName = Utils.findRequiredViewAsType(source, R.id.textInputLayoutTemplateName, "field 'mTextInputLayoutTemplateName'", TextInputLayout.class);
    target.mTextInputLayoutSrcAmount = Utils.findRequiredViewAsType(source, R.id.textInputLayoutSrcAmount, "field 'mTextInputLayoutSrcAmount'", TextInputLayout.class);
    target.mTextInputLayoutExchangeRate = Utils.findRequiredViewAsType(source, R.id.textInputLayoutExchangeRate, "field 'mTextInputLayoutExchangeRate'", TextInputLayout.class);
    target.viewPager = Utils.findRequiredViewAsType(source, R.id.te_pager_payee, "field 'viewPager'", MyViewPager.class);
    target.textInputLayoutAccount = Utils.findRequiredViewAsType(source, R.id.textInputLayoutAccount, "field 'textInputLayoutAccount'", TextInputLayout.class);
    target.textViewAccount = Utils.findRequiredViewAsType(source, R.id.textViewAccount, "field 'textViewAccount'", EditText.class);
    target.edCategory = Utils.findRequiredViewAsType(source, R.id.textViewCategory, "field 'edCategory'", EditText.class);
    target.edProject = Utils.findRequiredViewAsType(source, R.id.textViewProject, "field 'edProject'", EditText.class);
    target.edLocation = Utils.findRequiredViewAsType(source, R.id.textViewLocation, "field 'edLocation'", EditText.class);
    target.edDate = Utils.findRequiredViewAsType(source, R.id.editTextDate, "field 'edDate'", EditText.class);
    target.edTime = Utils.findRequiredViewAsType(source, R.id.te_ed_Time, "field 'edTime'", EditText.class);
    target.edExchangeRate = Utils.findRequiredViewAsType(source, R.id.edit_text_exchange_rate, "field 'edExchangeRate'", EditText.class);
    target.edComment = Utils.findRequiredViewAsType(source, R.id.editTextComment, "field 'edComment'", EditText.class);
    target.edSms = Utils.findRequiredViewAsType(source, R.id.te_tv_sms, "field 'edSms'", SmsEditText.class);
    target.amountEditor = Utils.findRequiredViewAsType(source, R.id.amount_editor, "field 'amountEditor'", AmountEditor.class);
    target.destAmountEditor = Utils.findRequiredViewAsType(source, R.id.dest_amount_editor, "field 'destAmountEditor'", AmountEditor.class);
    view = Utils.findRequiredView(source, R.id.imageButtonDeleteLocation, "field 'imageButtonDeleteLocation' and method 'onTrashButtonClick'");
    target.imageButtonDeleteLocation = Utils.castView(view, R.id.imageButtonDeleteLocation, "field 'imageButtonDeleteLocation'", ImageButton.class);
    view2131296610 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onTrashButtonClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.imageButtonDeleteCategory, "field 'imageButtonDeleteCategory' and method 'onTrashButtonClick'");
    target.imageButtonDeleteCategory = Utils.castView(view, R.id.imageButtonDeleteCategory, "field 'imageButtonDeleteCategory'", ImageButton.class);
    view2131296607 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onTrashButtonClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.imageButtonDeleteProject, "field 'imageButtonDeleteProject' and method 'onTrashButtonClick'");
    target.imageButtonDeleteProject = Utils.castView(view, R.id.imageButtonDeleteProject, "field 'imageButtonDeleteProject'", ImageButton.class);
    view2131296613 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onTrashButtonClick(p0);
      }
    });
    target.imageButtonAddMarker = Utils.findRequiredViewAsType(source, R.id.imageButtonAddMarker, "field 'imageButtonAddMarker'", ImageButton.class);
    target.tabLayoutType = Utils.findRequiredViewAsType(source, R.id.tabLayoutType, "field 'tabLayoutType'", TabLayout.class);
    target.mTextViewFN = Utils.findRequiredViewAsType(source, R.id.textViewFN, "field 'mTextViewFN'", EditText.class);
    target.mTextViewFD = Utils.findRequiredViewAsType(source, R.id.textViewFD, "field 'mTextViewFD'", EditText.class);
    target.mTextViewFP = Utils.findRequiredViewAsType(source, R.id.textViewFP, "field 'mTextViewFP'", EditText.class);
    target.mImageButtonDownloadReceipt = Utils.findRequiredViewAsType(source, R.id.imageButtonDownloadReceipt, "field 'mImageButtonDownloadReceipt'", ImageButton.class);
    target.mImageButtonScanQR = Utils.findRequiredViewAsType(source, R.id.imageButtonScanQR, "field 'mImageButtonScanQR'", ImageButton.class);
    target.mLayoutFTS = Utils.findRequiredViewAsType(source, R.id.layoutFTS, "field 'mLayoutFTS'", ConstraintLayout.class);
    target.mTextViewCaptonProductList = Utils.findRequiredViewAsType(source, R.id.textViewCaptonProductList, "field 'mTextViewCaptonProductList'", TextView.class);
    target.mExpandableIndicator = Utils.findRequiredViewAsType(source, R.id.expandableIndicator, "field 'mExpandableIndicator'", ImageView.class);
    target.mRecyclerViewProductList = Utils.findRequiredViewAsType(source, R.id.recyclerViewProductList, "field 'mRecyclerViewProductList'", RecyclerView.class);
    target.mLayoutProductList = Utils.findRequiredViewAsType(source, R.id.layoutProductList, "field 'mLayoutProductList'", ConstraintLayout.class);
    target.mImageViewLoadingProducts = Utils.findRequiredViewAsType(source, R.id.imageViewLoadingProducts, "field 'mImageViewLoadingProducts'", ImageView.class);
    target.mTextViewLoadingProducts = Utils.findRequiredViewAsType(source, R.id.textViewLoadingProducts, "field 'mTextViewLoadingProducts'", TextView.class);
    target.mLayoutLoadingProducts = Utils.findRequiredViewAsType(source, R.id.layoutLoadingProducts, "field 'mLayoutLoadingProducts'", ConstraintLayout.class);
    target.mImageButtonInvertExRate = Utils.findRequiredViewAsType(source, R.id.imageButtonInvertExRate, "field 'mImageButtonInvertExRate'", ImageButton.class);
    target.mLayoutExchangeRate = Utils.findRequiredViewAsType(source, R.id.layoutExchangeRate, "field 'mLayoutExchangeRate'", RelativeLayout.class);
    target.mFabBGLayout = Utils.findRequiredView(source, R.id.fabBGLayout, "field 'mFabBGLayout'");
    target.mFabSelectAll = Utils.findRequiredViewAsType(source, R.id.fabSelectAll, "field 'mFabSelectAll'", FloatingActionButton.class);
    target.mFabSelectAllLayout = Utils.findRequiredViewAsType(source, R.id.fabSelectAllLayout, "field 'mFabSelectAllLayout'", LinearLayout.class);
    target.mFabUnselectAll = Utils.findRequiredViewAsType(source, R.id.fabUnselectAll, "field 'mFabUnselectAll'", FloatingActionButton.class);
    target.mFabUnselectAllLayout = Utils.findRequiredViewAsType(source, R.id.fabUnselectAllLayout, "field 'mFabUnselectAllLayout'", LinearLayout.class);
    target.mFabSetCategory = Utils.findRequiredViewAsType(source, R.id.fabSetCategory, "field 'mFabSetCategory'", FloatingActionButton.class);
    target.mFabSetCategoryLayout = Utils.findRequiredViewAsType(source, R.id.fabSetCategoryLayout, "field 'mFabSetCategoryLayout'", LinearLayout.class);
    target.mFabSetProject = Utils.findRequiredViewAsType(source, R.id.fabSetProject, "field 'mFabSetProject'", FloatingActionButton.class);
    target.mFabSetProjectLayout = Utils.findRequiredViewAsType(source, R.id.fabSetProjectLayout, "field 'mFabSetProjectLayout'", LinearLayout.class);
    target.mFabDeleteSelected = Utils.findRequiredViewAsType(source, R.id.fabDeleteSelected, "field 'mFabDeleteSelected'", FloatingActionButton.class);
    target.mFabDeleteSelectedLayout = Utils.findRequiredViewAsType(source, R.id.fabDeleteSelectedLayout, "field 'mFabDeleteSelectedLayout'", LinearLayout.class);
    target.mFabMenuButtonRoot = Utils.findRequiredViewAsType(source, R.id.fabMenuButtonRoot, "field 'mFabMenuButtonRoot'", FloatingActionButton.class);
    target.mFabMenuButtonRootLayout = Utils.findRequiredViewAsType(source, R.id.fabMenuButtonRootLayout, "field 'mFabMenuButtonRootLayout'", LinearLayout.class);
    target.mLayoutPayeeOrDestAcc = Utils.findRequiredViewAsType(source, R.id.layoutPayeeOrDestAcc, "field 'mLayoutPayeeOrDestAcc'", LinearLayout.class);
    target.mLayoutAmounts = Utils.findRequiredViewAsType(source, R.id.layoutAmounts, "field 'mLayoutAmounts'", LinearLayout.class);
    target.mLayoutRoot = Utils.findRequiredViewAsType(source, R.id.layoutRoot, "field 'mLayoutRoot'", LinearLayout.class);
    target.mLayoutComment = Utils.findRequiredViewAsType(source, R.id.layoutComment, "field 'mLayoutComment'", TextInputLayout.class);
    view = Utils.findRequiredView(source, R.id.buttonSaveTransaction, "method 'onSaveClick'");
    view2131296378 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onSaveClick();
      }
    });
  }

  @Override
  public void unbind() {
    ActivityEditTransaction target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.teLayDateTime = null;
    target.editTextTemplateName = null;
    target.layoutCategory = null;
    target.layoutSms = null;
    target.layoutProject = null;
    target.layoutLocation = null;
    target.textViewSrcAmount = null;
    target.edDepartment = null;
    target.imageButtonDeleteDepartment = null;
    target.layoutDepartment = null;
    target.mTextViewSimpleDebt = null;
    target.mImageButtonDeleteDebt = null;
    target.layoutSimpleDebt = null;
    target.mButtonMore = null;
    target.mTextInputLayoutTemplateName = null;
    target.mTextInputLayoutSrcAmount = null;
    target.mTextInputLayoutExchangeRate = null;
    target.viewPager = null;
    target.textInputLayoutAccount = null;
    target.textViewAccount = null;
    target.edCategory = null;
    target.edProject = null;
    target.edLocation = null;
    target.edDate = null;
    target.edTime = null;
    target.edExchangeRate = null;
    target.edComment = null;
    target.edSms = null;
    target.amountEditor = null;
    target.destAmountEditor = null;
    target.imageButtonDeleteLocation = null;
    target.imageButtonDeleteCategory = null;
    target.imageButtonDeleteProject = null;
    target.imageButtonAddMarker = null;
    target.tabLayoutType = null;
    target.mTextViewFN = null;
    target.mTextViewFD = null;
    target.mTextViewFP = null;
    target.mImageButtonDownloadReceipt = null;
    target.mImageButtonScanQR = null;
    target.mLayoutFTS = null;
    target.mTextViewCaptonProductList = null;
    target.mExpandableIndicator = null;
    target.mRecyclerViewProductList = null;
    target.mLayoutProductList = null;
    target.mImageViewLoadingProducts = null;
    target.mTextViewLoadingProducts = null;
    target.mLayoutLoadingProducts = null;
    target.mImageButtonInvertExRate = null;
    target.mLayoutExchangeRate = null;
    target.mFabBGLayout = null;
    target.mFabSelectAll = null;
    target.mFabSelectAllLayout = null;
    target.mFabUnselectAll = null;
    target.mFabUnselectAllLayout = null;
    target.mFabSetCategory = null;
    target.mFabSetCategoryLayout = null;
    target.mFabSetProject = null;
    target.mFabSetProjectLayout = null;
    target.mFabDeleteSelected = null;
    target.mFabDeleteSelectedLayout = null;
    target.mFabMenuButtonRoot = null;
    target.mFabMenuButtonRootLayout = null;
    target.mLayoutPayeeOrDestAcc = null;
    target.mLayoutAmounts = null;
    target.mLayoutRoot = null;
    target.mLayoutComment = null;

    view2131296609.setOnClickListener(null);
    view2131296609 = null;
    view2131296608.setOnClickListener(null);
    view2131296608 = null;
    view2131296367.setOnClickListener(null);
    view2131296367 = null;
    view2131296610.setOnClickListener(null);
    view2131296610 = null;
    view2131296607.setOnClickListener(null);
    view2131296607 = null;
    view2131296613.setOnClickListener(null);
    view2131296613 = null;
    view2131296378.setOnClickListener(null);
    view2131296378 = null;

    super.unbind();
  }
}
