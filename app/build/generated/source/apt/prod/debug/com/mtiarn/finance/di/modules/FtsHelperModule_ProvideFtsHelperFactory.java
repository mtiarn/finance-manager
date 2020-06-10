// Generated by Dagger (https://google.github.io/dagger).
package com.mtiarn.finance.di.modules;

import com.mtiarn.finance.fts.FtsHelper;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class FtsHelperModule_ProvideFtsHelperFactory implements Factory<FtsHelper> {
  private final FtsHelperModule module;

  public FtsHelperModule_ProvideFtsHelperFactory(FtsHelperModule module) {
    this.module = module;
  }

  @Override
  public FtsHelper get() {
    return provideInstance(module);
  }

  public static FtsHelper provideInstance(FtsHelperModule module) {
    return proxyProvideFtsHelper(module);
  }

  public static FtsHelperModule_ProvideFtsHelperFactory create(FtsHelperModule module) {
    return new FtsHelperModule_ProvideFtsHelperFactory(module);
  }

  public static FtsHelper proxyProvideFtsHelper(FtsHelperModule instance) {
    return Preconditions.checkNotNull(
        instance.provideFtsHelper(), "Cannot return null from a non-@Nullable @Provides method");
  }
}