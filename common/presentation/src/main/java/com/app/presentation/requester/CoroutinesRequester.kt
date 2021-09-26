package com.app.presentation.requester

import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlin.coroutines.CoroutineContext

class CoroutinesRequester(
    private val presenter: Presenter,
) {

    suspend fun <T> request(
        requestOptions: RequestOptions,
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