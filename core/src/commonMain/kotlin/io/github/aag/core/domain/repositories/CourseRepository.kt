package io.github.aag.core.domain.repositories

import io.github.aag.core.domain.OperationResult
import io.github.aag.core.domain.models.Course

interface CourseRepository {
    suspend fun <T> getAllCourses(): OperationResult<T>

    suspend fun <T> getFavouriteCourses(username: String): OperationResult<T>

    suspend fun <T> updateCourse(course: Course): OperationResult<T>
}
