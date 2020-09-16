package com.d10s3.retrofitdaggerex.di

import android.app.Application
import com.d10s3.retrofitdaggerex.BaseApplication
import com.d10s3.retrofitdaggerex.di.modules.AppModule
import com.d10s3.retrofitdaggerex.di.modules.NetModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Dependency Injection (의존성 주입)
 * DI를 위해 모듈 및 각 클래스 간에 의존성 관계를 맺음
 */

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        NetModule::class
    ]
)

interface AppComponent: AndroidInjector<BaseApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): AppComponent.Builder
        fun appModule(appModule: AppModule): AppComponent.Builder
        fun build(): AppComponent
    }
}