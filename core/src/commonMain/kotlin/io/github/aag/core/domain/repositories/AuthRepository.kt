package io.github.aag.core.domain.repositories

import io.github.aag.core.domain.OperationResult
import io.github.aag.core.domain.models.UserRole

interface AuthRepository {
    suspend fun <T> login(username: String, password: String): OperationResult<T>

    suspend fun <T> register(
        username: String,
        password: String,
        name: String,
        userRole: UserRole
    ): OperationResult<T>

    suspend fun enterGuestMode(): Boolean
}
