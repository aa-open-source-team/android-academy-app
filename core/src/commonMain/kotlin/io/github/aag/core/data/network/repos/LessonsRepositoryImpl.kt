package io.github.aag.core.data.network.repos

import io.github.aag.core.data.network.models.LessonDTO
import io.github.aag.core.data.network.models.fromLesson
import io.github.aag.core.data.network.models.toLesson
import io.github.aag.core.data.network.sources.LessonsRemoteDataSource
import io.github.aag.core.domain.OperationResult
import io.github.aag.core.domain.models.Lesson
import io.github.aag.core.domain.repositories.LessonsRepository

class LessonsRepositoryImpl(
    private val lessonsRemoteDataSource: LessonsRemoteDataSource
) : LessonsRepository {
    override suspend fun getAllLessons(): OperationResult<List<Lesson>> =
        try {
            OperationResult.Success(
                lessonsRemoteDataSource.getAllLessons()
                    .map(LessonDTO::toLesson)
            )
        } catch (t: Throwable) {
            OperationResult.Error(t)
        }

    override suspend fun getLessons(courseId: Long): OperationResult<List<Lesson>> =
        try {
            OperationResult.Success(
                lessonsRemoteDataSource.getLessonsByCourseId(courseId)
                    .map(LessonDTO::toLesson)
            )
        } catch (t: Throwable) {
            OperationResult.Error(t)
        }

    override suspend fun getLesson(id: Long): OperationResult<Lesson> =
        try {
            OperationResult.Success(
                lessonsRemoteDataSource.getLessonById(id)
                    .toLesson()
            )
        } catch (t: Throwable) {
            OperationResult.Error(t)
        }

    override suspend fun updateLesson(lesson: Lesson): OperationResult<Lesson> =
        try {
            OperationResult.Success(
                lessonsRemoteDataSource.updateLesson(fromLesson(lesson))
                    .toLesson()
            )
        } catch (t: Throwable) {
            OperationResult.Error(t)
        }
}
