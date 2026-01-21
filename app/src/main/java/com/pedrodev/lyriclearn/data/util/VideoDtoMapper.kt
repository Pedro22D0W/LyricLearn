package com.pedrodev.lyriclearn.data.util

import android.text.Html
import com.pedrodev.lyriclearn.data.dto.SearchResponseDto
import com.pedrodev.lyriclearn.domain.models.Video

fun videoDtoMapper(videosDto: SearchResponseDto): List<Video>{
    return videosDto.items.map { item ->
        Video(
            videoId = item.id.videoId,
            title = item.snippet.title.decodeHtml(),
            channelTitle = item.snippet.channelTitle.decodeHtml(),
            thumbnail = item.snippet.thumbnails.medium.url
        )
    }
}

fun String.decodeHtml(): String {
    return Html.fromHtml(this, Html.FROM_HTML_MODE_LEGACY).toString()
}