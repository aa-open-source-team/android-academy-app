package io.github.aag.core.domain.models

import kotlinx.serialization.Serializable

@Serializable
class UserProfile(
    val username: String,
    val userRole: UserRole,
    val avatarUrl: String? = null,
    val firstName: String? = null,
    val lastName: String? = null,
    val phoneNumber: String? = null,
    val email: String? = null,
    val telegramId: String? = null,
    val refreshToken: String
) {
    companion object {
        val GUEST = UserProfile(username = "", userRole = UserRole.GUEST, refreshToken = "no_token")
    }
}
