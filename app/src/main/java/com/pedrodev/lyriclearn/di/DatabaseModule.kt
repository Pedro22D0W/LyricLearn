package com.pedrodev.lyriclearn.di

import android.content.Context
import androidx.room.Room
import com.pedrodev.lyriclearn.data.local.database.LyricLearnDataBase
import com.pedrodev.lyriclearn.data.local.database.dao.VideoDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): LyricLearnDataBase {
        return Room.databaseBuilder(context = context, LyricLearnDataBase::class.java,"lyric-learn-db")
            .build()
    }
    @Provides
    fun provideVideoDao(lyricLearnDataBase: LyricLearnDataBase): VideoDao =
        lyricLearnDataBase.videoDao()
}