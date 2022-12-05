package io.github.aag.core.data.network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LoginRequestDTO(
    @SerialName("username")
    val username: String,
    @SerialName("pwd")
    val pwd: String,
)
