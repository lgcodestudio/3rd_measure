package com.sbs.armeasure

import android.app.Application
import com.sbs.armeasure.di.component.AppComponent
import com.sbs.armeasure.di.component.DaggerAppComponent
import com.sbs.armeasure.di.module.AppModule

class ARMesureApplication : Application(){
    lateinit var appComponent : AppComponent

    override fun onCreate() {
        super.onCreate()
        initComponent()
    }

    fun initComponent(){
        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
    }

    fun getARAppComponent() : AppComponent{
        return appComponent
    }

}
