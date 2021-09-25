package com.app.presentation.requester

import android.content.Context
import androidx.fragment.app.FragmentActivity
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope

class AppRequester(
    private val activity: FragmentActivity,
) {
    private val progressLoader by lazy { ProgressLoader(activity) }

    suspend fun <T> request(context: Context, repoCall: suspend () -> T): T? {

        if (!NetworkVisibility.isAvailable(context))
            return null  //TODO 'custom login'

        progressLoader.show()
        val job = coroutineScope {
            async {
                repoCall
            }
        }
        println("result starting...")
        val result = job.await()
        job.cancel()
        progressLoader.show()

        return result()
    }

    fun <T> requestCall(context: Context, task: (() -> T)): T? {

        if (!NetworkVisibility.isAvailable(context))
            return null  //TODO 'custom login'

        return task()
    }

}