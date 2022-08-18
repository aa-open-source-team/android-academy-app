package io.github.aag.core.domain.models

class Course(
    val id: Long,
    val title: String,
    val tags: List<String>,
    val language: CourseLanguage,
    val startTimestampSec: Long,
    val endTimestampSec: Long, // a.k.a. tech stack
    val hostCities: List<City>,
    val mode: CourseMode,
    val lessonIds: List<Int>,
    val isSubscribed: Boolean,
    val shortDescription: String?,
    val fullDescription: String?,
    val coverImgUrl: String?
)
