package com.d10s3.retrofitdaggerex.views

import android.view.View
import com.d10s3.retrofitdaggerex.model.ResponseData
import com.d10s3.retrofitdaggerex.presenter.MainPresenter

interface MainView {
    fun getView() : View
    fun setPresenter(presenter: MainPresenter)
    fun setRequestTest(data: ResponseData)
}