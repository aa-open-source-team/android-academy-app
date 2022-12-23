package io.github.aag.core.data.network.ktor

import io.github.aag.core.data.network.models.RegisterRequestDTO
import io.ktor.resources.Resource
import kotlinx.serialization.Serializable

@Serializable
class RegisterNewUserResource {
    @Serializable
    @Resource("register")
    class Register(val registerRequestDTO: RegisterRequestDTO)
}
