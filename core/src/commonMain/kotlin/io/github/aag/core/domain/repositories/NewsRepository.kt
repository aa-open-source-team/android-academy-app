package io.github.aag.core.domain.repositories

import io.github.aag.core.domain.OperationResult

interface NewsRepository {
    suspend fun updateLiked(id: Long, isLiked: Boolean): Boolean

    suspend fun <T> getIsLikedState(id: Long): OperationResult<T>

    suspend fun <T> getLikesCountForId(chatId: Long): OperationResult<T>

    suspend fun <T> getNewsList(): OperationResult<T>
}
