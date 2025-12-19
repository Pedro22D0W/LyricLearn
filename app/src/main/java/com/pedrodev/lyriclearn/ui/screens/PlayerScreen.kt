package com.pedrodev.lyriclearn.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.pedrodev.lyriclearn.ui.components.BottomBar
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

        bottomBar = { BottomBar() }
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
                        PlayerCard(video)

                        lyric?.let {
                            for(word in it.lyricWords)
                            Text(text = word.text)
                        }
                    }

                } else {
                    Text("não foi possível carregar as legendas")
                }

            } else {
                Text("Carregando...")
            }
        }
    }
}

@Preview
@Composable
fun PlayerScreenPreview(){
    PlayerScreen("video")
}