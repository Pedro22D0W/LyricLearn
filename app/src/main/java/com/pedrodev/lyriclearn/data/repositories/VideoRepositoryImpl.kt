package com.pedrodev.lyriclearn.data.repositories

import android.util.Log
import com.pedrodev.lyriclearn.data.local.database.dao.VideoDao
import com.pedrodev.lyriclearn.data.remote.YoutubeApiService
import com.pedrodev.lyriclearn.data.util.normalizationTitleTrack
import com.pedrodev.lyriclearn.data.util.videoDtoMapper
import com.pedrodev.lyriclearn.data.util.videoEntityToDomain
import com.pedrodev.lyriclearn.data.util.videoToEntity
import com.pedrodev.lyriclearn.domain.models.Lyric
import com.pedrodev.lyriclearn.domain.models.Video
import com.pedrodev.lyriclearn.domain.repository.VideoRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class VideoRepositoryImpl @Inject constructor(
    private val youtubeApiService: YoutubeApiService,
    private val videoDao: VideoDao
): VideoRepository {
    private val cacheSearch = mutableMapOf<String, List<Video>>()

    private val cacheVideos = mutableMapOf<String, Video>()

    override suspend fun searchVideos(query: String): List<Video> {
        cacheSearch[query]?.let { return it }
        val videos = videoDtoMapper(youtubeApiService.searchVideos(query = query))
        val validVideos = videos.filter { video ->
            normalizationTitleTrack(video) != null
        }
        cacheSearch[query] = validVideos
        validVideos.forEach { video ->
            cacheVideos[video.videoId] = video
        }
        return validVideos
    }

    override suspend fun searchVideoById(videoId: String): Video {
        delay(500)
        videoDao.findVideoById(videoId)?.let { entity ->
            val video = videoEntityToDomain(entity)
            return video
        }

        cacheVideos[videoId]?.let { return it }

        val videolist = videoDtoMapper(youtubeApiService.searchVideoById(videoId = videoId))
        val video = videolist[0]
        return video
    }

    override suspend fun saveVideo(video: Video, lyric: Lyric) {
        val entity = videoToEntity(video, lyric)
        videoDao.saveVideo(entity)
    }

    override fun findFavorites(): Flow<List<Video>> {
        return videoDao.findAllFavorites()
            .map { entities ->
                entities.map {videoEntityToDomain(it)}
            }
    }

}