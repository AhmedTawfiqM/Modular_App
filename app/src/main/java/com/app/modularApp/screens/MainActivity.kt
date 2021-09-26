package com.app.modularApp.screens

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.app.data.tmp.FakeApi
import com.app.modularApp.R
import com.app.presentation.requester.AppRequester
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mockingRequest()
    }

    private fun mockingRequest() {
        val requester = AppRequester(this@MainActivity)

        runBlocking {
            requester.request {
                FakeApi.api.getData()
            }
        }
//        GlobalScope.launch {
//            val requester = AppRequester(this@MainActivity)
//            requester.request {
//                FakeApi.api.getData()
//            }
//        }
    }
}