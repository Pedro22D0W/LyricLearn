package com.pedrodev.lyriclearn.domain.repository

import com.pedrodev.lyriclearn.domain.models.Video

interface VideoRepository {
    suspend fun searchVideos(query: String): List<Video>
}