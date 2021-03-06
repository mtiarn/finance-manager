// Generated by Dagger (https://google.github.io/dagger).
package com.mtiarn.finance.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.Converter;
import retrofit2.Retrofit;

public final class FtsRetrofitModule_ProvideRetrofitBuilderFactory
    implements Factory<Retrofit.Builder> {
  private final FtsRetrofitModule module;

  private final Provider<Converter.Factory> converterFactoryProvider;

  private final Provider<OkHttpClient> okHttpClientProvider;

  public FtsRetrofitModule_ProvideRetrofitBuilderFactory(
      FtsRetrofitModule module,
      Provider<Converter.Factory> converterFactoryProvider,
      Provider<OkHttpClient> okHttpClientProvider) {
    this.module = module;
    this.converterFactoryProvider = converterFactoryProvider;
    this.okHttpClientProvider = okHttpClientProvider;
  }

  @Override
  public Retrofit.Builder get() {
    return provideInstance(module, converterFactoryProvider, okHttpClientProvider);
  }

  public static Retrofit.Builder provideInstance(
      FtsRetrofitModule module,
      Provider<Converter.Factory> converterFactoryProvider,
      Provider<OkHttpClient> okHttpClientProvider) {
    return proxyProvideRetrofitBuilder(
        module, converterFactoryProvider.get(), okHttpClientProvider.get());
  }

  public static FtsRetrofitModule_ProvideRetrofitBuilderFactory create(
      FtsRetrofitModule module,
      Provider<Converter.Factory> converterFactoryProvider,
      Provider<OkHttpClient> okHttpClientProvider) {
    return new FtsRetrofitModule_ProvideRetrofitBuilderFactory(
        module, converterFactoryProvider, okHttpClientProvider);
  }

  public static Retrofit.Builder proxyProvideRetrofitBuilder(
      FtsRetrofitModule instance, Converter.Factory converterFactory, OkHttpClient okHttpClient) {
    return Preconditions.checkNotNull(
        instance.provideRetrofitBuilder(converterFactory, okHttpClient),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
