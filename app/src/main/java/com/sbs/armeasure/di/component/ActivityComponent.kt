package com.sbs.armeasure.di.component

import com.sbs.armeasure.di.PerActivity
import com.sbs.armeasure.di.module.ActivityModule
import dagger.Subcomponent

@PerActivity
@Subcomponent(modules = arrayOf(ActivityModule::class))
interface ActivityComponent {
}