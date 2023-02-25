package io.github.aag.core.data.background

import android.content.Context
import androidx.work.ListenableWorker
import androidx.work.WorkerFactory
import androidx.work.WorkerParameters
import io.github.aag.core.domain.repositories.AuthRepository
import io.github.aag.core.domain.repositories.ProfileRepository

class UpdateAuthTokenWorkerFactory(
    private val authRepository: AuthRepository,
    private val userProfileRepository: ProfileRepository
) : WorkerFactory() {
    override fun createWorker(
        appContext: Context,
        workerClassName: String,
        workerParameters: WorkerParameters
    ): ListenableWorker =
        UpdateAuthTokenWorker(
            appContext = appContext,
            workerParams = workerParameters,
            authRepository = authRepository,
            useProfileRepository = userProfileRepository
        )
}
