package com.d10s3.retrofitdaggerex.network

import android.content.Context
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class AddCookiesInterceptor: Interceptor {
    private var context: Context
    private lateinit var token: String

    constructor(context: Context) {
        this.context = context
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        var builder:Request.Builder = chain.request().newBuilder()

        return chain.proceed(builder.build())
    }
}