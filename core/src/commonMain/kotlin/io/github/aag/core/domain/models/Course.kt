package io.github.aag.core.domain.models

data class Course(
    val id: Long,
    val title: String,
    val shortDescription: String?,
    val fullDescription: String?,
    val coverImgUrl: String?,
    val tags: List<String>, // a.k.a. tech stack
    val language: CourseLanguage,
    val startTimestampSec: Long,
    val endTimestampSec: Long,
    val hostCities: List<City>,
    val mode: CourseMode,
    val lessonIds: List<Int>,
    val isSubscribed: Boolean
)
