package io.github.androidacademyglobal.ui.profile

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Immutable
import io.github.aag.core.domain.models.UserProfile
import io.github.androidacademyglobal.R

@Immutable
data class ProfileScreenState(
    val userId: String = "",
    @DrawableRes val photo: Int? = null,
    val displayName: String = "",
    val email: String = "",
    val telegram: String = "",
) {
    companion object {
        val EMPTY = ProfileScreenState()
    }
}

// TODO: think about writing mappers. this is just a stub
internal fun UserProfile.asScreenState() =
    ProfileScreenState(
        userId = username,
        photo = R.drawable.ic_launcher_background,
        displayName = firstName.orEmpty() + " " + lastName.orEmpty(),
        email = email.orEmpty(),
        telegram = telegramId.orEmpty()
    )
