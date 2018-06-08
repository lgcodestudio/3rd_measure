package com.sbs.armeasure.di.component

import android.content.Context
import com.sbs.armeasure.di.module.ActivityModule
import com.sbs.armeasure.di.module.AppModule
import com.sbs.armeasure.utils.PreferenceAndUtils
import dagger.Component

@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
    fun context() : Context
    fun preferenceAndUtils() : PreferenceAndUtils
    fun plus(activityModule : ActivityModule) : ActivityComponent
}