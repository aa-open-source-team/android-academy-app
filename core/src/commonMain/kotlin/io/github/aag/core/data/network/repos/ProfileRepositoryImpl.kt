package io.github.aag.core.data.network.repos

import io.github.aag.core.data.local.PrefsStorage
import io.github.aag.core.domain.models.UserProfile
import io.github.aag.core.domain.repositories.ProfileRepository
import io.github.aakira.napier.Napier
import kotlinx.coroutines.flow.Flow

class ProfileRepositoryImpl(
    private val prefsStorage: PrefsStorage
) : ProfileRepository {
    override fun getUserProfile(): Flow<UserProfile> =
        prefsStorage.getProfile()

    override suspend fun saveUserProfile(profile: UserProfile): Boolean =
        try {
            // todo: also need to sync new profile to back-end
            prefsStorage.saveProfile(profile)
            true
        } catch (t: Throwable) {
            Napier.e(message = "Could not save user profile", throwable = t)
            false
        }
}
