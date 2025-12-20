package com.pedrodev.lyriclearn.ui.vm

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pedrodev.lyriclearn.domain.models.Lyric
import com.pedrodev.lyriclearn.domain.models.Video
import com.pedrodev.lyriclearn.domain.repository.LyricRepository
import com.pedrodev.lyriclearn.domain.repository.VideoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
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

    private var _canLoadLyrics = MutableStateFlow(true)
    val canLoadLyrics = _canLoadLyrics.asStateFlow()

    private var _loadedMusic = MutableStateFlow(false)
    val loadedMusic= _loadedMusic.asStateFlow()

    fun loadMusic(videoId: String){
        viewModelScope.launch {
            _loadedMusic.value = false

            val video = videoRepository.searchVideoById(videoId)
            _selectedVideo.value = video

            lyricRepository.searchLyric(video)
                .onSuccess {
                    _lyric.value = it
                    _canLoadLyrics.value = true
                }
                .onFailure {
                    _canLoadLyrics.value = false
                }
            _loadedMusic.value = true
        }
    }

    fun onWordChange(index: Int, value: String) {

        _lyric.update { lyric ->
            lyric?.let {
                val word = it.lyricWords[index]

                if (word.hidden && word.text == value) {
                    it.copy(
                        lyricWords = it.lyricWords.toMutableList().also { list ->
                            list[index] = word.copy(
                                hidden = false
                            )
                        }
                    )
                } else {
                    it // nenhuma mudança → nenhum emit → nenhuma recomposição
                }
            }
        }
    }
}