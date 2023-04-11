package io.github.aag.core.domain.models

class News(
    val id: Long,
    val timestampSec: Long,
    val chatId: Long,
    val likesCount: Int,
    val commentsCount: Int,
    val text: String?,
    val link: String?,
    val picture: String?
)
