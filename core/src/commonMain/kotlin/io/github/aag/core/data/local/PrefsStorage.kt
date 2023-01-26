package io.github.aag.core.data.local

import io.github.aag.core.domain.models.UserProfile
import kotlinx.coroutines.flow.Flow

interface PrefsStorage {
    suspend fun saveProfile(userProfile: UserProfile)

    fun getProfile(): Flow<UserProfile>
}
