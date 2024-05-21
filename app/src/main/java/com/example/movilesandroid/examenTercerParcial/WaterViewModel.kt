package com.example.movilesandroid.examenTercerParcial

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WaterViewModel : ViewModel() {
    private val currentWaterAmount = MutableLiveData(0.0)
    fun getCurrentWaterAmount(): LiveData<Double> = currentWaterAmount

    fun sumWater(water: WaterConsumeModel) {
        val incrementWaterTotal = (currentWaterAmount.value ?: 0.0) + water.waterAmount
        currentWaterAmount.postValue(incrementWaterTotal)
    }

    fun resetTotal() {
        currentWaterAmount.postValue(0.0)
    }
}



