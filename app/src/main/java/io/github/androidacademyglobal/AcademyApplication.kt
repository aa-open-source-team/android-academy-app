package io.github.androidacademyglobal

import android.app.Application
import com.google.firebase.FirebaseApp
import com.google.firebase.crashlytics.FirebaseCrashlytics
import io.github.aag.core.di.initKoin
import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier
import io.github.androidacademyglobal.di.appModule
import io.github.androidacademyglobal.logging.CrashlyticsAntilog
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger

class AcademyApplication : Application() {
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
                    FirebaseCrashlytics.getInstance()
                        .setCrashlyticsCollectionEnabled(true)
                }
            Napier.base(CrashlyticsAntilog())
        } else {
            Napier.base(DebugAntilog())
        }
    }
}
