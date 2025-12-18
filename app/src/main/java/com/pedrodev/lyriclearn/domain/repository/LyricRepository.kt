package com.pedrodev.lyriclearn.domain.repository

import com.pedrodev.lyriclearn.domain.models.Lyric

interface LyricRepository {

    suspend fun searchLyric(artist_name:String,track_name:String): Lyric


}