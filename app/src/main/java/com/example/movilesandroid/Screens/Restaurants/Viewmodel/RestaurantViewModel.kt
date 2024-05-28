package com.example.movilesandroid.Screens.Restaurants.Viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movilesandroid.Screens.Restaurants.Network.RetrofitInstance
import com.example.movilesandroid.Screens.Restaurants.Models.Restaurant
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class RestaurantViewModel: ViewModel() {
    private val apiService = RetrofitInstance.api
    val restaurants = MutableStateFlow<List<Restaurant>>(emptyList())
    fun getRestaurants() {
        viewModelScope.launch {
            try {
                val response = apiService.getRestaurants()
                Log.d("RestaurantViewModel","Restaurant: $response")
                if (response.isNotEmpty()) {
                    restaurants.value = response
                }
            } catch (e: Exception) {
                Log.e(
                    "RestaurantViewModel",
                    e.message ?: "Error al obtener los restaurantes"
                )
            }
        }
    }
}