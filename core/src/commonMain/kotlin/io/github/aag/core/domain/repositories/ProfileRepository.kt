package io.github.aag.core.domain.repositories

import io.github.aag.core.domain.models.UserProfile

interface ProfileRepository {
    suspend fun saveProfileData(profile: UserProfile)
}
