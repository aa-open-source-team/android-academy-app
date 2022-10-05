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
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
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
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import io.github.androidacademyglobal.R
import io.github.androidacademyglobal.components.baselineHeight
import io.github.androidacademyglobal.ui.theme.AppConstants
import io.github.androidacademyglobal.ui.theme.DimensionConstants
import org.koin.androidx.compose.getViewModel

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLifecycleComposeApi::class)
@Composable
fun ProfileScreen(
    viewModel: ProfileViewModel = getViewModel()
) {
    val userData by viewModel.state.collectAsStateWithLifecycle()
    val topAppBarState = rememberTopAppBarState()
    val scrollBehavior = remember { TopAppBarDefaults.pinnedScrollBehavior(topAppBarState) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .nestedScroll(scrollBehavior.nestedScrollConnection)
    ) {
        BoxWithConstraints(modifier = Modifier.weight(AppConstants.PROFILE_BOX_WEIGHT)) {
            ProfileView(userData = userData) {
                maxHeight
            }
        }
    }
}

@Composable
internal fun ProfileView(
    userData: ProfileScreenState,
    containerHeightProvider: () -> Dp
) {
    val scrollState = rememberScrollState()
    Surface {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState),
        ) {
            ProfileHeader(
                scrollState,
                userData,
                containerHeightProvider
            )
            UserInfoFields(userData, containerHeightProvider)
        }
    }
}

@Composable
private fun ProfileHeader(
    scrollState: ScrollState,
    data: ProfileScreenState,
    containerHeightProvider: () -> Dp
) {
    val offset = (scrollState.value / AppConstants.PROFILE_OFFSET_DIVIDER)
    val offsetDp = with(LocalDensity.current) { offset.toDp() }

    data.photo?.let {
        Image(
            modifier = Modifier
                .heightIn(max = containerHeightProvider() / AppConstants.PROFILE_OFFSET_DIVIDER)
                .fillMaxWidth()
                .padding(
                    start = DimensionConstants.MARGIN_MEDIUM.dp,
                    top = offsetDp,
                    end = DimensionConstants.MARGIN_MEDIUM.dp
                )
                .clip(CircleShape),
            painter = painterResource(id = it),
            contentScale = ContentScale.Crop,
            contentDescription = null
        )
    }
}

@Composable
private fun UserInfoFields(
    userData: ProfileScreenState,
    containerHeightProvider: () -> Dp
) {
    Column {
        Spacer(modifier = Modifier.height(DimensionConstants.MARGIN_SMALL.dp))

        ProfileProperty(stringResource(R.string.display_name), userData.displayName)

        ProfileProperty(stringResource(R.string.email), userData.email)

        ProfileProperty(stringResource(R.string.telegram), userData.telegram, isLink = true)

        Spacer(
            Modifier.height(
                (containerHeightProvider() - DimensionConstants.PROFILE_SCREEN_BOTTOM_MARGIN.dp).coerceAtLeast(
                    DimensionConstants.ZERO.dp
                )
            )
        )
    }
}

@Composable
fun ProfileProperty(label: String, value: String, isLink: Boolean = false) {
    Column(
        modifier = Modifier.padding(
            start = DimensionConstants.MARGIN_MEDIUM.dp,
            end = DimensionConstants.MARGIN_MEDIUM.dp,
            bottom = DimensionConstants.MARGIN_MEDIUM.dp
        )
    ) {
        Divider()
        Text(
            text = label,
            modifier = Modifier.baselineHeight(DimensionConstants.MARGIN_LARGE.dp),
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
            modifier = Modifier.baselineHeight(DimensionConstants.MARGIN_LARGE.dp),
            style = style
        )
    }
}
