package io.github.aag.core.domain.models

data class UserProfile(
    val profPic: String? = null,
    val firstName: String? = null,
    val lastName: String? = null,
    val phoneNumber: String? = null,
    val email: String? = null,
    val title: UserTitle? = null
) {
    class Builder(
        private var profPic: String? = null,
        private var firstName: String? = null,
        private var lastName: String? = null,
        private var phoneNumber: String? = null,
        private var email: String? = null,
        private var title: UserTitle? = null
    ) {
        fun withFirstName(value: String): Builder =
            this.apply {
                firstName = value
            }

        fun withLastName(value: String): Builder =
            this.apply {
                lastName = value
            }

        fun withProfPic(value: String): Builder =
            this.apply {
                profPic = value
            }

        fun withPhoneNumber(value: String): Builder =
            this.apply {
                phoneNumber = value
            }

        fun withEmail(value: String): Builder =
            this.apply {
                email = value
            }

        fun withTitle(value: UserTitle): Builder =
            this.apply {
                title = value
            }

        fun build(): UserProfile =
            UserProfile(
                profPic = profPic,
                firstName = firstName,
                lastName = lastName,
                phoneNumber = phoneNumber,
                email = email,
                title = title
            )
    }

    companion object {
        val GUEST = UserProfile(title = UserTitle.GUEST)
        val UNKNOWN = UserProfile(title = UserTitle.UNKNOWN)
    }
}
