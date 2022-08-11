package io.github.aag.core.domain.repositories

import io.github.aag.core.domain.models.City
import io.github.aag.core.domain.models.CourseLevel
import io.github.aag.core.domain.models.CourseYear
import io.github.aag.core.domain.models.FilterParameters
import io.github.aag.core.domain.models.Video
import kotlinx.coroutines.flow.StateFlow

interface VideosRepository {
    val videosList: StateFlow<List<Video>>

    suspend fun getFilterParameters(): FilterParameters

    suspend fun getVideos(city: City?, level: CourseLevel?, year: CourseYear?): List<Video>
}
