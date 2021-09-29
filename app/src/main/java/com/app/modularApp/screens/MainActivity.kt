package com.app.modularApp.screens

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.app.data.tmp.FakeApi
import com.app.modularApp.R
import com.app.presentation.requester.AppRequester
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {

    private lateinit var tvContent: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvContent = findViewById(R.id.tvContent)

        mockingRequest()
    }

    private fun mockingRequest() {
        val requester = AppRequester(this@MainActivity)

        runBlocking {
            requester.request {
                val response = FakeApi.api.getData()
                tvContent.text = response.body().toString()
            }
        }
    }

}