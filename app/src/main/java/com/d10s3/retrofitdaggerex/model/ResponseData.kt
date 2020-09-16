package com.d10s3.retrofitdaggerex.model

import com.google.gson.annotations.SerializedName
import okhttp3.ResponseBody

class ResponseData {

    @SerializedName("responseCode")
    private val responseCode: String = ""
        get() {
            return field
        }

    @SerializedName("responseMessage")
    private val responseMessage: String = ""
        get() {
            return field
        }

    private lateinit var bodyString: String

    private lateinit var responseBody: ResponseBody

}