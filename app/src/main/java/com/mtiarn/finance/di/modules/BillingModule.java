package com.mtiarn.finance.di.modules;

import com.mtiarn.finance.iab.BillingService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class BillingModule {
    @Provides
    @Singleton
    public BillingService provideBillingService() {
        return new BillingService();
    }
}
