package io.github.aag.core.data.network.repos

import io.github.aag.core.domain.OperationResult
import io.github.aag.core.domain.models.UserProfile
import io.github.aag.core.domain.models.UserRole
import io.github.aag.core.domain.repositories.ProfileRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ProfileRepositoryImpl : ProfileRepository {
    override fun getUserProfile(): Flow<OperationResult<UserProfile>> =
        flow {
            emit(
                OperationResult.Success(
                    UserProfile(
                        username = "userId",
                        userRole = UserRole.GUEST,
                        null,
                        email = "test@google.com",
                        firstName = "Grinya",
                        telegramId = "GMachine",
                        refreshToken = "the_token"
                    )
                )
            )
        }

    override suspend fun saveProfileData(profile: UserProfile): OperationResult<UserProfile> {
        TODO("Not yet implemented")
    }
}
