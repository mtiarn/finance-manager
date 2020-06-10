package com.mtiarn.finance.di.modules;

import com.mtiarn.finance.fts.FtsHelper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class FtsHelperModule {
    @Provides
    @Singleton
    public FtsHelper provideFtsHelper() {
        return new FtsHelper();
    }
}
