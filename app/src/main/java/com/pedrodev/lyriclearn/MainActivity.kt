package com.pedrodev.lyriclearn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.pedrodev.lyriclearn.ui.screens.HomeScreen
import com.pedrodev.lyriclearn.ui.theme.LyricLearnTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            LyricLearnTheme {
                HomeScreen()
            }

        }
    }
}

