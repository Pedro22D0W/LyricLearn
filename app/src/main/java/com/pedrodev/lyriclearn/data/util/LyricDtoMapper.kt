package com.pedrodev.lyriclearn.data.util

import com.pedrodev.lyriclearn.data.dto.LyricSearchResponseDto
import com.pedrodev.lyriclearn.domain.models.Lyric
import com.pedrodev.lyriclearn.domain.models.LyricWord
import kotlin.random.Random


fun lyricDtoMapper(lyricDto: LyricSearchResponseDto): Lyric{

    val wordList = lyricDto.plainLyrics
        .replace(Regex("[^a-zA-Z\\s]"), "")
        .split(Regex("\\s+"))
        .filter { it.isNotBlank() }
        .map { LyricWord(it,hidden = Random.nextBoolean()) }
    val lyric = Lyric(wordList)


    return lyric
}