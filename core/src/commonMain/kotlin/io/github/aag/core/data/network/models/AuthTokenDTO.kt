package io.github.aag.core.data.network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class AuthTokenDTO(
    @SerialName("auth_oken")
    val authToken: String
)
