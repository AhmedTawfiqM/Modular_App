package com.app.modularApp.screens

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.app.data.MockCall
import com.app.data.netowrk.RetrofitHelper
import com.app.data.tmp.FakeApi
import com.app.modularApp.R
import com.app.presentation.requester.AppRequester
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mockingRequest()
    }

    private fun mockingRequest() {
        GlobalScope.launch {

            AppRequester(this@MainActivity).request {
                FakeApi.api.getData()
            }
        }
    }
}