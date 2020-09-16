package com.d10s3.retrofitdaggerex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.d10s3.retrofitdaggerex.di.modules.NetConnector
import com.d10s3.retrofitdaggerex.views.ShowView
import dagger.android.DaggerActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    private lateinit var showView: ShowView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showView = ShowView(this)

        mainLayout.addView(showView.getView())
    }
}
