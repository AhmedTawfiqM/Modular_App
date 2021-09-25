package com.app.presentation.requester

import androidx.fragment.app.FragmentActivity
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

class AppRequester(activity: FragmentActivity) {

    private val progressLoading = ProgressLoader(activity)

    private val requester by lazy {

        val presenter = object : Presenter {
            override fun showLoading() {
                progressLoading.show()
            }

            override fun hideLoading() {
                progressLoading.hide()
            }

            override fun showError() {

            }

        }

        CoroutinesRequester(presenter)
    }

    suspend fun <T>request(
        context: CoroutineContext = Dispatchers.IO,
        call: suspend () -> T
    )  :T{
        return requester.request(context, call)
    }

}