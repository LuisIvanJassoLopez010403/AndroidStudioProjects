package com.example.movilesandroid.examenTercerParcial

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

data class WaterModel(val glass1: Double, val glass2: Double, val glass3: Double)

class WaterViewModel : ViewModel() {
    private val total = MutableLiveData(0.0)

    fun getTotal(): LiveData<Double> = total

    fun sumWater(glassNumber: Int, water: WaterModel) {
        val incrementWaterTotal = when (glassNumber) {
            1 -> (total.value ?: 0.0) + water.glass1
            2 -> (total.value ?: 0.0) + water.glass2
            3 -> (total.value ?: 0.0) + water.glass3
            else -> throw IllegalArgumentException("Invalid glass number")
        }
        total.postValue(incrementWaterTotal)
    }

    fun resetTotal() {
        total.postValue(0.0)
    }
}


