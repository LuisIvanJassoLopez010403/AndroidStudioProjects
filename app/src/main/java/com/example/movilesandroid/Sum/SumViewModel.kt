package com.example.movilesandroid.Sum

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

data class SumModel(val number1: Int,val number2: Int,val number3: Int)

class SumViewModel : ViewModel() {
    private val resultado = MutableLiveData(0)
    fun getResult(): LiveData<Int> = resultado

    fun sumNumbers(sum: SumModel) {
        print("Sum Attempt")
        Log.d("num1",sum.number1.toString())
        Log.d("num2",sum.number2.toString())
        Log.d("num3",sum.number3.toString())
        Log.e("error","Error occured")
        resultado.postValue(sum.number1 + sum.number2 + sum.number3)
    }
}
