package com.app.presentation.requester.flow

import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect

class FlowRequester {

    @InternalCoroutinesApi
    suspend fun <T : Any> request(call: Flow<Resource<String>>) {

        call.collect {
        }

    }
}