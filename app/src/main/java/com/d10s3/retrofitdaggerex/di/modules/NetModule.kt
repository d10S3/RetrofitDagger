package com.d10s3.retrofitdaggerex.di.modules

import android.content.Context
import com.d10s3.retrofitdaggerex.apis.BaseApis
import com.d10s3.retrofitdaggerex.network.AddCookiesInterceptor
import com.d10s3.retrofitdaggerex.network.ReceivedCookiesInterceptor
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetModule {
    companion object {
        private const val DEFAULT_TIMEOUT = 10
    }

    @Provides
    @Singleton
    fun provideAddCookiesInterceptor(context: Context) : AddCookiesInterceptor {
        return AddCookiesInterceptor(context)
    }

    /**
     * HttpClient 인젝션을 위한 생성
     */
    @Provides
    @Singleton
    fun provideOkHttpClient(context: Context, addCookiesInterceptor: AddCookiesInterceptor) : OkHttpClient {
        val builder: OkHttpClient.Builder = OkHttpClient().newBuilder()
            .addInterceptor(addCookiesInterceptor)
            .addInterceptor(ReceivedCookiesInterceptor(context))
            .connectTimeout(DEFAULT_TIMEOUT.toLong(), TimeUnit.SECONDS)
            .writeTimeout(DEFAULT_TIMEOUT.toLong(), TimeUnit.SECONDS)
            .readTimeout(DEFAULT_TIMEOUT.toLong(), TimeUnit.SECONDS)

        // log
        var loggingInterceptor: HttpLoggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        builder.addInterceptor(loggingInterceptor)

        return builder.build()
    }

    @Provides
    @Singleton
    fun provideRetrofitApis(gson: Gson, okHttpClient: OkHttpClient) : BaseApis {
        return Retrofit.Builder()
            .baseUrl("http://")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpClient)
            .build()
            .create(BaseApis::class.java)
    }
}