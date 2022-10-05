package io.github.androidacademyglobal.profile

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import io.github.androidacademyglobal.R
import io.github.androidacademyglobal.ui.theme.AndroidAcademyAppTheme

private val testProfileScreenState: ProfileScreenState = ProfileScreenState(
    userId = "userId",
    photo = R.drawable.ic_launcher_background,
    displayName = "Grinya",
    email = "test@google.com",
    telegram = "GMachine"
)

@Preview(widthDp = 340, name = "340 width - Me")
@Composable
fun ProfilePreview340() =
    AndroidAcademyAppTheme {
        ProfileView(testProfileScreenState) { Dp.Infinity }
    }

@Preview(widthDp = 480, name = "480 width - Me")
@Composable
fun ProfilePreview480Me() =
    AndroidAcademyAppTheme {
        ProfileView(testProfileScreenState) { Dp.Infinity }
    }

@Preview(widthDp = 480, name = "480 width - Other")
@Composable
fun ProfilePreview480Other() =
    AndroidAcademyAppTheme {
        ProfileView(testProfileScreenState) { Dp.Infinity }
    }

@Preview(widthDp = 340, name = "340 width - Me - Dark")
@Composable
fun ProfilePreview340MeDark() =
    AndroidAcademyAppTheme(darkTheme = true) {
        ProfileView(testProfileScreenState) { Dp.Infinity }
    }

@Preview(widthDp = 480, name = "480 width - Me - Dark")
@Composable
fun ProfilePreview480MeDark() =
    AndroidAcademyAppTheme(darkTheme = true) {
        ProfileView(testProfileScreenState) { Dp.Infinity }
    }

@Preview(widthDp = 480, name = "480 width - Other - Dark")
@Composable
fun ProfilePreview480OtherDark() =
    AndroidAcademyAppTheme(darkTheme = true) {
        ProfileView(testProfileScreenState) { Dp.Infinity }
    }
