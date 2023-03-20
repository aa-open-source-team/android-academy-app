package io.github.aag.core.data.network.repos

import io.github.aag.core.data.local.PrefsStorage
import io.github.aag.core.data.network.models.LoginRequestDTO
import io.github.aag.core.data.network.models.RegisterRequestDTO
import io.github.aag.core.data.network.models.toUserProfile
import io.github.aag.core.data.network.sources.LoginRemoteDataResource
import io.github.aag.core.data.network.sources.RegisterRemoteDataSource
import io.github.aag.core.domain.OperationResult
import io.github.aag.core.domain.models.UserProfile
import io.github.aag.core.domain.models.UserRole
import io.github.aag.core.domain.repositories.AuthRepository
import io.github.aag.core.domain.repositories.ProfileRepository
import io.github.aakira.napier.Napier

class AuthRepositoryImpl(
    private val loginRemoteDataResource: LoginRemoteDataResource,
    private val registerRemoteDataSource: RegisterRemoteDataSource,
    private val profileRepository: ProfileRepository,
    private val prefsStorage: PrefsStorage
) : AuthRepository {
    override suspend fun login(username: String, password: String): OperationResult<UserProfile> =
        try {
            val loginResponse = loginRemoteDataResource.login(
                LoginRequestDTO(
                    username = username,
                    pwd = password
                )
            )
            OperationResult.Success(
                loginResponse.userProfile
                    .toUserProfile()
                    .also { userProfile ->
                        profileRepository.saveUserProfile(userProfile)
                    }
            )
        } catch (t: Throwable) {
            Napier.e(message = "Failed to log in", throwable = t)
            OperationResult.Error(t)
        }

    override suspend fun register(
        username: String,
        password: String,
        name: String,
        userRole: UserRole
    ): OperationResult<UserProfile> =
        try {
            val loginResponse = registerRemoteDataSource.register(
                RegisterRequestDTO(
                    username = username,
                    pwd = password,
                    userRole = userRole,
                    name = name
                )
            )
            OperationResult.Success(
                loginResponse.userProfile
                    .toUserProfile()
                    .also { userProfile ->
                        profileRepository.saveUserProfile(userProfile)
                    }
            )
        } catch (t: Throwable) {
            Napier.e(message = "Failed to register", throwable = t)
            OperationResult.Error(t)
        }

    override suspend fun enterGuestMode(): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun renewAuthToken(refreshToken: String): Boolean =
        try {
            loginRemoteDataResource.getNewToken(refreshToken)
                .authToken
                .also { authToken ->
                    prefsStorage.saveAuthToken(authToken)
                }
            true
        } catch (t: Throwable) {
            Napier.e(message = "Could not renew auth token", throwable = t)
            false
        }
}
