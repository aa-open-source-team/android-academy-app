package io.github.androidacademyglobal.logging

import com.google.firebase.crashlytics.ktx.crashlytics
import com.google.firebase.ktx.Firebase
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
                Firebase.crashlytics.recordException(e)
            }
        }
    }
}
