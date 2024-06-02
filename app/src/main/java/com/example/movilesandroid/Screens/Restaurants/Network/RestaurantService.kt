package com.example.movilesandroid.Screens.Restaurants.Network

import com.example.movilesandroid.Screens.Restaurants.Models.Restaurant
import retrofit2.http.GET

interface RestaurantService {
    @GET("LuisIvanJassoLopez010403/6e4b78458682676ca5bfed3ce81a316d/raw/45ccf7601a1e2aa8fdef705dbe5689bcff6668d0/restaurants.json")
    suspend fun getRestaurants(): List<Restaurant>
}