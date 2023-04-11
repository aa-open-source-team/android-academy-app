package io.github.androidacademyglobal.ui.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.github.aag.core.domain.models.UserProfile
import io.github.aag.core.domain.repositories.ProfileRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

private const val STOP_TIMEOUT = 5000L

class ProfileViewModel(
    profileRepository: ProfileRepository
) : ViewModel() {
    val state: StateFlow<ProfileScreenState> =
        profileRepository.getUserProfile()
            .map(UserProfile::asScreenState)
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(STOP_TIMEOUT),
                initialValue = ProfileScreenState.EMPTY
            )
}
