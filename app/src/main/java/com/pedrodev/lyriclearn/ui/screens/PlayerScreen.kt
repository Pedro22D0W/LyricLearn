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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.pedrodev.lyriclearn.ui.components.BottomBar
import com.pedrodev.lyriclearn.ui.vm.PlayerScreenViewModel


@Composable
fun PlayerScreen(videoId: String){
    val viewModel: PlayerScreenViewModel = hiltViewModel()
    val video = viewModel.selectedVideo.collectAsState()

    LaunchedEffect(videoId) {
        viewModel.loadVideo(videoId)
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
            Text(text = "videoId recebido: $videoId")
            Text(text = video.value?.title ?: "null")
            Text(text = video.value?.channelTitle ?: "null")

        }
    }
}


@Preview
@Composable
fun PlayerScreenPreview(){
    PlayerScreen("video")
}