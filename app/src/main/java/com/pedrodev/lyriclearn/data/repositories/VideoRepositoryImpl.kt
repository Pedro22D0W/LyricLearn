package com.pedrodev.lyriclearn.data.repositories

import com.pedrodev.lyriclearn.data.remote.YoutubeApiService
import com.pedrodev.lyriclearn.data.util.videoDtoMapper
import com.pedrodev.lyriclearn.domain.models.Video
import com.pedrodev.lyriclearn.domain.repository.VideoRepository
import javax.inject.Inject

class VideoRepositoryImpl @Inject constructor(
    private val youtubeApiService: YoutubeApiService
): VideoRepository {
    private val cache = mutableMapOf<String, List<Video>>()

    override suspend fun searchVideos(query: String): List<Video> {
        cache[query]?.let { return it }
        val videos = videoDtoMapper(youtubeApiService.searchVideos(query = query))
        cache[query] = videos
        return videos
    }

    override suspend fun searchVideoById(videoId: String): Video {
        val video_list = videoDtoMapper(youtubeApiService.searchVideoById(videoId = videoId))
        val video = video_list.get(0)
        return video
    }
}