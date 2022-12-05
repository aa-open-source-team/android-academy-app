package io.github.aag.core.data.network.sources

import io.github.aag.core.data.network.ktor.RegisterNewUserResource
import io.github.aag.core.data.network.models.LoginResponseDTO
import io.github.aag.core.data.network.models.RegisterRequestDTO
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.resources.post

class RegisterRemoteDataSource(
    private val httpClient: HttpClient
) {
    suspend fun register(registerRequestDTO: RegisterRequestDTO): LoginResponseDTO =
        httpClient.post(RegisterNewUserResource.Register(registerRequestDTO))
            .body()
}
