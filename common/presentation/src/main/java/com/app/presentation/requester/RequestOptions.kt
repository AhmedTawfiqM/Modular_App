package com.app.presentation.requester

data class RequestOptions(
    val requestType: RequestType,
    val cancellable: Boolean
) {

    companion object{
        fun default(): RequestOptions {
            return RequestOptions(
                requestType = RequestType.Deferred,
                cancellable = true
            )
        }
    }

}