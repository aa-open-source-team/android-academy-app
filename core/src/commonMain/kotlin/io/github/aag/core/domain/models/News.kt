package io.github.aag.core.domain.models

data class News(
    val id: Long,
    val text: String?,
    val link: String?,
    val picture: String?,
    val timestampSec: Long,
    val chatId: Long,
    val likesCount: Int,
    val commentsCount: Int
)
