package com.sbs.armeasure.di.component

import com.sbs.armeasure.di.PerActivity
import com.sbs.armeasure.di.module.ActivityModule
import dagger.Component
import dagger.Subcomponent

@PerActivity
@Component(dependencies = arrayOf(AppComponent::class),
        modules = arrayOf(ActivityModule::class))
interface ActivityComponent {
}