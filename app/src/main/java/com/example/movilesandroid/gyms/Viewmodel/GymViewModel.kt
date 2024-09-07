package com.example.movilesandroid.gyms.Viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movilesandroid.gyms.Models.Gym
import com.example.movilesandroid.gyms.Network.RetrofitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class GymViewModel: ViewModel() {
    private val apiService = RetrofitInstance.api
    val gyms = MutableStateFlow<List<Gym>>(emptyList())
    fun getGyms() {
        viewModelScope.launch {
            try {
                val response = apiService.getGyms()
                Log.d("GymViewModel","Gyms: $response")
                if (response.isNotEmpty()) {
                    gyms.value = response
                }
            } catch (e: Exception) {
                Log.e(
                    "GymViewModel",
                    e.message ?: "Error al obtener los gimnasios"
                )
            }
        }
    }
}