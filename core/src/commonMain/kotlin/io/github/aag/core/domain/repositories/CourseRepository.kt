package io.github.aag.core.domain.repositories

import io.github.aag.core.domain.OperationResult
import io.github.aag.core.domain.models.Course
import io.github.aag.core.domain.models.Lesson

interface CourseRepository {
    suspend fun getAllCourses(): OperationResult<List<Course>, String?>

    suspend fun getFavouriteCourses(username: String): OperationResult<List<Course>, String?>

    suspend fun updateCourse(course: Course): OperationResult<Unit, String?>

    suspend fun getAllLectures(courseId: Long): OperationResult<List<Lesson>, String?>

    suspend fun updateLecture(lesson: Lesson): OperationResult<Unit, String?>
}
