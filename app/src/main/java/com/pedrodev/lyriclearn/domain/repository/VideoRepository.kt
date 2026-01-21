package com.pedrodev.lyriclearn.domain.repository

import com.pedrodev.lyriclearn.domain.models.Lyric
import com.pedrodev.lyriclearn.domain.models.Video
import kotlinx.coroutines.flow.Flow

interface VideoRepository {
    suspend fun searchVideos(query: String): List<Video>
    suspend fun searchVideoById(videoId: String): Video

    suspend fun saveVideo(video: Video,lyric: Lyric)

    fun findFavorites(): Flow<List<Video>>
}