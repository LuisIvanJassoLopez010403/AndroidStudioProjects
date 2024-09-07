package com.example.movilesandroid.gyms.Network

import com.example.movilesandroid.gyms.Models.Gym
import retrofit2.http.GET

interface GymService {
    @GET("LuisIvanJassoLopez010403/5b657cdf815f190adaa5d8ff8de3c117/raw/f6e704185d7cd1ff49387eaec328e75d0716f03f/gyms.json")
    suspend fun getGyms(): List<Gym>
}