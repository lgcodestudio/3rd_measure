package com.sbs.armeasure.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.google.ar.core.ArCoreApk
import com.google.ar.core.Session
import com.google.ar.core.exceptions.UnavailableUserDeclinedInstallationException
import com.sbs.armeasure.ARMesureApplication
import com.sbs.armeasure.di.component.ActivityComponent
import com.sbs.armeasure.di.component.DaggerActivityComponent
import com.sbs.armeasure.di.module.ActivityModule

abstract class BaseActivity : AppCompatActivity() {
    abstract fun getLayoutId() : Int
    abstract fun initView()
    abstract fun initData()

    lateinit var activityComponent : ActivityComponent
    lateinit var session : Session

    var mUserRequestedInstall = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        initActivityComponent()
        initView()
        initData()
    }

    override fun onResume() {
        super.onResume()
        try {
            if(session == null){
                when(ArCoreApk.getInstance().requestInstall(this, mUserRequestedInstall)){
                    ArCoreApk.InstallStatus.INSTALLED -> session = Session(this)
                    ArCoreApk.InstallStatus.INSTALL_REQUESTED -> {
                        mUserRequestedInstall = false
                        return
                    }
                }
            }
        } catch (e : UnavailableUserDeclinedInstallationException){
            e.printStackTrace()
            return
        }

    }

    private fun initActivityComponent(){
        activityComponent = DaggerActivityComponent.builder()
                .appComponent((application as ARMesureApplication).getARAppComponent())
                .activityModule(ActivityModule(this))
                .build()
    }


}