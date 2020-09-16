package com.d10s3.retrofitdaggerex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.d10s3.retrofitdaggerex.di.modules.NetConnector
import dagger.android.DaggerActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //var netConnector: NetConnector = NetConnector(this, )
    }

    private fun injectDependency() {
        //val activityComponent = DaggerActivity
    }
}
