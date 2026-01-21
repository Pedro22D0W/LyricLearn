package com.pedrodev.lyriclearn.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.pedrodev.lyriclearn.ui.components.BottomBar
import com.pedrodev.lyriclearn.ui.components.SearchBar
import com.pedrodev.lyriclearn.ui.components.SearchResult
import com.pedrodev.lyriclearn.ui.vm.FavoritesScreenViewModel

@Composable
fun FavoritesScreen(
    onNavigateToPlayer: (String) -> Unit,
    onNavigateToHome: () -> Unit
){

    val viewModel : FavoritesScreenViewModel = hiltViewModel()
    val query by viewModel.query.collectAsState()
    val favorites by viewModel.favorites.collectAsState()

    Scaffold(

        bottomBar = { BottomBar(tab = "favorites", onNavigate = {onNavigateToHome()} ) }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(Color(0xFF121212))
        ) {
            SearchBar(title = "Favorites",query = query, onQueryChange = viewModel::onQueryChange)
            val scrollState = rememberScrollState()

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(scrollState)
                    .padding(vertical = 5.dp)
            ) {
                for (video in favorites) {
                    SearchResult(
                        video = video,
                        onClick = { onNavigateToPlayer(video.videoId) }
                    )
                }
            }



        }
    }
}