package io.github.androidacademyglobal

import android.app.Application
import io.github.aag.core.di.initKoin
import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier
import io.github.androidacademyglobal.di.appModule
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
        Napier.base(DebugAntilog())
    }
}
