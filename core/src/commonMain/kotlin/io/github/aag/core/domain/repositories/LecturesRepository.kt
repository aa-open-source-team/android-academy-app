package io.github.aag.core.domain.repositories

import io.github.aag.core.domain.models.Lesson

interface LecturesRepository {
    suspend fun getLecture(id: Long): Lesson
}
