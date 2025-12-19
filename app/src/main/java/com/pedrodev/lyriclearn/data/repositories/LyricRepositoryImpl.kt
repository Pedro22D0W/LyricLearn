package com.pedrodev.lyriclearn.data.repositories

import com.pedrodev.lyriclearn.data.remote.LrclibApiService
import com.pedrodev.lyriclearn.domain.models.Lyric
import com.pedrodev.lyriclearn.domain.repository.LyricRepository
import javax.inject.Inject

import com.pedrodev.lyriclearn.data.util.lyricDtoMapper
import com.pedrodev.lyriclearn.data.util.normalizationTitleTrack
import com.pedrodev.lyriclearn.domain.models.Video

class LyricRepositoryImpl @Inject constructor(
    private val lrclibApiService: LrclibApiService
) : LyricRepository {
    override suspend fun searchLyric(video: Video): Result<Lyric> {
       val lyricRequestDto = normalizationTitleTrack(video)

        return try {
            if(lyricRequestDto != null) {
                val response = lrclibApiService.searchLyric(
                    lyricRequestDto.artist_name,
                    lyricRequestDto.track_name
                )
                val lyric = lyricDtoMapper(response)
                Result.success(lyric)

            }else{
                Result.failure(IllegalStateException("Não foi possível normalizar o vídeo"))
            }


        } catch (e: Exception) {
            Result.failure(e)
        }
        }
}