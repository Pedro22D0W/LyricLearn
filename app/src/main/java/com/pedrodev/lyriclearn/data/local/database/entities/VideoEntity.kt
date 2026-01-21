package com.pedrodev.lyriclearn.data.local.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class VideoEntity(
    @PrimaryKey
    val videoId: String,
    val title: String,
    val channelTitle: String,
    val thumbnail: String,
    val favorited: Boolean = true,
    val lyric: List<String>
)
