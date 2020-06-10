package com.mtiarn.finance.di;

import android.content.Context;

import com.mtiarn.finance.ActivityEditTransaction;
import com.mtiarn.finance.ActivityMain;
import com.mtiarn.finance.ActivityPro;
import com.mtiarn.finance.FragmentAccounts;
import com.mtiarn.finance.FragmentSummary;
import com.mtiarn.finance.FragmentTransactions;
import com.mtiarn.finance.adapter.viewholders.TransactionViewHolderParams;
import com.mtiarn.finance.di.modules.BillingModule;
import com.mtiarn.finance.di.modules.ContextModule;
import com.mtiarn.finance.di.modules.DaoModule;
import com.mtiarn.finance.di.modules.FtsApiModule;
import com.mtiarn.finance.di.modules.FtsHelperModule;
import com.mtiarn.finance.di.modules.FtsRetrofitModule;
import com.mtiarn.finance.di.modules.PreferencesModule;
import com.mtiarn.finance.fts.FtsHelper;
import com.mtiarn.finance.iab.BillingService;
import com.mtiarn.finance.widgets.ToolbarActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ContextModule.class, PreferencesModule.class, BillingModule.class, DaoModule.class,
		FtsRetrofitModule.class, FtsApiModule.class, FtsHelperModule.class})
public interface AppComponent {
	Context getContext();

	void inject(BillingService billingService);
	void inject(ActivityMain activityMain);
	void inject(FragmentAccounts fragmentAccounts);
	void inject(FragmentSummary fragmentSummary);
	void inject(FragmentTransactions fragmentTransactions);
	void inject(ActivityPro activityPro);
	void inject(ToolbarActivity toolbarActivity);
	void inject(ActivityEditTransaction activityEditTransaction);
	void inject(FtsHelper ftsHelper);
	void inject(TransactionViewHolderParams transactionViewHolderParams);
}
