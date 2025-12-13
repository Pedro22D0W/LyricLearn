package com.pedrodev.lyriclearn.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.pedrodev.lyriclearn.domain.models.Video
import com.pedrodev.lyriclearn.ui.components.BottomBar
import com.pedrodev.lyriclearn.ui.components.SearchResult

@Composable
fun HomeSreen(){
    Scaffold(
        bottomBar = { BottomBar() }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(Color(0xFF121212))
        ) {
            Column {
                Text(
                    text = "Search",
                    color = Color(0xFFFFFFFF),
                    fontSize = 28.sp,
                    fontFamily = FontFamily.SansSerif, //mudar para Inter
                    fontWeight = FontWeight.Bold
                )
                for(i in 0..9) {
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