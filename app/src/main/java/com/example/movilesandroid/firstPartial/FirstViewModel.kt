package com.example.movilesandroid.firstPartial

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class FirstPartialViewModel(application: Application) : AndroidViewModel(application) {

    private val sharedPreferences = application.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)

    private val _name = MutableStateFlow(sharedPreferences.getString("name", "") ?: "")
    val name: StateFlow<String> = _name

    fun updateName() {
        _name.value = sharedPreferences.getString("name", "") ?: ""
    }
}