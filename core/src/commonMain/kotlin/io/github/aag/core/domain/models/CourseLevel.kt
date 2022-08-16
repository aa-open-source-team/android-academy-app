package io.github.aag.core.domain.models

enum class CourseLevel(override val itemName: String) : FilterItem {
    FUNDAMENTALS("Fundamentals"),
    ADVANCED("Advanced"),
    UNKNOWN("UNKNOWN");
}
