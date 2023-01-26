package io.github.aag.core.data.local

import android.content.Context
import okio.Path.Companion.toPath

fun provideLocalDataStorePath(context: Context) =
    context.filesDir
        .resolve("aag.preferences_pb")
        .absolutePath
        .toPath()
