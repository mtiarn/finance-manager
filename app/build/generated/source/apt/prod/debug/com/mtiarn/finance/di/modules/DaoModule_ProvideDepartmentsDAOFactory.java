// Generated by Dagger (https://google.github.io/dagger).
package com.mtiarn.finance.di.modules;

import android.content.Context;
import com.mtiarn.finance.dao.DepartmentsDAO;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class DaoModule_ProvideDepartmentsDAOFactory implements Factory<DepartmentsDAO> {
  private final DaoModule module;

  private final Provider<Context> contextProvider;

  public DaoModule_ProvideDepartmentsDAOFactory(
      DaoModule module, Provider<Context> contextProvider) {
    this.module = module;
    this.contextProvider = contextProvider;
  }

  @Override
  public DepartmentsDAO get() {
    return provideInstance(module, contextProvider);
  }

  public static DepartmentsDAO provideInstance(
      DaoModule module, Provider<Context> contextProvider) {
    return proxyProvideDepartmentsDAO(module, contextProvider.get());
  }

  public static DaoModule_ProvideDepartmentsDAOFactory create(
      DaoModule module, Provider<Context> contextProvider) {
    return new DaoModule_ProvideDepartmentsDAOFactory(module, contextProvider);
  }

  public static DepartmentsDAO proxyProvideDepartmentsDAO(DaoModule instance, Context context) {
    return Preconditions.checkNotNull(
        instance.provideDepartmentsDAO(context),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}