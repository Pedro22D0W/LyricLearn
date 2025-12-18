package com.pedrodev.lyriclearn.data.remote

import com.pedrodev.lyriclearn.data.dto.LyricSearchResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface LrclibApiService {

    @GET("/api/get")
    suspend fun searchLyric(
        @Query("artist_name") artist_name : String,
        @Query("track_name") track_name: String
    ) : LyricSearchResponseDto
}