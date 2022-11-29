package io.github.aag.core.data.network.ktor

import io.ktor.resources.Resource
import kotlinx.serialization.Serializable

@Serializable
class CoursesResource {
    @Serializable
    @Resource("courses/all")
    class All

    @Serializable
    @Resource("courses/favorite")
    class Favorite

    @Serializable
    @Resource("courses/update")
    class Update
}
