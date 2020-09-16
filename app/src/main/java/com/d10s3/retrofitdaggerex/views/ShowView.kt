package com.d10s3.retrofitdaggerex.views

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import com.d10s3.retrofitdaggerex.MainActivity
import com.d10s3.retrofitdaggerex.R
import com.d10s3.retrofitdaggerex.model.ResponseData
import com.d10s3.retrofitdaggerex.presenter.MainPresenter

class ShowView: MainView {
    private var mainActivity: MainActivity
    private var layoutInflater: LayoutInflater
    private var view: View
    private lateinit var presenter: MainPresenter

    constructor(mainActivity: MainActivity) {
        this.mainActivity = mainActivity
        layoutInflater = mainActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        view = layoutInflater.inflate(R.layout.test_view, null, false)

    }

    override fun getView(): View {
        return view
    }

    override fun setPresenter(presenter: MainPresenter) {
        this.presenter = presenter
    }

    override fun setRequestTest(data: ResponseData) {

    }

}