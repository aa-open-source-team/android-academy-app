package io.github.aag.core.data.network.models

import io.github.aag.core.domain.models.Lesson
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LessonDTO(
    @SerialName("id")
    val id: Long,
    @SerialName("title")
    val title: String,
    @SerialName("short_description")
    val shortDescription: String? = null,
    @SerialName("full_description")
    val fullDescription: String? = null,
    @SerialName("img_url")
    val coverImgUrl: String? = null,
    @SerialName("youtube_url")
    val youtubeUrl: String? = null,
    @SerialName("github_repo_url")
    val githubRepoUrl: String? = null,
    @SerialName("telegram_channel")
    val telegramChannel: String? = null,
    @SerialName("addons")
    val additionalMaterials: List<AdditionalMaterialDTO>,
    @SerialName("tags")
    val tags: List<String>,
    @SerialName("start_timestamp_sec")
    val startTimestampSec: Long,
    @SerialName("end_timestamp_sec")
    val endTimestampSec: Long,
    @SerialName("favourite")
    val isFavourite: Boolean
)

fun LessonDTO.toLesson(): Lesson =
    Lesson(
        id = id,
        title = title,
        additionalMaterials = additionalMaterials.map(AdditionalMaterialDTO::toAdditionalMaterial),
        tags = tags,
        startTimestampSec = startTimestampSec,
        endTimestampSec = endTimestampSec,
        isFavourite = isFavourite,
        shortDescription = shortDescription,
        fullDescription = fullDescription,
        coverImgUrl = coverImgUrl,
        youtubeUrl = youtubeUrl,
        githubRepoUrl = githubRepoUrl,
        telegramChannel = telegramChannel
    )

fun fromLesson(lesson: Lesson): LessonDTO =
    with(lesson) {
        LessonDTO(
            id = id,
            title = title,
            additionalMaterials = additionalMaterials.map { material ->
                fromAdditionalMaterial(
                    material
                )
            },
            tags = tags,
            startTimestampSec = startTimestampSec,
            endTimestampSec = endTimestampSec,
            isFavourite = isFavourite,
            shortDescription = shortDescription,
            fullDescription = fullDescription,
            coverImgUrl = coverImgUrl,
            youtubeUrl = youtubeUrl,
            githubRepoUrl = githubRepoUrl,
            telegramChannel = telegramChannel
        )
    }
