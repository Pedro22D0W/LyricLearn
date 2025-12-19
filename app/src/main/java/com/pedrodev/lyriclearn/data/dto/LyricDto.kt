package com.pedrodev.lyriclearn.data.dto

data class LyricSearchResponseDto(
    val plainLyrics: String
)

data class LyricRequestDto(
    val artist_name : String,
    val track_name : String
)