package io.github.aag.core.data.network.models

import io.github.aag.core.domain.models.Lesson
import kotlinx.serialization.Serializable

@Serializable
data class LectureDTO(
    val id: Long,
    val title: String,
    val youtubeUrl: String = "",
    val githubRepoUrl: String = "",
    val telegramChannel: String = "",
    val additionalMaterials: List<AdditionalMaterialDTO>,
    val imgUrl: String? = null,
    val tags: List<String>,
    val courseId: Long,
    val startTimestamp: Long
)

fun LectureDTO.toLecture(): Lesson =
    Lesson(
        id = id,
        title = title,
        youtubeUrl = youtubeUrl,
        githubRepoUrl = githubRepoUrl,
        telegramChannel = telegramChannel,
        additionalMaterials = additionalMaterials.map(AdditionalMaterialDTO::toAdditionalMaterial),
        imgUrl = imgUrl,
        tags = tags,
        courseId = courseId,
        startTimestamp = startTimestamp
    )
