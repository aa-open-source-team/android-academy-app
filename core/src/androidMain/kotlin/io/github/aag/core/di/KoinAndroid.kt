package io.github.aag.core.di

import android.content.Context
import io.github.aag.core.data.local.PrefsStorage
import io.github.aag.core.data.local.PrefsStorageImpl
import io.github.aag.core.data.local.createDataStore
import io.github.aag.core.data.local.provideLocalDataStorePath
import org.koin.core.module.Module
import org.koin.dsl.module

actual fun localStoreModule(): Module =
    module {
        single { createDataStore { provideLocalDataStorePath(get(clazz = Context::class)) } }
        single<PrefsStorage> { PrefsStorageImpl(get()) }
    }