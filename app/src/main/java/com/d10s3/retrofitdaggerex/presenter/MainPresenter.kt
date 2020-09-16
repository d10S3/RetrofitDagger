package com.d10s3.retrofitdaggerex.presenter

import com.d10s3.retrofitdaggerex.model.MainModel
import com.d10s3.retrofitdaggerex.model.ModelCallback
import com.d10s3.retrofitdaggerex.model.ResponseData
import com.d10s3.retrofitdaggerex.views.MainView

class MainPresenter {
    private var view: MainView
    private var model: MainModel

    constructor(view: MainView, model: MainModel) {
        this.view = view
        this.model = model
    }

    fun requestTest() {
        model.requestTest(callback = object : ModelCallback {
            override fun onResult(data: ResponseData) {
                view.setRequestTest(data)
            }
        })
    }
}