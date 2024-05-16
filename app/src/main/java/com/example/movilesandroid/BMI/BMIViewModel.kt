package com.example.movilesandroid.BMI

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.math.pow

data class BMIModel(val weight: Double,val height: Double)

class BMIViewModel : ViewModel() {
    private val result = MutableLiveData(0.0)
    private val bmiResultStatus = MutableLiveData("")

    fun getResult(): MutableLiveData<Double> = result
    fun getStatus(): LiveData<String> = bmiResultStatus

    fun calculateBMI(bmi: BMIModel) {
        print("BMI attempt")
        Log.d("weight",bmi.weight.toString())
        Log.d("height",bmi.height.toString())
        Log.e("Error","An error occured")
        result.postValue(bmi.weight / (bmi.height.pow(2)))

        if (result.value!! < 18.5) {
            bmiResultStatus.postValue("Underweight")}
        else if (result.value!! >= 18.5 && result.value!! < 25.0) {
            bmiResultStatus.postValue("Normal")}
        else if (result.value!! >= 25.0 && result.value!! < 30.0) {
            bmiResultStatus.postValue("Overweight")}
        else if (result.value!! >= 30) {
            bmiResultStatus.postValue("Obese")}
    }
}