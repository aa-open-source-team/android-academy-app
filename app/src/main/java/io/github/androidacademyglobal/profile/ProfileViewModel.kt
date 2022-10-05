package io.github.androidacademyglobal.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.github.androidacademyglobal.R
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn

class ProfileViewModel : ViewModel() {
    val state: StateFlow<ProfileScreenState> =
        // just stub for this moment
        flow {
            emit(
                ProfileScreenState(
                    userId = "userId",
                    photo = R.drawable.ic_launcher_background,
                    displayName = "Grinya",
                    email = "test@google.com",
                    telegram = "GMachine"
                )
            )
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = ProfileScreenState.Empty
        )
}
