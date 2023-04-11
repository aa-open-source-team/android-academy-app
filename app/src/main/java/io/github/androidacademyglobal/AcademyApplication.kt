package io.github.androidacademyglobal

import android.app.Application
import android.util.Log
import androidx.work.BackoffPolicy
import androidx.work.Configuration
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.google.firebase.FirebaseApp
import com.google.firebase.crashlytics.ktx.crashlytics
import com.google.firebase.ktx.Firebase
import io.github.aag.core.data.background.UpdateAuthTokenWorker
import io.github.aag.core.data.background.UpdateAuthTokenWorkerFactory
import io.github.aag.core.di.initKoin
import io.github.aag.core.domain.repositories.AuthRepository
import io.github.aag.core.domain.repositories.ProfileRepository
import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier
import io.github.androidacademyglobal.di.appModule
import io.github.androidacademyglobal.logging.CrashlyticsAntilog
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import java.util.concurrent.TimeUnit

class AcademyApplication : Application(), Configuration.Provider {
    private val updateAuthTokenRequest =
        PeriodicWorkRequestBuilder<UpdateAuthTokenWorker>(2, TimeUnit.HOURS)
            .setBackoffCriteria(
                BackoffPolicy.LINEAR,
                10_000L,
                TimeUnit.MILLISECONDS
            ).build()

    override fun onCreate() {
        super.onCreate()

        initKoin {
            androidLogger()
            androidContext(this@AcademyApplication)
            modules(appModule)
        }
        if (!BuildConfig.DEBUG) {
            FirebaseApp.initializeApp(this)
                .also {
                    Firebase.crashlytics
                        .setCrashlyticsCollectionEnabled(true)
                }
            Napier.base(CrashlyticsAntilog())
        } else {
            Napier.base(DebugAntilog())
        }
        WorkManager.getInstance(this)
            .enqueueUniquePeriodicWork(
                UPDATE_TOKEN_TAG,
                ExistingPeriodicWorkPolicy.CANCEL_AND_REENQUEUE,
                updateAuthTokenRequest
            )
    }

    override fun getWorkManagerConfiguration(): Configuration {
        val authRepository: AuthRepository by inject()
        val profileRepository: ProfileRepository by inject()

        return Configuration.Builder()
            .setWorkerFactory(
                UpdateAuthTokenWorkerFactory(
                    authRepository = authRepository,
                    userProfileRepository = profileRepository
                )
            ).setMinimumLoggingLevel(
                if (BuildConfig.DEBUG) {
                    Log.DEBUG
                } else {
                    Log.ERROR
                }
            ).build()
    }

    companion object {
        private const val UPDATE_TOKEN_TAG = "update-token"
    }
}
