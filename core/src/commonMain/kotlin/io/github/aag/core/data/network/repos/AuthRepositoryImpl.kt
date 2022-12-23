package io.github.aag.core.data.network.repos

import io.github.aag.core.data.network.models.LoginRequestDTO
import io.github.aag.core.data.network.models.RegisterRequestDTO
import io.github.aag.core.data.network.models.toUserProfile
import io.github.aag.core.data.network.sources.LoginRemoteDataResource
import io.github.aag.core.data.network.sources.RegisterRemoteDataSource
import io.github.aag.core.domain.OperationResult
import io.github.aag.core.domain.models.UserProfile
import io.github.aag.core.domain.models.UserRole
import io.github.aag.core.domain.repositories.AuthRepository

class AuthRepositoryImpl(
    private val loginRemoteDataResource: LoginRemoteDataResource,
    private val registerRemoteDataSource: RegisterRemoteDataSource
) : AuthRepository {
    override suspend fun login(username: String, password: String): OperationResult<UserProfile> =
        try {
            val loginResponse = loginRemoteDataResource.login(
                LoginRequestDTO(
                    username = username,
                    pwd = password
                )
            )
            // fixme: save token (via AccountManager?) and user profile (to DataStore?)
            OperationResult.Success(
                loginResponse.userProfile
                    .toUserProfile()
            )
        } catch (t: Throwable) {
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
            // fixme: save token (via AccountManager?) and user profile (to DataStore?)
            OperationResult.Success(
                loginResponse.userProfile
                    .toUserProfile()
            )
        } catch (t: Throwable) {
            OperationResult.Error(t)
        }

    override suspend fun enterGuestMode(): Boolean {
        TODO("Not yet implemented")
    }
}
