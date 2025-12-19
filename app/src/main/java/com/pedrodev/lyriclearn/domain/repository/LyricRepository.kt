package com.pedrodev.lyriclearn.domain.repository

import com.pedrodev.lyriclearn.domain.models.Lyric
import com.pedrodev.lyriclearn.domain.models.Video

interface LyricRepository {

    suspend fun searchLyric(video: Video): Result<Lyric>


}