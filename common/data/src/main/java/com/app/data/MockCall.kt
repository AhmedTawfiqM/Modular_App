package com.app.data

import retrofit2.http.GET

interface MockCall {

    @GET("78c1974f-9c6f-4d52-8193-d484aa099753")
    fun getData()
}