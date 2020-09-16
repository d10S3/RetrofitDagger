package com.d10s3.retrofitdaggerex.di.modules

import android.app.Activity
import android.content.Context
import androidx.core.app.ActivityCompat
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.system.exitProcess

@Module
class AppModule {
    private var context: Context

    @Inject
    constructor(context: Context) {
        this.context = context
    }

    @Singleton @Provides
    fun provideContext(): Context {
        return this.context
    }

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return GsonBuilder().create()
    }

    public fun finishApplication(activity: Activity) {
        ActivityCompat.finishAffinity(activity)
        exitProcess(0)
    }
}