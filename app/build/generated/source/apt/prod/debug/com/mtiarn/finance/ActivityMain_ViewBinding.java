// Generated code from Butter Knife. Do not modify!
package com.mtiarn.finance;

import android.support.annotation.UiThread;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.internal.Utils;
import com.mtiarn.finance.widgets.ToolbarActivity_ViewBinding;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ActivityMain_ViewBinding extends ToolbarActivity_ViewBinding {
  private ActivityMain target;

  @UiThread
  public ActivityMain_ViewBinding(ActivityMain target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ActivityMain_ViewBinding(ActivityMain target, View source) {
    super(target, source);

    this.target = target;

    target.viewPager = Utils.findRequiredViewAsType(source, R.id.pager, "field 'viewPager'", ViewPager.class);
    target.tabLayout = Utils.findRequiredViewAsType(source, R.id.tabLayout, "field 'tabLayout'", TabLayout.class);
    target.mSlidingUpTransactions = Utils.findOptionalViewAsType(source, R.id.sliding_layout_transactions, "field 'mSlidingUpTransactions'", SlidingUpPanelLayout.class);
    target.mSlidingUpAccounts = Utils.findOptionalViewAsType(source, R.id.sliding_layout_accounts, "field 'mSlidingUpAccounts'", SlidingUpPanelLayout.class);
    target.coordinatorLayout = Utils.findRequiredViewAsType(source, R.id.coordinatorLayout, "field 'coordinatorLayout'", CoordinatorLayout.class);
    target.mAppBarLayout = Utils.findRequiredViewAsType(source, R.id.appbar, "field 'mAppBarLayout'", AppBarLayout.class);
    target.mTextViewActiveSet = Utils.findRequiredViewAsType(source, R.id.textViewSubtitle, "field 'mTextViewActiveSet'", TextView.class);
    target.mButtonTemplates = Utils.findRequiredViewAsType(source, R.id.buttonTemplates, "field 'mButtonTemplates'", Button.class);
    target.mButtonScanQR = Utils.findRequiredViewAsType(source, R.id.buttonScanQR, "field 'mButtonScanQR'", Button.class);
    target.mButtonNewExpense = Utils.findRequiredViewAsType(source, R.id.buttonNewExpense, "field 'mButtonNewExpense'", Button.class);
    target.mButtonNewIncome = Utils.findRequiredViewAsType(source, R.id.buttonNewIncome, "field 'mButtonNewIncome'", Button.class);
    target.mButtonNewTransfer = Utils.findRequiredViewAsType(source, R.id.buttonNewTransfer, "field 'mButtonNewTransfer'", Button.class);
    target.mButtonsBar = Utils.findRequiredViewAsType(source, R.id.buttonsBar, "field 'mButtonsBar'", LinearLayout.class);
    target.mButtonsBarContainer = Utils.findRequiredViewAsType(source, R.id.buttonsBarContainer, "field 'mButtonsBarContainer'", FrameLayout.class);
  }

  @Override
  public void unbind() {
    ActivityMain target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.viewPager = null;
    target.tabLayout = null;
    target.mSlidingUpTransactions = null;
    target.mSlidingUpAccounts = null;
    target.coordinatorLayout = null;
    target.mAppBarLayout = null;
    target.mTextViewActiveSet = null;
    target.mButtonTemplates = null;
    target.mButtonScanQR = null;
    target.mButtonNewExpense = null;
    target.mButtonNewIncome = null;
    target.mButtonNewTransfer = null;
    target.mButtonsBar = null;
    target.mButtonsBarContainer = null;

    super.unbind();
  }
}
