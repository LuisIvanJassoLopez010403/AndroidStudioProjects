package com.example.movilesandroid.Screens.Gyms.Network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitInstance {
    private
    const val BASE_URL = "https://gist.githubusercontent.com/"
    val api: GymService by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofit.create(GymService::class.java)
    }
}