package io.github.aag.core.domain.repositories

import io.github.aag.core.domain.OperationResult
import io.github.aag.core.domain.models.Lesson

interface LessonsRepository {
    suspend fun <T> getAllLessons(courseId: Long): OperationResult<T>

    suspend fun <T> getLesson(id: Long): OperationResult<T>

    suspend fun <T> updateLesson(lesson: Lesson): OperationResult<T>
}
