package com.app.presentation.requester

import android.content.Context
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlin.coroutines.CoroutineContext

class CoroutinesRequester(
    private val presenter: Presenter,
) {

    private lateinit var job: Deferred<suspend () -> Unit>

    suspend fun <T>request(
        context: CoroutineContext = Dispatchers.IO,
        call: suspend () -> T
    )  :T {

        presenter.showLoading()
        val job = coroutineScope {
            async(context) {
                call
            }
        }
        println("result starting...")
        val result = job.await()
        job.cancel()

        presenter.hideLoading()
        return result()
    }

    private fun handleError() {
        presenter.hideLoading()
        presenter.showError()
    }

    fun <T> requestCall(context: Context, task: (() -> T)): T? {

        if (!NetworkVisibility.isAvailable(context))
            return null  //TODO 'custom login'

        return task()
    }
}