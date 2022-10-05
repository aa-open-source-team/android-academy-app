package io.github.androidacademyglobal.profile

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Immutable

@Immutable
data class ProfileScreenState(
    val userId: String = "",
    @DrawableRes val photo: Int? = null,
    val displayName: String = "",
    val email: String = "",
    val telegram: String = "",
) {
    companion object {
        val Empty = ProfileScreenState()
    }
}
