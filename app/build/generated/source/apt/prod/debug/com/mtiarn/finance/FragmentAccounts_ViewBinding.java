// Generated code from Butter Knife. Do not modify!
package com.mtiarn.finance;

import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import butterknife.internal.Utils;
import com.mtiarn.finance.widgets.ContextMenuRecyclerView;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;
import java.lang.IllegalStateException;
import java.lang.Override;

public class FragmentAccounts_ViewBinding extends BaseListFragment_ViewBinding {
  private FragmentAccounts target;

  @UiThread
  public FragmentAccounts_ViewBinding(FragmentAccounts target, View source) {
    super(target, source);

    this.target = target;

    target.mLayoutSumTable = Utils.findRequiredViewAsType(source, R.id.layoutSummaryTable, "field 'mLayoutSumTable'", TableLayout.class);
    target.mSlidingUpPanelLayout = Utils.findRequiredViewAsType(source, R.id.sliding_layout_accounts, "field 'mSlidingUpPanelLayout'", SlidingUpPanelLayout.class);
    target.mRecyclerViewAccountsSets = Utils.findRequiredViewAsType(source, R.id.recycler_view_accounts_sets, "field 'mRecyclerViewAccountsSets'", ContextMenuRecyclerView.class);
    target.mButtonAddAccountSet = Utils.findRequiredViewAsType(source, R.id.buttonAddAccountSet, "field 'mButtonAddAccountSet'", Button.class);
    target.mButtonAddAccount = Utils.findRequiredViewAsType(source, R.id.buttonAddAccount, "field 'mButtonAddAccount'", Button.class);
    target.mImageViewPullMe = Utils.findRequiredViewAsType(source, R.id.imageViewPullMe, "field 'mImageViewPullMe'", ImageView.class);
    target.mTextViewPullToCreateAccount = Utils.findRequiredViewAsType(source, R.id.textview_pull_to_create_account, "field 'mTextViewPullToCreateAccount'", TextView.class);
    target.mLayoutPullMe = Utils.findRequiredViewAsType(source, R.id.layout_pull_me, "field 'mLayoutPullMe'", LinearLayout.class);
  }

  @Override
  public void unbind() {
    FragmentAccounts target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mLayoutSumTable = null;
    target.mSlidingUpPanelLayout = null;
    target.mRecyclerViewAccountsSets = null;
    target.mButtonAddAccountSet = null;
    target.mButtonAddAccount = null;
    target.mImageViewPullMe = null;
    target.mTextViewPullToCreateAccount = null;
    target.mLayoutPullMe = null;

    super.unbind();
  }
}
