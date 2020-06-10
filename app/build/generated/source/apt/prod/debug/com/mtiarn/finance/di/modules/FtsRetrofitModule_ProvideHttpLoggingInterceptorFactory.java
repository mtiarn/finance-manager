// Generated by Dagger (https://google.github.io/dagger).
package com.mtiarn.finance.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import okhttp3.logging.HttpLoggingInterceptor;

public final class FtsRetrofitModule_ProvideHttpLoggingInterceptorFactory
    implements Factory<HttpLoggingInterceptor> {
  private final FtsRetrofitModule module;

  public FtsRetrofitModule_ProvideHttpLoggingInterceptorFactory(FtsRetrofitModule module) {
    this.module = module;
  }

  @Override
  public HttpLoggingInterceptor get() {
    return provideInstance(module);
  }

  public static HttpLoggingInterceptor provideInstance(FtsRetrofitModule module) {
    return proxyProvideHttpLoggingInterceptor(module);
  }

  public static FtsRetrofitModule_ProvideHttpLoggingInterceptorFactory create(
      FtsRetrofitModule module) {
    return new FtsRetrofitModule_ProvideHttpLoggingInterceptorFactory(module);
  }

  public static HttpLoggingInterceptor proxyProvideHttpLoggingInterceptor(
      FtsRetrofitModule instance) {
    return Preconditions.checkNotNull(
        instance.provideHttpLoggingInterceptor(),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
