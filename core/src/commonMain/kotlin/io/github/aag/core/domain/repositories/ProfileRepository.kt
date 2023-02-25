package io.github.aag.core.domain.repositories

import io.github.aag.core.domain.models.UserProfile
import kotlinx.coroutines.flow.Flow

interface ProfileRepository {
    fun getUserProfile(): Flow<UserProfile>

    suspend fun saveUserProfile(profile: UserProfile): Boolean
}
