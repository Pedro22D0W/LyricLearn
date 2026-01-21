package com.pedrodev.lyriclearn.data.util

import com.pedrodev.lyriclearn.data.local.database.entities.VideoEntity
import com.pedrodev.lyriclearn.domain.models.Lyric
import com.pedrodev.lyriclearn.domain.models.LyricWord
import com.pedrodev.lyriclearn.domain.models.Video
import kotlin.random.Random

fun videoEntityToDomain(videoEntity: VideoEntity): Video {
    return Video(
        videoId = videoEntity.videoId,
        title = videoEntity.title,
        channelTitle = videoEntity.channelTitle,
        thumbnail = videoEntity.thumbnail,
        favorited = videoEntity.favorited
    )
}

fun videoToEntity(video: Video,lyric: Lyric) : VideoEntity {
    return VideoEntity(
        videoId = video.videoId,
        title = video.title,
        channelTitle = video.channelTitle,
        thumbnail = video.thumbnail,
        favorited = true,
        lyric = lyric.lyricWords.map { it.text }
    )
}

fun entityToLyric(entity: VideoEntity): Lyric {
    return Lyric(
        lyricWords = entity.lyric.map { word ->
            LyricWord(
                text = word,
                hidden = Random.nextBoolean()
                )
        }
    )
}