package com.pedrodev.lyriclearn.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pedrodev.lyriclearn.domain.models.Lyric
import com.pedrodev.lyriclearn.domain.models.LyricWord

@Composable
fun LyricBox(lyric: Lyric){



    Box(modifier = Modifier
        .padding(5.dp)
        .fillMaxWidth()
        .height(100.dp)
        .background(Color(0xFF525151),shape = RoundedCornerShape(12.dp))
    ){
        FlowRow(
            modifier = Modifier
                .padding(5.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Center
        ) {
            for (word in lyric.lyricWords){
                LyricWord(word)
            }
        }
    }
}

@Preview
@Composable
fun LyricBoxPreview(){
    val lyricPreview = Lyric(
        listOf(
            LyricWord("Frist",false),
            LyricWord("Frist",true),
            LyricWord("Frist",false),
            LyricWord("a Very big word",true),
            LyricWord("thenextwillbeasmall",true),
            LyricWord("a",true),
            LyricWord("Small",true),
            LyricWord("Small",false),
            LyricWord("Small",false),
            LyricWord("Small",true),
            LyricWord("Small",false),
            LyricWord("Small",true),
            LyricWord("Small",false),
            LyricWord("Small",true),
            LyricWord("Small",false),
            LyricWord("Small",true),
            LyricWord("Small",true),
            LyricWord("a",true),
        )
    )
    LyricBox(lyricPreview)
}