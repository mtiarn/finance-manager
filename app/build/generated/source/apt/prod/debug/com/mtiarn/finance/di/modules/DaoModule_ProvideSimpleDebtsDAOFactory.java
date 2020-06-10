// Generated by Dagger (https://google.github.io/dagger).
package com.mtiarn.finance.di.modules;

import android.content.Context;
import com.mtiarn.finance.dao.SimpleDebtsDAO;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class DaoModule_ProvideSimpleDebtsDAOFactory implements Factory<SimpleDebtsDAO> {
  private final DaoModule module;

  private final Provider<Context> contextProvider;

  public DaoModule_ProvideSimpleDebtsDAOFactory(
      DaoModule module, Provider<Context> contextProvider) {
    this.module = module;
    this.contextProvider = contextProvider;
  }

  @Override
  public SimpleDebtsDAO get() {
    return provideInstance(module, contextProvider);
  }

  public static SimpleDebtsDAO provideInstance(
      DaoModule module, Provider<Context> contextProvider) {
    return proxyProvideSimpleDebtsDAO(module, contextProvider.get());
  }

  public static DaoModule_ProvideSimpleDebtsDAOFactory create(
      DaoModule module, Provider<Context> contextProvider) {
    return new DaoModule_ProvideSimpleDebtsDAOFactory(module, contextProvider);
  }

  public static SimpleDebtsDAO proxyProvideSimpleDebtsDAO(DaoModule instance, Context context) {
    return Preconditions.checkNotNull(
        instance.provideSimpleDebtsDAO(context),
        "Cannot return null from a non-@Nullable @Provides method");
  }
}