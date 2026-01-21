package com.pedrodev.lyriclearn.ui.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pedrodev.lyriclearn.domain.models.Video
import com.pedrodev.lyriclearn.domain.repository.VideoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoritesScreenViewModel @Inject constructor(private val videoRepository : VideoRepository) : ViewModel(){
    private val _query = MutableStateFlow("")
    val query = _query.asStateFlow()

    val favorites: StateFlow<List<Video>> =
        videoRepository.findFavorites()
            .stateIn(
                viewModelScope,
                SharingStarted.WhileSubscribed(5_000),
                emptyList()
            )

    fun onQueryChange(newQuery: String) {


    }

}