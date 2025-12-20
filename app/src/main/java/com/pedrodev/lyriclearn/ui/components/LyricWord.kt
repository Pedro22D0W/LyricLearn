package com.pedrodev.lyriclearn.ui.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pedrodev.lyriclearn.domain.models.LyricWord

@Composable
fun LyricWord(
    index: Int,
    word: LyricWord,
    onWordChange: (Int,String) -> Unit
){
    var localInput by remember { mutableStateOf("") }

    val alpha by animateFloatAsState(
        targetValue = if (word.hidden) 0.3f else 1f
    )

    val scale by animateFloatAsState(
        targetValue = if (word.hidden) 0.95f else 1f
    )

    if(word.hidden){
        BasicTextField(
            value = localInput,
            onValueChange = { newValue ->
                localInput = newValue
                onWordChange(index, newValue)
            },
            modifier = Modifier
                .height(27.dp)
                .defaultMinSize(minWidth = 22.dp)
                .width(((word.text.length * 12)+3).dp)
                .padding(2.dp)
                .border(1.dp, Color.Gray, RoundedCornerShape(6.dp))
                .background(Color(0xFF2A2A2A), shape = RoundedCornerShape(6.dp)),
            textStyle = TextStyle(
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            ),
            cursorBrush = SolidColor(Color.White),
            singleLine = true,
            decorationBox = { innerTextField ->
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 6.dp),
                    contentAlignment = Alignment.CenterStart
                ) {
                    innerTextField()
                }
            }

        )
    }
    else {
        Text(
            text = word.text,
            modifier = Modifier
                .padding(2.dp)
                .alpha(alpha)
                .scale(scale),
            fontSize = 18.sp,
            color = Color.White,
            fontFamily = FontFamily.SansSerif, //mudar para Inter
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview
@Composable
fun LyricWordPreview(){
    LyricWord(0,LyricWord("word",false), onWordChange = {} as (Int, String) -> Unit)
}