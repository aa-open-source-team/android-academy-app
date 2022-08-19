package io.github.aag.core.domain.repositories

import io.github.aag.core.domain.OperationResult
import io.github.aag.core.domain.models.UserProfile

interface ProfileRepository {
    fun <T> getUserProfile(): OperationResult<T>

    suspend fun <T> saveProfileData(profile: UserProfile): OperationResult<T>
}
