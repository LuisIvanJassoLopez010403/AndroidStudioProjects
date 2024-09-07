package com.example.movilesandroid.firstPartialExam

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

data class FirstPartialExamModel(
    val totalProduction: Int
)

class FirstPartialExamViewModel : ViewModel() {
    private val percentage = MutableLiveData(0.0)
    private val currentProduction  = MutableLiveData(0)
    private val currentProductionUnits = MutableLiveData(0)

    fun getPercentage(): LiveData<Double> = percentage
    fun getCurrentProduction(): LiveData<Int> = currentProduction
    fun sumProduction(amount: Int) {
        val incrementCurrentProduction = (currentProduction.value ?: 0) + amount
        currentProduction.postValue(incrementCurrentProduction)
    }
    fun calculatePercentage(model : FirstPartialExamModel) {
        percentage.postValue(((currentProduction.value ?: 0) * 100) / model.totalProduction.toDouble())
    }
    fun calculateCurrentProductionUnits(): String {
        val units = (currentProduction.value ?: 0) * 80
        currentProductionUnits.postValue(units)
        return units.toString()
    }
    fun calculateTotalProductionUnits(model: FirstPartialExamModel): Int {
        return model.totalProduction * 80
    }
}