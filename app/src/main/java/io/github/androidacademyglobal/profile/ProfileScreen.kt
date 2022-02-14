package io.github.androidacademyglobal.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import io.github.androidacademyglobal.R
import io.github.androidacademyglobal.components.baselineHeight
import io.github.androidacademyglobal.ui.theme.MARGIN_LARGE
import io.github.androidacademyglobal.ui.theme.MARGIN_MEDIUM
import io.github.androidacademyglobal.ui.theme.MARGIN_SMALL
import io.github.androidacademyglobal.ui.theme.PROFILE_BOX_WEIGHT
import io.github.androidacademyglobal.ui.theme.PROFILE_OFFSET_DIVIDER
import io.github.androidacademyglobal.ui.theme.PROFILE_SCREEN_BOTTOM_MARGIN
import io.github.androidacademyglobal.ui.theme.ZERO

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(userData: ProfileScreenState) {

    val scrollState = rememberScrollState()
    val scrollBehavior = remember { TopAppBarDefaults.pinnedScrollBehavior() }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .nestedScroll(scrollBehavior.nestedScrollConnection)
    ) {
        BoxWithConstraints(modifier = Modifier.weight(PROFILE_BOX_WEIGHT)) {
            Surface {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(scrollState),
                ) {
                    ProfileHeader(
                        scrollState,
                        userData,
                        this@BoxWithConstraints.maxHeight
                    )
                    UserInfoFields(userData, this@BoxWithConstraints.maxHeight)
                }
            }
        }
    }
}

@Composable
private fun ProfileHeader(
    scrollState: ScrollState,
    data: ProfileScreenState,
    containerHeight: Dp
) {
    val offset = (scrollState.value / PROFILE_OFFSET_DIVIDER)
    val offsetDp = with(LocalDensity.current) { offset.toDp() }

    data.photo?.let {
        Image(
            modifier = Modifier
                .heightIn(max = containerHeight / PROFILE_OFFSET_DIVIDER)
                .fillMaxWidth()
                .padding(
                    start = MARGIN_MEDIUM.dp,
                    top = offsetDp,
                    end = MARGIN_MEDIUM.dp
                )
                .clip(CircleShape),
            painter = painterResource(id = it),
            contentScale = ContentScale.Crop,
            contentDescription = null
        )
    }
}

@Composable
private fun UserInfoFields(userData: ProfileScreenState, containerHeight: Dp) {
    Column {
        Spacer(modifier = Modifier.height(MARGIN_SMALL.dp))

        ProfileProperty(stringResource(R.string.display_name), userData.displayName)

        ProfileProperty(stringResource(R.string.email), userData.email)

        ProfileProperty(stringResource(R.string.telegram), userData.telegram, isLink = true)

        Spacer(Modifier.height((containerHeight - PROFILE_SCREEN_BOTTOM_MARGIN.dp).coerceAtLeast(ZERO.dp)))
    }
}

@Composable
fun ProfileProperty(label: String, value: String, isLink: Boolean = false) {
    Column(
        modifier = Modifier.padding(
            start = MARGIN_MEDIUM.dp,
            end = MARGIN_MEDIUM.dp,
            bottom = MARGIN_MEDIUM.dp
        )
    ) {
        Divider()
        Text(
            text = label,
            modifier = Modifier.baselineHeight(MARGIN_LARGE.dp),
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        val style = if (isLink) {
            MaterialTheme.typography.bodyLarge.copy(color = MaterialTheme.colorScheme.primary)
        } else {
            MaterialTheme.typography.bodyLarge
        }
        Text(
            text = value,
            modifier = Modifier.baselineHeight(MARGIN_LARGE.dp),
            style = style
        )
    }
}