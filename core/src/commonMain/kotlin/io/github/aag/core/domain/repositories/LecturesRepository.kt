package io.github.aag.core.domain.repositories

import io.github.aag.core.domain.OperationResult
import io.github.aag.core.domain.models.Lesson

interface LecturesRepository {
    suspend fun getAllLectures(courseId: Long): OperationResult<List<Lesson>, String?>

    suspend fun getLecture(id: Long): Lesson

    suspend fun updateLecture(lesson: Lesson): OperationResult<Unit, String?>
}
