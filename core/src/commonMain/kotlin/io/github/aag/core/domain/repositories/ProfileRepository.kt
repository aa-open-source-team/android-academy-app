package io.github.aag.core.domain.repositories

import io.github.aag.core.domain.OperationResult
import io.github.aag.core.domain.models.UserProfile
import kotlinx.coroutines.flow.Flow

interface ProfileRepository {
    fun getUserProfile(): Flow<OperationResult<UserProfile>>

    suspend fun <T> saveProfileData(profile: UserProfile): OperationResult<T>
}
