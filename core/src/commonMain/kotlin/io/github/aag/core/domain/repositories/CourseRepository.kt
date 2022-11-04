package io.github.aag.core.domain.repositories

import io.github.aag.core.domain.OperationResult
import io.github.aag.core.domain.models.Course
import kotlinx.coroutines.flow.StateFlow

interface CourseRepository {
    val allCourses: StateFlow<OperationResult<List<Course>>>

    suspend fun loadAllCourses(): StateFlow<OperationResult<List<Course>>>

    suspend fun <T> getFavouriteCourses(username: String): OperationResult<List<Course>>

    suspend fun <T> updateCourse(course: Course): OperationResult<List<Course>>
}
