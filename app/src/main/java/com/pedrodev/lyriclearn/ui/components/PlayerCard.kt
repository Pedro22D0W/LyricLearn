package com.pedrodev.lyriclearn.ui.components


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.LocalLifecycleOwner
import com.pedrodev.lyriclearn.domain.models.Video

@Composable
fun PlayerCard(video: Video){
    val lifecycleOwner = LocalLifecycleOwner.current
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp),
    ) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF121212))
            .padding(5.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically


        ) {

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = video.title,
                    modifier = Modifier,
                    color = Color(0xFFFFFFFF),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    fontSize = 15.sp,
                    fontFamily = FontFamily.SansSerif, //mudar para Inter
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = video.channelTitle,
                    modifier = Modifier,
                    color = Color(0xFFBBBBBA),
                    maxLines = 1,
                    fontSize = 12.sp,
                    )

            }
            Icon(
                imageVector = Icons.Default.Favorite,
                contentDescription = "Favorite",
                tint = Color.Red,
                modifier = Modifier.padding(start = 8.dp)
            )

        }
        Spacer(modifier = Modifier)
        YoutubePlayer(videoId = video.videoId, lifecycleOwner = lifecycleOwner)

    }
}

@Preview
@Composable
fun PlayerCardPreview(){
    PlayerCard(Video(
        "7wtfhZwyrcc",
        "Imagine Dragons - Believer (Official Music Video)",
        "ImagineDragonsVEVO",
        "https://i.ytimg.com/vi/7wtfhZwyrcc/mqdefault.jpg"))
}