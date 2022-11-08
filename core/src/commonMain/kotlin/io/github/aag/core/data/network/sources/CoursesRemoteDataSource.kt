package io.github.aag.core.data.network.sources

import io.github.aag.core.data.network.ktor.CoursesResource
import io.github.aag.core.data.network.models.CourseDTO
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.resources.get

class CoursesRemoteDataSource(
    private val httpClient: HttpClient
) {
    suspend fun getAllCourses(): List<CourseDTO> =
        httpClient.get(CoursesResource.All())
            .body()
}
