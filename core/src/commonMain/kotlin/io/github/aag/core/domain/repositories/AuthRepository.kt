package io.github.aag.core.domain.repositories

import io.github.aag.core.domain.OperationResult
import io.github.aag.core.domain.models.UserProfile
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    // todo - maybe move to ProfileRepository
    val userProfile: Flow<OperationResult<UserProfile, Throwable?>>

    suspend fun login(username: String, password: String): OperationResult<Unit, Throwable?>

    suspend fun register(
        username: String,
        password: String,
        name: String,
        isMentor: Boolean
    ): OperationResult<Unit, Throwable?>

    suspend fun enterGuestMode()
}
