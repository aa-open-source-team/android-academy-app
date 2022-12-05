package io.github.aag.core.data.network.ktor

import io.github.aag.core.data.network.models.LoginRequestDTO
import io.ktor.resources.Resource
import kotlinx.serialization.Serializable

@Serializable
class LoginResource {
    @Serializable
    @Resource("login")
    class Login(val loginRequestDTO: LoginRequestDTO)

    @Serializable
    @Resource("login/new-token")
    class NewToken(val refreshToken: String)
}
