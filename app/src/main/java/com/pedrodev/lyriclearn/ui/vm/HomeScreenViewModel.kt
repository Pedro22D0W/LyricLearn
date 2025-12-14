package com.pedrodev.lyriclearn.ui.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pedrodev.lyriclearn.domain.models.Video
import com.pedrodev.lyriclearn.domain.repository.VideoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel@Inject constructor(private val videoRepository : VideoRepository) : ViewModel() {

    private var searchVideos: Job? = null
    private val _query = MutableStateFlow("")
    val query = _query.asStateFlow()

    private val _videos = MutableStateFlow<List<Video>>(emptyList())
    val videos = _videos.asStateFlow()

    fun onQueryChange(newQuery: String) {
        _query.value = newQuery
        searchVideos?.cancel()
        searchVideos = viewModelScope.launch {
            delay(500)
            if (newQuery.isNotBlank()) {
                val result = videoRepository.searchVideos(newQuery)
                _videos.value = result
            } else {
                _videos.value = emptyList()
            }
        }

    }

}