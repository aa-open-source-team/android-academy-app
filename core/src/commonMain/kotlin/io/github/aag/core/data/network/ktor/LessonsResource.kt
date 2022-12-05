package io.github.aag.core.data.network.ktor

import io.ktor.resources.Resource
import kotlinx.serialization.Serializable

@Serializable
class LessonsResource {
    @Serializable
    @Resource("lessons/all")
    class All

    @Serializable
    @Resource("lessons/update")
    class Update

    @Serializable
    @Resource("lessons/course-id")
    class CourseId(val courseId: Long)

    @Serializable
    @Resource("lessons/{lesson-id}")
    class LessonId(val lessonId: Long)
}
