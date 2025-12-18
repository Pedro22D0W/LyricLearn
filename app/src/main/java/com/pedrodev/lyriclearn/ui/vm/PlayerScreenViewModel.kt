package com.pedrodev.lyriclearn.ui.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pedrodev.lyriclearn.domain.models.Lyric
import com.pedrodev.lyriclearn.domain.models.Video
import com.pedrodev.lyriclearn.domain.repository.LyricRepository
import com.pedrodev.lyriclearn.domain.repository.VideoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class PlayerScreenViewModel@Inject constructor(
    private val videoRepository : VideoRepository,
    private val lyricRepository: LyricRepository): ViewModel() {
    private var _selectedVideo = MutableStateFlow<Video?>(null)
    val selectedVideo = _selectedVideo.asStateFlow()

    private var _lyric = MutableStateFlow<Lyric?>(null)
    val lyric = _lyric.asStateFlow()

    fun loadVideo(videoId: String){
        viewModelScope.launch {
            if (videoId.isNotBlank()) {
                val result = videoRepository.searchVideoById(videoId)
                _selectedVideo.value = result
            }
        }
    }

    fun loadLyric(artist_name:String,track_name:String){
        viewModelScope.launch {
                val result = lyricRepository.searchLyric(artist_name,track_name)
                _lyric.value = result
        }
    }
}