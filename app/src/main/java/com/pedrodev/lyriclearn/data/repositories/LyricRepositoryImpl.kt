package com.pedrodev.lyriclearn.data.repositories

import com.pedrodev.lyriclearn.data.remote.LrclibApiService
import com.pedrodev.lyriclearn.domain.models.Lyric
import com.pedrodev.lyriclearn.domain.repository.LyricRepository
import javax.inject.Inject

import com.pedrodev.lyriclearn.data.util.lyricDtoMapper
class LyricRepositoryImpl @Inject constructor(
    private val lrclibApiService: LrclibApiService
) : LyricRepository {

    override suspend fun searchLyric(artist_name: String, track_name: String): Lyric {
        val lyricDto = lrclibApiService.searchLyric(artist_name,track_name)
        val lyric = lyricDtoMapper(lyricDto)
        return lyric
    }
}