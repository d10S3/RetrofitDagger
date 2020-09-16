package com.d10s3.retrofitdaggerex.apis

import io.reactivex.Single
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface BaseApis {
    @GET("test/test")
    fun getInfo(
        @Query("test1") data1: String,
        @Query("test2") data2: String
    ): Single<Response<ResponseBody>>

}