package com.pedrodev.lyriclearn.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun SearchBar(
    title: String,
    query: String,
    onQueryChange: (String) -> Unit
) {
    Column {
        Text(
            modifier = Modifier.padding(10.dp),
            text = title,
            color = Color(0xFFFFFFFF),
            fontSize = 28.sp,
            fontFamily = FontFamily.SansSerif, //mudar para Inter
            fontWeight = FontWeight.Bold
        )

        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .padding(horizontal = 5.dp),
            singleLine = true,
            value = query,
            onValueChange = onQueryChange,
            placeholder = {
                Row(
                    modifier = Modifier.fillMaxSize(),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search"
                    )
                    Text(" Buscar música")
                }
            }
        )
    }
}

@Preview
@Composable
fun SearchBarPreview() {
    var query by remember { mutableStateOf("") }
        SearchBar(
            title = "Search",
            query = query,
            onQueryChange = { query = it }
        )
}


