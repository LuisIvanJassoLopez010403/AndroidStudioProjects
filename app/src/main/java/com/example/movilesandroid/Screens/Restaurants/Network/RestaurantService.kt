package com.example.movilesandroid.Screens.Restaurants.Network

import com.example.movilesandroid.Screens.Restaurants.Models.Restaurant
import retrofit2.http.GET

interface RestaurantService {
    @GET("LuisIvanJassoLopez010403/6e4b78458682676ca5bfed3ce81a316d/raw/d06100c6b757b272cef7dc86b63447c83b4f6915/restaurants.json")
    suspend fun getRestaurants(): List<Restaurant>
}