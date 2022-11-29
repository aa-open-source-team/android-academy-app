package io.github.aag.core.domain


sealed class OperationResult<out T> {

    class Success<T>(val data: T) : OperationResult<T>()

    class Error(val throwable: Throwable) : OperationResult<Nothing>()

    object Loading : OperationResult<Nothing>()
}
