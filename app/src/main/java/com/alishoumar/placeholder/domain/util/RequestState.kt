package com.alishoumar.placeholder.domain.util


sealed class RequestState<out T> {

    class Loading(): RequestState<Nothing>()
    data class Success<T>(val data:T): RequestState<T>()
    data class Error(val exception: Throwable): RequestState<Nothing>()

}