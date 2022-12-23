package io.github.aag.core.domain.repositories

import io.github.aag.core.domain.OperationResult
import io.github.aag.core.domain.models.Lesson

interface LessonsRepository {
    suspend fun getAllLessons(): OperationResult<List<Lesson>>

    suspend fun getLessons(courseId: Long): OperationResult<List<Lesson>>

    suspend fun getLesson(id: Long): OperationResult<Lesson>

    suspend fun updateLesson(lesson: Lesson): OperationResult<Lesson>
}
