package io.github.aag.core.domain.repositories

import io.github.aag.core.domain.OperationResult
import io.github.aag.core.domain.models.City
import io.github.aag.core.domain.models.CourseLevel
import io.github.aag.core.domain.models.CourseYear

interface VideosRepository {
    suspend fun <T> getFilterParameters(): OperationResult<T>

    suspend fun <T> getVideoList(
        city: City?,
        level: CourseLevel?,
        year: CourseYear?
    ): OperationResult<T>
}
