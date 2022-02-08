package io.github.android_academy_global.profile

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Immutable

@Immutable
data class ProfileScreenState(
    val userId: String,
    @DrawableRes val photo: Int?,
    val displayName: String,
    val email: String,
    val telegram: String,
)