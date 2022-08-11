package io.github.aag.core.data.network.models

import io.github.aag.core.domain.models.AdditionalMaterial
import kotlinx.serialization.Serializable

@Serializable
data class AdditionalMaterialDTO(
    val topicName: String,
    val url: String
)

fun AdditionalMaterialDTO.toAdditionalMaterial(): AdditionalMaterial =
    AdditionalMaterial(topicName = topicName, url = url)
