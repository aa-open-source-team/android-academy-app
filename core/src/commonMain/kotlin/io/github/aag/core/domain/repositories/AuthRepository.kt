package io.github.aag.core.domain.repositories

import io.github.aag.core.domain.OperationResult
import io.github.aag.core.domain.models.UserProfile
import io.github.aag.core.domain.models.UserRole

interface AuthRepository {
    suspend fun login(username: String, password: String): OperationResult<UserProfile>

    suspend fun register(
        username: String,
        password: String,
        name: String,
        userRole: UserRole
    ): OperationResult<UserProfile>

    suspend fun enterGuestMode(): Boolean
}
