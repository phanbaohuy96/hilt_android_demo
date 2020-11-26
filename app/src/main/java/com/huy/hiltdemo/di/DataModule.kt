package com.huy.hiltdemo.di

import android.content.Context
import com.huy.hiltdemo.data.PreferencesHelper
import com.huy.hiltdemo.ui.MainAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
class DataModule {

    @Singleton
    @Provides
    fun providePreferencesHelper(@ApplicationContext context: Context): PreferencesHelper {
        return PreferencesHelper(context)
    }

    @Provides
    fun provideMainAdapter(preferencesHelper: PreferencesHelper) : MainAdapter {
        return MainAdapter(preferencesHelper)
    }
}