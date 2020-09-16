package com.d10s3.retrofitdaggerex.model

import com.google.gson.annotations.SerializedName
import okhttp3.ResponseBody

class ResponseData {

    @SerializedName("responseCode")
    private lateinit var responseCode: String

    @SerializedName("responseMessage")
    private lateinit var responseMessage: String

    private lateinit var bodyString: String

    private lateinit var responseBody: ResponseBody

}