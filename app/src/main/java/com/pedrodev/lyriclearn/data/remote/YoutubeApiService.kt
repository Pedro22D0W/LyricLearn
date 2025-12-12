package com.pedrodev.lyriclearn.data.remote

import com.pedrodev.lyriclearn.data.dto.SearchResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface YoutubeApiService {

    // searchlist endpoint
    @GET("youtube/v3/search")
    suspend fun searchVideos(
        @Query("part") part: String = "snippet",
        @Query("type") type: String = "video",
        @Query("maxResults") maxResults: Int = 10,
        @Query("q") query: String,
        @Query("pageToken") pageToken: String? = null,
    ): SearchResponseDto
}