package com.pedrodev.lyriclearn.ui.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pedrodev.lyriclearn.domain.models.LyricWord

@Composable
fun LyricWord(word: LyricWord){
    val alpha by animateFloatAsState(
        targetValue = if (word.hidden) 0.3f else 1f
    )

    val scale by animateFloatAsState(
        targetValue = if (word.hidden) 0.95f else 1f
    )

    Text(
        text = if (word.hidden) "_".repeat(word.text.length) else word.text,
        modifier = Modifier
            .padding(2.dp)
            .alpha(alpha)
            .scale(scale),
        fontSize = 18.sp,
        color =  Color.White,
        fontFamily = FontFamily.SansSerif, //mudar para Inter
        fontWeight = FontWeight.Bold)
}

@Preview
@Composable
fun LyricWordPreview(){
    LyricWord(LyricWord("word",false))
}