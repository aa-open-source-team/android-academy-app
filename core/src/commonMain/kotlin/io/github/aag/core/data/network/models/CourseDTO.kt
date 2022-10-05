package io.github.aag.core.data.network.models

import io.github.aag.core.domain.models.City
import io.github.aag.core.domain.models.Course
import io.github.aag.core.domain.models.CourseLanguage
import io.github.aag.core.domain.models.CourseMode
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CourseDTO(
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
    @SerialName("tags")
    val tags: List<String>, // a.k.a. tech stack
    @SerialName("language")
    val language: CourseLanguage,
    @SerialName("start_timestamp_sec")
    val startTimestampSec: Long,
    @SerialName("end_timestamp_sec")
    val endTimestampSec: Long,
    @SerialName("host_cities")
    val hostCities: List<City>,
    @SerialName("mode")
    val mode: CourseMode,
    @SerialName("subscribed")
    val isSubscribed: Boolean = false
)

fun CourseDTO.toCourse(): Course =
    Course(
        id = id,
        title = title,
        tags = tags,
        language = language,
        startTimestampSec = startTimestampSec,
        endTimestampSec = endTimestampSec,
        hostCities = hostCities,
        mode = mode,
        isSubscribed = isSubscribed,
        shortDescription = shortDescription,
        fullDescription = fullDescription,
        coverImgUrl = coverImgUrl
    )
