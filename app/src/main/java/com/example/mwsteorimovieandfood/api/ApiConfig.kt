package com.example.mwsteorimovieandfood.api

import com.example.mwsteorimovieandfood.api.interfaces.bioskop.ApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiConfig {
    const val BASE_URL=("http://192.168.1.19/bioskop/public/")
    fun getService(): ApiService {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(ApiService::class.java)
    }
}