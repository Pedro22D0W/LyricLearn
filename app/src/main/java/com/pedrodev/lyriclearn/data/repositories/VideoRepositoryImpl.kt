package com.pedrodev.lyriclearn.data.repositories

import com.pedrodev.lyriclearn.data.remote.YoutubeApiService
import com.pedrodev.lyriclearn.data.util.videoDtoMapper
import com.pedrodev.lyriclearn.domain.models.Video
import com.pedrodev.lyriclearn.domain.repository.VideoRepository

class VideoRepositoryImpl(
    private val youtubeApiService: YoutubeApiService
): VideoRepository {

    override suspend fun searchVideos(query: String): List<Video> {
        val videos = videoDtoMapper(youtubeApiService.searchVideos(query = query))
        return videos
    }
}