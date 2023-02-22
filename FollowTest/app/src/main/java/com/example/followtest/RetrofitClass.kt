package com.example.followtest

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun getRetrofit(): Retrofit {
    val retrofit = Retrofit.Builder()
        .baseUrl(ApiPathConstants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    return retrofit
}