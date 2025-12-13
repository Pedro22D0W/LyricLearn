package com.pedrodev.lyriclearn.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.pedrodev.lyriclearn.domain.models.Video

@Composable
fun SearchResult(video: Video){

        Row(
            modifier = Modifier.fillMaxWidth()
                .background(Color(0xFF121212))
                .height(50.dp)
                .padding(5.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        )
        {
            AsyncImage(
                model = video.thumbnail,
                contentDescription = null,
                placeholder = ColorPainter(Color.Gray),
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxHeight()
                    .width(60.dp)
            )
            Column(
            )
            {
                Text(
                    modifier = Modifier.padding(2.dp),
                    color = Color(0xFFFFFFFF),
                    text = video.title,
                    maxLines = 1

                )
                Text(
                    modifier = Modifier.padding(2.dp),
                    color = Color(0xFFB3B3B3),
                    text = video.channelTitle
                )
            }
        }
    }




@Preview
@Composable
fun SearchResultPreview(){
    SearchResult(Video(
        "7wtfhZwyrcc",
        "Imagine Dragons - Believer (Official Music Video)",
        "ImagineDragonsVEVO",
        "https://i.ytimg.com/vi/7wtfhZwyrcc/mqdefault.jpg"
    ))
}