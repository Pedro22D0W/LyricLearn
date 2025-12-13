package com.pedrodev.lyriclearn.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pedrodev.lyriclearn.domain.models.Video
import com.pedrodev.lyriclearn.ui.components.BottomBar
import com.pedrodev.lyriclearn.ui.components.SearchBar
import com.pedrodev.lyriclearn.ui.components.SearchResult

@Composable
fun HomeSreen(){
    var query by remember { mutableStateOf("") }
    Scaffold(

        bottomBar = { BottomBar() }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(Color(0xFF121212))
        ) {
            SearchBar(title = "Search",query = query, onQueryChange = { query = it })
            Column(
                modifier = Modifier.padding(vertical = 5.dp)
            ){

                for(i in 0..5) {
                    SearchResult(
                        Video(
                            "7wtfhZwyrcc",
                            "Imagine Dragons - Believer (Official Music Video)",
                            "ImagineDragonsVEVO",
                            "https://i.ytimg.com/vi/7wtfhZwyrcc/mqdefault.jpg"

                        )
                    )
                }
            }


        }
    }
}


@Preview
@Composable
fun HomeScreenPreview(){
    HomeSreen()
}