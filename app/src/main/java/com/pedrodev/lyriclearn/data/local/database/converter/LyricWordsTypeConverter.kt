package com.pedrodev.lyriclearn.data.local.database.converter

import androidx.room.TypeConverter
import com.google.gson.Gson

class LyricWordsTypeConverter {

    private val gson = Gson()

    @TypeConverter
    fun fromList(words: List<String>): String {
        return gson.toJson(words)
    }

    @TypeConverter
    fun toList(json: String): List<String> {
        return gson.fromJson(json, Array<String>::class.java).toList()
    }
}