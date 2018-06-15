package com.sbs.armeasure.di.module

import com.sbs.armeasure.di.PerActivity
import com.sbs.armeasure.view.BaseActivity
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(val baseActivity: BaseActivity) {

    @Provides
    @PerActivity
    fun provideBaseActivity() : BaseActivity{
        return baseActivity
    }
}