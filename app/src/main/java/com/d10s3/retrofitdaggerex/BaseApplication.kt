package com.d10s3.retrofitdaggerex

import android.content.Context
import androidx.multidex.MultiDex
import com.d10s3.retrofitdaggerex.apis.BaseApis
import com.d10s3.retrofitdaggerex.di.AppComponent
import com.d10s3.retrofitdaggerex.di.DaggerAppComponent
import com.d10s3.retrofitdaggerex.di.modules.AppModule
import com.d10s3.retrofitdaggerex.di.modules.NetConnector
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import javax.inject.Inject

class BaseApplication: DaggerApplication() {

    private lateinit var baseApplication: BaseApplication
    private lateinit var appComponent: AppComponent

    @Inject
    lateinit var netConnector: NetConnector

    @Inject
    lateinit var baseApis: BaseApis

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        appComponent = DaggerAppComponent.builder().application(this).appModule(AppModule(applicationContext)).build()
        return appComponent
    }
}