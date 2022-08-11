package io.github.aag.core.domain.models

data class Video(
    val id: Long,
    val name: String?,
    val date: String?,
    val picture: String?,
    val city: City,
    val level: CourseLevel,
    val year: CourseYear
)
