package io.github.androidacademyglobal.logging

import com.google.firebase.crashlytics.FirebaseCrashlytics
import io.github.aakira.napier.Antilog
import io.github.aakira.napier.LogLevel

internal class CrashlyticsAntilog : Antilog() {
    override fun performLog(
        priority: LogLevel,
        tag: String?,
        throwable: Throwable?,
        message: String?
    ) {
        // send only error log
        if (priority >= LogLevel.ERROR) {
            throwable?.let { e ->
                FirebaseCrashlytics.getInstance().recordException(e)
            }
        }
    }
}
