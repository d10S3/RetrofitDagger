package com.d10s3.retrofitdaggerex.di.modules

import android.content.Context
import com.d10s3.retrofitdaggerex.BaseApplication
import com.d10s3.retrofitdaggerex.model.ResponseData
import com.d10s3.retrofitdaggerex.network.interfaces.NetworkCallbackListener
import com.google.gson.Gson
import dagger.Provides
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import okhttp3.ResponseBody
import retrofit2.Response
import javax.inject.Inject
import kotlin.contracts.contract

/**
 * api 통신 처리 클래스
 */
class NetConnector {
    companion object {
        private const val RETRY_MAX_COUNT = 10
        // network
        private const val OK = 10
        private const val ERROR = 10
    }
    private var context: Context
    private var gson: Gson
    private var disposable: CompositeDisposable? = null
    private var appModule: AppModule
    private var token: String = ""
    private var errCount: Int = 0

    @Inject
    constructor(context: Context, gson: Gson, appModule: AppModule) {
        this.context = context
        this.gson = gson
        this.appModule = appModule

        if (disposable == null || disposable?.isDisposed!!) {
            disposable = CompositeDisposable()
        }
    }

    /**
     *
     */
    public fun doRequest(responseClass: Class<ResponseData>
                         , observable: Single<Response<ResponseBody>>
                         , networkCallbackListener: NetworkCallbackListener
                         , isNeededErrorCallback: Boolean) {

        disposable?.add(observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
            .subscribe({response ->
                var resData: ResponseData

                if (response.body() == null || response.body().toString().isEmpty()) {
                    if (response.errorBody() != null && response.errorBody().toString().isNotEmpty() && response.errorBody()!!.contentType() != null) {
                        var contentType: String = response.errorBody()!!.contentType().toString()
                        errCount = 0

                        var strBody: String = response.errorBody()!!.string()
                        var responseData: ResponseData = ResponseData()

                        networkCallbackListener.onResult(OK, "", responseData)
                    }
                } else {
                    var strBody: String = response.body().toString()
                    resData = gson.fromJson(strBody, responseClass)

                    if (resData != null) {
                        //let { resData. }
                    }
                }
            }, { throwable -> onError(throwable, networkCallbackListener, isNeededErrorCallback)

            })
        )
    }

    /**
     * 에러 처리 블록
     */
    public fun onError(throwable: Throwable, networkCallbackListener: NetworkCallbackListener, isNeededErrorCallback: Boolean) {
        if (isNeededErrorCallback)
            networkCallbackListener.onResult(ERROR, "error", null)

        errCount++
        if (errCount > Companion.RETRY_MAX_COUNT) {
            //var baseApplication: BaseApplication = context
        }
    }
}