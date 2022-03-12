package com.sheecodes.retrofit_googleformdemo.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object FormApi {
    const val BASE_URL = "https://docs.google.com/forms/d/e/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val api: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}