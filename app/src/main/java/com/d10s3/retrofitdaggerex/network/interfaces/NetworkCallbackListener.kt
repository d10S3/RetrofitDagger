package com.d10s3.retrofitdaggerex.network.interfaces

import com.d10s3.retrofitdaggerex.model.ResponseData

/**
 * NetConnector 공통적인 에러 핸들링을 처리함
 */
interface NetworkCallbackListener {
    fun onResult(code: Int, msg: String, data: ResponseData?)
}