package com.mtiarn.finance.di.modules;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import dagger.Module;
import dagger.Provides;

@Module(includes = {ContextModule.class})
public class PreferencesModule {
    @Provides
    public SharedPreferences provideDefaultSharedPreferences(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }
}
