package io.github.aag.core.di

import io.github.aag.core.domain.repositories.ProfileRepository
import io.github.aag.core.domain.repositories.ProfileRepositoryImpl
import org.koin.core.context.startKoin
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.bind
import org.koin.dsl.module

fun initKoin(appDeclaration: KoinAppDeclaration = {}) =
    startKoin {
        appDeclaration()
        modules(commonModule())
    }

fun commonModule() = module {
    singleOf(::ProfileRepositoryImpl) bind ProfileRepository::class
}
