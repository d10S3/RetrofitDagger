package com.d10s3.retrofitdaggerex.model

import android.content.Context
import com.d10s3.retrofitdaggerex.apis.BaseApis
import com.d10s3.retrofitdaggerex.di.modules.NetConnector
import com.d10s3.retrofitdaggerex.network.interfaces.NetworkErrorHandlerCallbackListener
import javax.inject.Inject

class MainModel {
    private var context: Context
    private var netConnector: NetConnector
    private var baseApis: BaseApis

    @Inject
    constructor(context: Context, connector: NetConnector, apis: BaseApis) {
        this.context = context
        this.netConnector = connector
        this.baseApis = apis
    }

    fun requestTest(callback: ModelCallback) {
        netConnector.doRequest(ResponseData::class.java, baseApis.getInfo("p1", "p2"),
            networkCallbackListener = object : NetworkErrorHandlerCallbackListener {
                override fun onResult(code: Int, msg: String, data: ResponseData?) {
                    if (data != null) {
                        callback?.onResult(data)
                    }
                }
            } , isNeededErrorCallback = false)
    }
}