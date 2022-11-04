package io.github.aag.core.data.network.ktor

import io.ktor.resources.Resource
import kotlinx.serialization.Serializable

@Serializable
class CoursesResource {
    @Serializable
    @Resource("/courses/all")
    class All()
}
