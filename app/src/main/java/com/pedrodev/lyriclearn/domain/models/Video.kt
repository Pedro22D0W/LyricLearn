package com.pedrodev.lyriclearn.domain.models

data class Video(
    val videoId: String,
    val title: String,
    val channelTitle: String,
    val thumbnail: String,
    val favorited: Boolean = false
)
