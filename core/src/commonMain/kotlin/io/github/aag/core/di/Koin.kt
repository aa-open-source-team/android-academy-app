package io.github.aag.core.di

import io.github.aag.core.data.network.repos.CourseRepositoryImpl
import io.github.aag.core.data.network.repos.LessonsRepositoryImpl
import io.github.aag.core.data.network.repos.ProfileRepositoryImpl
import io.github.aag.core.data.network.sources.CoursesRemoteDataSource
import io.github.aag.core.domain.repositories.CourseRepository
import io.github.aag.core.domain.repositories.LessonsRepository
import io.github.aag.core.domain.repositories.ProfileRepository
import io.github.aakira.napier.Napier
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.resources.Resources
import io.ktor.http.ContentType
import io.ktor.http.URLProtocol
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.context.startKoin
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.bind
import org.koin.dsl.module

fun initKoin(appDeclaration: KoinAppDeclaration = {}) =
    startKoin {
        appDeclaration()
        modules(
            commonModule(),
            networkModule()
        )
    }

fun commonModule() = module {
    singleOf(::ProfileRepositoryImpl) bind ProfileRepository::class
}

internal fun networkModule() = module {
    singleOf<HttpClient> {
        HttpClient {
            install(Logging) {
                logger = object : Logger {
                    override fun log(message: String) {
                        Napier.v("HTTP Client", null, message)
                    }
                }
            }
            install(Resources)
            install(ContentNegotiation) {
                json(Json { isLenient = true; ignoreUnknownKeys = true })
            }
            defaultRequest {
                contentType(ContentType.Application.Json)
                host = "10.0.2.2" // fixme: introduce a const
                port = 8080 // fixme: remove when backend is deployed
                url { protocol = URLProtocol.HTTP }
//                headers {
//                    append(HttpHeaders.Authorization, "")
//                }
            }
        }
    }
    single { CoursesRemoteDataSource(get()) }
    single<CourseRepository> { CourseRepositoryImpl(get()) }
    single<LessonsRepository> { LessonsRepositoryImpl(get()) }
}
