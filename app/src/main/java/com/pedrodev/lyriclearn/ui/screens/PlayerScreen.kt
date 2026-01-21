package com.pedrodev.lyriclearn.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.pedrodev.lyriclearn.ui.components.BottomBar
import com.pedrodev.lyriclearn.ui.components.LyricBox
import com.pedrodev.lyriclearn.ui.components.PlayerCard
import com.pedrodev.lyriclearn.ui.vm.PlayerScreenViewModel


@Composable
fun PlayerScreen(videoId: String) {
    val viewModel: PlayerScreenViewModel = hiltViewModel()

    val loadedMusic by viewModel.loadedMusic.collectAsState()
    val canLoadLyrics by viewModel.canLoadLyrics.collectAsState()
    val selectedVideo by viewModel.selectedVideo.collectAsState()
    val lyric by viewModel.lyric.collectAsState()

    LaunchedEffect(videoId) {
        viewModel.loadMusic(videoId)
    }

    Scaffold(

    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(Color(0xFF121212))
        ) {
            if (loadedMusic) {

                if (canLoadLyrics) {

                    selectedVideo?.let { video ->
                        PlayerCard(video, onFavorite = {viewModel.favoriteSong()})

                        lyric?.let{ lyric ->
                            LyricBox(
                                lyric,
                                onWordChange = { index, value ->
                                viewModel.onWordChange(index, value)
                            })
                        }
                    }

                } else {
                    Text("não foi possível carregar as legendas")
                }

            } else {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color(0xFF121212)),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(60.dp),
                        strokeWidth = 4.dp,
                        color = Color.White
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun PlayerScreenPreview(){
    PlayerScreen("video")
}