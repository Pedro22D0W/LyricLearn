package com.pedrodev.lyriclearn.domain.models

data class Lyric(
    val lyricWords : List<LyricWord>
)

data class LyricWord(
    val text: String,
    val hidden: Boolean =true
)
