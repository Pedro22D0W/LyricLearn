package com.pedrodev.lyriclearn.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun BottomBar(){
    BottomAppBar(containerColor = Color(0xFF282828),
        contentColor = Color(0xFF717171),
        modifier = Modifier.height(50.dp)
        ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        )
        {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally

            )
            {
                Icon(imageVector = Icons.Default.Search,
                    contentDescription = "Search page"
                )
                Text(text = "Search")
            }
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally

            )
            {
                Icon(imageVector = Icons.Default.FavoriteBorder,
                    contentDescription = "Library page"
                )
                Text(text = "Favorites")
            }

        }
    }
}

@Preview
@Composable
fun ButtonBarPreview(){
    BottomBar()
}