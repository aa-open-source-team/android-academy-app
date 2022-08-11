package io.github.aag.core.domain.models

data class UserProfile(
    val username: String,
    val avatarUrl: String? = null,
    val firstName: String? = null,
    val lastName: String? = null,
    val phoneNumber: String? = null,
    val email: String? = null,
    val telegramId: String? = null,
    val userType: UserType
) {
    class Builder {
        private var username: String = ""
        private var avatarUrl: String? = null
        private var firstName: String? = null
        private var lastName: String? = null
        private var phoneNumber: String? = null
        private var email: String? = null
        private var telegramId: String? = null
        private var userType: UserType = UserType.UNKNOWN

        fun withUsername(value: String): Builder =
            this.apply {
                username = value
            }

        fun withFirstName(value: String): Builder =
            this.apply {
                firstName = value
            }

        fun withLastName(value: String): Builder =
            this.apply {
                lastName = value
            }

        fun withAvatarUrl(value: String): Builder =
            this.apply {
                avatarUrl = value
            }

        fun withPhoneNumber(value: String): Builder =
            this.apply {
                phoneNumber = value
            }

        fun withEmail(value: String): Builder =
            this.apply {
                email = value
            }

        fun withTelegramId(value: String): Builder =
            this.apply {
                telegramId = value
            }

        fun withUserTYpe(value: UserType): Builder =
            this.apply {
                userType = value
            }

        fun build(): UserProfile =
            UserProfile(
                username = username,
                avatarUrl = avatarUrl,
                firstName = firstName,
                lastName = lastName,
                phoneNumber = phoneNumber,
                email = email,
                telegramId = telegramId,
                userType = userType
            )
    }

    companion object {
        val GUEST = UserProfile(username = "", userType = UserType.GUEST)
    }
}
