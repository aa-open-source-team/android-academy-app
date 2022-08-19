package io.github.aag.core.domain


sealed class OperationResult<out T> {

    data class Success<T>(val data: T) : OperationResult<T>()

    data class Error<T>(val throwable: T) : OperationResult<T>()

    class Loading : OperationResult<Nothing>()
}
