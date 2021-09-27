package com.app.presentation.requester.flow

sealed class NetworkResult<out T : Any>
class Success<out T : Any>(val data: T) : NetworkResult<T>()
class Error(val exception: Throwable) : NetworkResult<Nothing>()
object Loading : NetworkResult<Nothing>()