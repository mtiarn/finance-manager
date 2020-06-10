// Generated by Dagger (https://google.github.io/dagger).
package com.mtiarn.finance.di.modules;

import android.content.Context;
import com.mtiarn.finance.dao.CategoriesDAO;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class DaoModule_ProvideCategoriesDAOFactory implements Factory<CategoriesDAO> {
  private final DaoModule module;

  private final Provider<Context> contextProvider;

  public DaoModule_ProvideCategoriesDAOFactory(
      DaoModule module, Provider<Context> contextProvider) {
    this.module = module;
    this.contextProvider = contextProvider;
  }

  @Override
  public CategoriesDAO get() {
    return provideInstance(module, contextProvider);
  }

  public static CategoriesDAO provideInstance(DaoModule module, Provider<Context> contextProvider) {
    return proxyProvideCategoriesDAO(module, contextProvider.get());
  }

  public static DaoModule_ProvideCategoriesDAOFactory create(
      DaoModule module, Provider<Context> contextProvider) {
    return new DaoModule_ProvideCategoriesDAOFactory(module, contextProvider);
  }

  public static CategoriesDAO proxyProvideCategoriesDAO(DaoModule instance, Context context) {
    return Preconditions.checkNotNull(
        instance.provideCategoriesDAO(context),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}
