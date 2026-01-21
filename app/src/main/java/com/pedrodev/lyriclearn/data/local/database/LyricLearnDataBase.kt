package com.pedrodev.lyriclearn.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.pedrodev.lyriclearn.data.local.database.dao.VideoDao
import com.pedrodev.lyriclearn.data.local.database.entities.VideoEntity
import com.pedrodev.lyriclearn.data.local.database.converter.LyricWordsTypeConverter

@Database(entities = [VideoEntity::class], version = 1)
@TypeConverters(LyricWordsTypeConverter::class)
abstract class LyricLearnDataBase : RoomDatabase() {

    abstract fun videoDao(): VideoDao
}