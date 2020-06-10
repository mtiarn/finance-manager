package com.mtiarn.finance.di.modules;

import com.mtiarn.finance.fts.FtsApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module(includes = {FtsRetrofitModule.class})
public class FtsApiModule {
    @Provides
    @Singleton
    public FtsApi provideSyncApi(Retrofit retrofit) {
        return retrofit.create(FtsApi.class);
    }
}
