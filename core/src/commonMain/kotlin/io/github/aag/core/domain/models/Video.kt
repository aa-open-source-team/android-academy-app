package io.github.aag.core.domain.models

class Video(
    val id: Long,
    val city: City,
    val level: CourseLevel,
    val year: CourseYear,
    val name: String?,
    val date: String?,
    val picture: String?
)
