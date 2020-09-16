package com.d10s3.retrofitdaggerex.network

import android.content.Context
import okhttp3.Interceptor
import okhttp3.Response

class ReceivedCookiesInterceptor: Interceptor {
    private var context: Context

    constructor(context: Context) {
        this.context = context
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        return chain.proceed(chain.request())
    }
}