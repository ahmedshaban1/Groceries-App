package com.ahmed.groceriesapp.bases

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

open class BaseUseCase {
    suspend fun <T> makeLocalRequest(
        dispatcher: CoroutineDispatcher = Dispatchers.IO,
        call: suspend () -> T?
    ): ResultWrapper<T> {
        return withContext(dispatcher) {
            try {
                call.invoke()?.let {
                    ResultWrapper.Success(it)
                } ?: kotlin.run {
                    ResultWrapper.GenericError(ErrorCodes.NO_DATA)
                }
            } catch (e: Exception) {
                ResultWrapper.GenericError(ErrorCodes.INTERNAL_ERROR)
            }
        }

    }
}


sealed class ResultWrapper<out T> {
    data class Success<out T>(val value: T) : ResultWrapper<T>()
    data class GenericError(val errorCode: Int) : ResultWrapper<Nothing>()
}