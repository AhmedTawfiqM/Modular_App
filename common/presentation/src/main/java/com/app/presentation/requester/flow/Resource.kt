package com.app.presentation.requester.flow

sealed class Resource<out T : Any>
class Success<out T : Any>(val data: T) : Resource<T>()
class Error(val exception: Throwable) : Resource<Nothing>()
object Loading : Resource<Nothing>()