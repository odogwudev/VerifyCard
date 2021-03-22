package com.odogwudev.verifycard.app.retrofit

import com.odogwudev.verifycard.core.domain.carddomain.CardDataRespone
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import retrofit2.Response

suspend fun <T> safeApiCall(
    dispatcher: CoroutineDispatcher,
    apiCall: suspend () -> Response<T>
): ResponseHelper<T> {
    return withContext(dispatcher) {
        try {
            val response = apiCall.invoke()
            if (response.isSuccessful) {
                ResponseHelper.Success(response.body()!!)
            } else {
                ResponseHelper.GenericError(response.code(), response.errorBody()?.toString())
            }
        } catch (e: Throwable) {
            println("input message ${e.message}")
            ResponseHelper.NetworkError(e.message)
        }
    }
}

sealed class ResponseHelper<out T> {
    data class Success<out T>(val value: T) : ResponseHelper<T>()
    data class GenericError(val code: Int? = null, val error: String? = null) :
        ResponseHelper<Nothing>()

    data class NetworkError(val message: String? = "Error during operation please check your network") :
        ResponseHelper<Nothing>()
}