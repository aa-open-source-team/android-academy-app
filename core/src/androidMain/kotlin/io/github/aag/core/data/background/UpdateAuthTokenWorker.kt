package io.github.aag.core.data.background

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import io.github.aag.core.domain.models.UserProfile
import io.github.aag.core.domain.repositories.AuthRepository
import io.github.aag.core.domain.repositories.ProfileRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class UpdateAuthTokenWorker(
    appContext: Context,
    workerParams: WorkerParameters,
    private val authRepository: AuthRepository,
    private val useProfileRepository: ProfileRepository
) : CoroutineWorker(appContext = appContext, params = workerParams) {
    private var userProfile: UserProfile? = null

    init {
        CoroutineScope(Dispatchers.IO + Job())
            .launch {
                useProfileRepository.getUserProfile()
                    .collect { profile ->
                        userProfile = profile
                        doWork()
                    }
            }
    }

    override suspend fun doWork(): Result =
        userProfile?.let { profile ->
            val isRenewTokenSuccess = authRepository.renewAuthToken(profile.refreshToken)
            if (isRenewTokenSuccess) {
                Result.success()
            } else {
                Result.failure()
            }
        } ?: Result.retry()
}
