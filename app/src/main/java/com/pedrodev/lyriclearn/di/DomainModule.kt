package com.pedrodev.lyriclearn.di

import com.pedrodev.lyriclearn.data.repositories.VideoRepositoryImpl
import com.pedrodev.lyriclearn.domain.repository.VideoRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DomainModule {

    @Binds
    @Singleton
    abstract fun provideVideoRepository(
        impl: VideoRepositoryImpl
    ): VideoRepository

}