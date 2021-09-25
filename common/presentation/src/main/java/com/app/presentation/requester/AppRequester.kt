package com.app.presentation.requester

import android.content.Context
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope

class AppRequester {

    companion object {

        suspend fun <T> request(context: Context, repoCall: suspend () -> T): T? {

            if (!NetworkVisibility.isAvailable(context))
                return null  //TODO 'custom login'

            val job = coroutineScope {
                async {
                    repoCall
                }
            }
            println("result starting...")
            val result = job.await()
            job.cancel()

            return result()
        }

        fun <T> requestCall(context: Context, task: (() -> T)): T? {

            if (!NetworkVisibility.isAvailable(context))
                return null  //TODO 'custom login'

            return task()
        }
    }

}