package io.github.androidacademyglobal.ui.profile

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Immutable
import io.github.aag.core.domain.OperationResult
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
internal fun OperationResult<UserProfile>.asScreenState() = when (this) {
    is OperationResult.Success -> data.let {
        ProfileScreenState(
            userId = it.username,
            photo = R.drawable.ic_launcher_background,
            displayName = it.firstName.orEmpty() + " " + it.lastName.orEmpty(),
            email = it.email.orEmpty(),
            telegram = it.telegramId.orEmpty()
        )
    }
    is OperationResult.Error -> ProfileScreenState()
    is OperationResult.Loading -> ProfileScreenState()
}
