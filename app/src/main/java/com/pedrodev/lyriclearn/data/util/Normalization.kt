package com.pedrodev.lyriclearn.data.util

import android.util.Log
import com.pedrodev.lyriclearn.data.dto.LyricRequestDto
import com.pedrodev.lyriclearn.domain.models.Video

fun normalizationTitleTrack(video: Video) : LyricRequestDto ?{
    val delimiters = listOf("-", "(", "[",)

    var title_frist_word = video.title.substringBefore("-")
    var title_second_word = video.title.substringAfter("-")

    for (d in delimiters) {
        title_frist_word = title_frist_word.substringBefore(d)
        title_second_word = title_second_word.substringBefore(d)
    }

    if(video.channelTitle
        .lowercase()
        .replace(" ", "")
        .replace(Regex("[^a-z0-9]"), "")
        .contains(title_frist_word
            .lowercase()
            .replace(" ", "")
            .replace(Regex("[^a-z0-9]"), ""))){

        return LyricRequestDto(title_frist_word,title_second_word)
    }
    else if (video.channelTitle
        .lowercase()
        .replace(" ", "")
        .replace(Regex("[^a-z0-9]"), "")
        .contains(title_second_word
            .lowercase()
            .replace(" ", "")
            .replace(Regex("[^a-z0-9]"), ""))){
        Log.d(
            "Normilize",
            "Buscando letra caso2: artist='${title_frist_word}', track='${title_second_word}'"
        )
        return LyricRequestDto(title_frist_word,title_second_word)
    }
    return null
}