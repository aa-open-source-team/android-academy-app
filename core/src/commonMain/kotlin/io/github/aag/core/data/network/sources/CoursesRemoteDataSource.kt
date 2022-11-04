package io.github.aag.core.data.network.sources

import io.github.aag.core.data.network.ktor.CoursesResource
import io.github.aag.core.data.network.models.CourseDTO
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.resources.get
import io.ktor.client.utils.clientDispatcher
import io.ktor.util.InternalAPI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

private const val DEFAULT_THREAD_COUNT = 64

@OptIn(InternalAPI::class)
class CoursesRemoteDataSource(
    private val httpClient: HttpClient
) {
    suspend fun getAllCourses(): List<CourseDTO> =
        withContext(
            Dispatchers.clientDispatcher(
                DEFAULT_THREAD_COUNT,
                "IO"
            )
        ) { // todo: maybe there is a better solution?
            httpClient.get(CoursesResource.All())
                .body()
        }
}
