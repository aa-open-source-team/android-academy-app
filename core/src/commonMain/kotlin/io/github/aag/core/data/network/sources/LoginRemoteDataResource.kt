package io.github.aag.core.data.network.sources

import io.github.aag.core.data.network.ktor.LoginResource
import io.github.aag.core.data.network.models.AuthTokenDTO
import io.github.aag.core.data.network.models.LoginRequestDTO
import io.github.aag.core.data.network.models.LoginResponseDTO
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.resources.get
import io.ktor.client.plugins.resources.post
import io.ktor.client.request.setBody

class LoginRemoteDataResource(
    private val httpClient: HttpClient
) {
    suspend fun login(loginRequestDTO: LoginRequestDTO): LoginResponseDTO =
        httpClient.post(LoginResource.Login) {
            setBody(loginRequestDTO)
        }.body()

    suspend fun getNewToken(refreshToken: String): AuthTokenDTO =
        httpClient.get(LoginResource.NewToken(refreshToken))
            .body()
}
