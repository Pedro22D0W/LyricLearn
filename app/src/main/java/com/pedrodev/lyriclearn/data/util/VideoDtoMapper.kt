package com.pedrodev.lyriclearn.data.util

import com.pedrodev.lyriclearn.data.dto.SearchResponseDto
import com.pedrodev.lyriclearn.domain.models.Video

fun videoDtoMapper(videosDto: SearchResponseDto): List<Video>{
    return videosDto.items.map { item ->
        Video(
            videoId = item.id.videoId,
            title = item.snippet.title,
            channelTitle = item.snippet.channelTitle,
            thumbnail = item.snippet.thumbnails.medium.url
        )
    }
}