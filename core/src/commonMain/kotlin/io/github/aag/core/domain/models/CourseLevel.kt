package io.github.aag.core.domain.models

enum class CourseLevel(override val stringName: String) : Stringified {
    FUNDAMENTALS("FUNDAMENTALS"),
    ADVANCED("ADVANCED"),
    UNKNOWN("UNKNOWN");
}
