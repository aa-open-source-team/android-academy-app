package io.github.aag.core.data.network.models

import io.github.aag.core.domain.models.UserProfile
import io.github.aag.core.domain.models.UserRole
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserProfileDTO(
    @SerialName("username")
    val username: String,
    @SerialName("avatar_url")
    val avatarUrl: String? = null,
    @SerialName("first_name")
    val firstName: String? = null,
    @SerialName("last_name")
    val lastName: String? = null,
    @SerialName("phone_number")
    val phoneNumber: String? = null,
    @SerialName("email")
    val email: String? = null,
    @SerialName("telegram_id")
    val telegramId: String? = null,
    @SerialName("user_role")
    val userRole: UserRole,
    @SerialName("token")
    val refreshToken: String
)

fun UserProfileDTO.toUserProfile(): UserProfile =
    UserProfile(
        username = username,
        userRole = userRole,
        avatarUrl = avatarUrl,
        firstName = firstName,
        lastName = lastName,
        phoneNumber = phoneNumber,
        email = email,
        telegramId = telegramId
    )
