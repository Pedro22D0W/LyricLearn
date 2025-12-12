package com.pedrodev.lyriclearn

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.pedrodev.lyriclearn.ui.screens.HomeScreenPreview
import com.pedrodev.lyriclearn.ui.theme.LyricLearnTheme



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            LyricLearnTheme {
                HomeScreenPreview()
            }

        }
    }
}

