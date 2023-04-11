package io.github.aag.core.data.network.models

import io.github.aag.core.domain.models.UserRole
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RegisterRequestDTO(
    @SerialName("username")
    val username: String,
    @SerialName("pwd")
    val pwd: String,
    @SerialName("name")
    val name: String,
    @SerialName("user_role")
    val userRole: UserRole
)
