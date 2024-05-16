package com.example.movilesandroid.Screens.Gyms.Viewmodel

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movilesandroid.Screens.Gyms.Models.Gym
import com.example.movilesandroid.Screens.Gyms.Network.RetrofitInstance
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