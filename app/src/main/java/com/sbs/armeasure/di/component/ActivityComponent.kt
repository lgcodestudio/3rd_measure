package com.sbs.armeasure.di.component

import com.sbs.armeasure.di.module.ActivityModule
import dagger.Subcomponent

@Subcomponent(modules = arrayOf(ActivityModule::class))
interface ActivityComponent {
}