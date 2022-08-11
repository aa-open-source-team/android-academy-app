package io.github.aag.core.domain.repositories

import io.github.aag.core.domain.OperationResult
import io.github.aag.core.domain.models.Course

interface CourseRepository {
    suspend fun getAllCourses(): OperationResult<List<Course>, String?>

    suspend fun getFavouriteCourses(username: String): OperationResult<List<Course>, String?>

    suspend fun updateCourse(course: Course): OperationResult<Unit, String?>
}
