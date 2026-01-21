package com.pedrodev.lyriclearn.data.local.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.pedrodev.lyriclearn.data.local.database.entities.VideoEntity
import com.pedrodev.lyriclearn.domain.models.Video
import kotlinx.coroutines.flow.Flow

@Dao
interface VideoDao {

    @Query("SELECT * FROM videoentity")
    fun findAllFavorites(): Flow<List<VideoEntity>>
    @Query("SELECT * FROM VideoEntity WHERE videoId LIKE :videoId")
   suspend fun findVideoById(videoId: String): VideoEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveVideo(videoEntity: VideoEntity)
}