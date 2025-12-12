package com.pedrodev.lyriclearn.data.dto

//DTO in format of the JSON response with nly the fields we need
data class SearchResponseDto(
    val items: List<SearchItemDto>
)

data class SearchItemDto(
    val id: VideoIdDto,
    val snippet: SnippetDto
)

data class VideoIdDto(
    val videoId: String
)

data class SnippetDto(
    val title: String,
    val channelTitle: String,
    val thumbnails: ThumbnailsDto
)

data class ThumbnailsDto(
    val medium: ThumbnailDto
)

data class ThumbnailDto(
    val url: String
)
