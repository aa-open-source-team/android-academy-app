package io.github.aag.core.data.background

import android.content.Context
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ProcessLifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import io.github.aag.core.domain.repositories.AuthRepository
import io.github.aag.core.domain.repositories.ProfileRepository
import kotlinx.coroutines.launch

class UpdateAuthTokenWorker(
    appContext: Context,
    workerParams: WorkerParameters,
    private val authRepository: AuthRepository,
    private val useProfileRepository: ProfileRepository
) : CoroutineWorker(appContext = appContext, params = workerParams) {
    private var refreshToken: String? = null

    init {
        val lifecycleOwner = ProcessLifecycleOwner.get()
        lifecycleOwner
            .lifecycleScope
            .launch {
                lifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                    useProfileRepository.getUserProfile()
                        .collect { profile ->
                            refreshToken = profile.refreshToken
                        }
                }
            }
    }

    override suspend fun doWork(): Result =
        refreshToken?.let { token ->
            val isRenewTokenSuccess = authRepository.renewAuthToken(token)
            if (isRenewTokenSuccess) {
                Result.success()
            } else {
                Result.failure()
            }
        } ?: Result.retry()
}
