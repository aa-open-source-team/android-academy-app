package io.github.aag.core.data.network.sources

import io.github.aag.core.data.network.ktor.LessonsResource
import io.github.aag.core.data.network.models.LessonDTO
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.resources.get
import io.ktor.client.plugins.resources.post
import io.ktor.client.request.setBody

class LessonsRemoteDataSource(
    private val httpClient: HttpClient
) {
    suspend fun getAllLessons(): List<LessonDTO> =
        httpClient.get(LessonsResource.All())
            .body()

    suspend fun updateLesson(newLesson: LessonDTO): LessonDTO =
        httpClient.post(LessonsResource.Update()) {
            setBody(newLesson)
        }.body()

    suspend fun getLessonsByCourseId(courseId: Long): List<LessonDTO> =
        httpClient.get(LessonsResource.CourseId(courseId))
            .body()

    suspend fun getLessonById(id: Long): LessonDTO =
        httpClient.get(LessonsResource.LessonId(id))
            .body()
}
