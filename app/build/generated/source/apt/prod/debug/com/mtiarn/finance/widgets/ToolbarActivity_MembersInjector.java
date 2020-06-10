// Generated by Dagger (https://google.github.io/dagger).
package com.mtiarn.finance.widgets;

import android.content.SharedPreferences;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class ToolbarActivity_MembersInjector implements MembersInjector<ToolbarActivity> {
  private final Provider<SharedPreferences> mPreferencesProvider;

  public ToolbarActivity_MembersInjector(Provider<SharedPreferences> mPreferencesProvider) {
    this.mPreferencesProvider = mPreferencesProvider;
  }

  public static MembersInjector<ToolbarActivity> create(
      Provider<SharedPreferences> mPreferencesProvider) {
    return new ToolbarActivity_MembersInjector(mPreferencesProvider);
  }

  @Override
  public void injectMembers(ToolbarActivity instance) {
    injectMPreferences(instance, mPreferencesProvider.get());
  }

  public static void injectMPreferences(ToolbarActivity instance, SharedPreferences mPreferences) {
    instance.mPreferences = mPreferences;
  }
}