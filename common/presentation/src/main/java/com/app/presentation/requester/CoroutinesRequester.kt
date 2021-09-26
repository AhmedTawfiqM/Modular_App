package com.app.presentation.requester

import com.app.presentation.requester.flow.FlowRequester
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlin.coroutines.CoroutineContext

class CoroutinesRequester(
    private val presenter: Presenter,
) {

    suspend fun <T> request(
        requestType: RequestType,
        requestOptions: RequestOptions,
        context: CoroutineContext,
        call: suspend () -> T
    ): T {

        return when (requestType) {
            RequestType.Deferred -> requestWithDeferred(context, call)
            RequestType.Flow -> requestWithFlow(context, call)
        }
    }

    private fun <T> requestWithFlow(
        context: CoroutineContext,
        call: suspend () -> T
    ): T {
        val flowRequester = FlowRequester()

    }

    private suspend fun <T> requestWithDeferred(
        context: CoroutineContext,
        call: suspend () -> T
    ): T {

        presenter.showLoading()
        val job = coroutineScope {
            async(context) {
                call
            }
        }
        val result = job.await()
        job.cancel()

        presenter.hideLoading()
        return result()
    }

    private fun handleError() {
        presenter.hideLoading()
        presenter.showError()
    }
}