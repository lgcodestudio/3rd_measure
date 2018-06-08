package com.sbs.armeasure.di.module

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(val appContext : Context) {

    @Provides
    @Singleton
    fun provideAppContext() : Context{
        return appContext
    }


}