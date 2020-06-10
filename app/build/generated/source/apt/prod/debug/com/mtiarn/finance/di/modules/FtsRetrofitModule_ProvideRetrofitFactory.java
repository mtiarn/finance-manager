// Generated by Dagger (https://google.github.io/dagger).
package com.mtiarn.finance.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import retrofit2.Retrofit;

public final class FtsRetrofitModule_ProvideRetrofitFactory implements Factory<Retrofit> {
  private final FtsRetrofitModule module;

  private final Provider<Retrofit.Builder> builderProvider;

  public FtsRetrofitModule_ProvideRetrofitFactory(
      FtsRetrofitModule module, Provider<Retrofit.Builder> builderProvider) {
    this.module = module;
    this.builderProvider = builderProvider;
  }

  @Override
  public Retrofit get() {
    return provideInstance(module, builderProvider);
  }

  public static Retrofit provideInstance(
      FtsRetrofitModule module, Provider<Retrofit.Builder> builderProvider) {
    return proxyProvideRetrofit(module, builderProvider.get());
  }

  public static FtsRetrofitModule_ProvideRetrofitFactory create(
      FtsRetrofitModule module, Provider<Retrofit.Builder> builderProvider) {
    return new FtsRetrofitModule_ProvideRetrofitFactory(module, builderProvider);
  }

  public static Retrofit proxyProvideRetrofit(
      FtsRetrofitModule instance, Retrofit.Builder builder) {
    return Preconditions.checkNotNull(
        instance.provideRetrofit(builder),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
