package com.pedrodev.lyriclearn.data.remote

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import com.pedrodev.lyriclearn.BuildConfig




class RemoteDataSourceProvider {

    fun createYoutubeApiService(): YoutubeApiService {

        // Interceptor to add Api Key in Request
        val apiKeyInterceptor = Interceptor { chain ->
            val original = chain.request()
            val originalUrl = original.url
            val newUrl = originalUrl.newBuilder()
                .addQueryParameter("key", BuildConfig.YOUTUBE_API_KEY)
                .build()
            val newRequest = original.newBuilder().url(newUrl).build()
            chain.proceed(newRequest)
        }

        //Build http client with interceptors
        val client = OkHttpClient.Builder()
            .addInterceptor(apiKeyInterceptor)
            .addInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY })
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .callTimeout(30, TimeUnit.SECONDS)
            .build()

        //Instance the Interfacie Retrofit "YoutubeApiService
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.googleapis.com/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(YoutubeApiService::class.java)

    }
}