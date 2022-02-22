package io.github.androidacademyglobal.ui.theme

import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color

private val AndroidAcademyDarkColorScheme = darkColorScheme(
    primary = ColorConstants.Blue80,
    onPrimary = ColorConstants.Blue20,
    primaryContainer = ColorConstants.Blue30,
    onPrimaryContainer = ColorConstants.Blue90,
    inversePrimary = ColorConstants.Blue40,
    secondary = ColorConstants.DarkBlue80,
    onSecondary = ColorConstants.DarkBlue20,
    secondaryContainer = ColorConstants.DarkBlue30,
    onSecondaryContainer = ColorConstants.DarkBlue90,
    tertiary = ColorConstants.Yellow80,
    onTertiary = ColorConstants.Yellow20,
    tertiaryContainer = ColorConstants.Yellow30,
    onTertiaryContainer = ColorConstants.Yellow90,
    error = ColorConstants.Red80,
    onError = ColorConstants.Red20,
    errorContainer = ColorConstants.Red30,
    onErrorContainer = ColorConstants.Red90,
    background = ColorConstants.Grey10,
    onBackground = ColorConstants.Grey90,
    surface = ColorConstants.Grey10,
    onSurface = ColorConstants.Grey80,
    inverseSurface = ColorConstants.Grey90,
    inverseOnSurface = ColorConstants.Grey20,
    surfaceVariant = ColorConstants.BlueGrey30,
    onSurfaceVariant = ColorConstants.BlueGrey80,
    outline = ColorConstants.BlueGrey60
)

private val AndroidAcademyLightColorScheme = lightColorScheme(
    primary = ColorConstants.Blue40,
    onPrimary = Color.White,
    primaryContainer = ColorConstants.Blue90,
    onPrimaryContainer = ColorConstants.Blue10,
    inversePrimary = ColorConstants.Blue80,
    secondary = ColorConstants.DarkBlue40,
    onSecondary = Color.White,
    secondaryContainer = ColorConstants.DarkBlue90,
    onSecondaryContainer = ColorConstants.DarkBlue10,
    tertiary = ColorConstants.Yellow40,
    onTertiary = Color.White,
    tertiaryContainer = ColorConstants.Yellow90,
    onTertiaryContainer = ColorConstants.Yellow10,
    error = ColorConstants.Red40,
    onError = Color.White,
    errorContainer = ColorConstants.Red90,
    onErrorContainer = ColorConstants.Red10,
    background = ColorConstants.Grey99,
    onBackground = ColorConstants.Grey10,
    surface = ColorConstants.Grey99,
    onSurface = ColorConstants.Grey10,
    inverseSurface = ColorConstants.Grey20,
    inverseOnSurface = ColorConstants.Grey95,
    surfaceVariant = ColorConstants.BlueGrey90,
    onSurfaceVariant = ColorConstants.BlueGrey30,
    outline = ColorConstants.BlueGrey50
)

@Composable
fun AndroidAcademyAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) {
        AndroidAcademyDarkColorScheme
    } else {
        AndroidAcademyLightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = AndroidAcademyTypography
    ) {
        val rippleIndication = rememberRipple()
        CompositionLocalProvider(
            LocalIndication provides rippleIndication,
            content = content
        )
    }
}