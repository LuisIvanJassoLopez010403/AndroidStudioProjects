package com.example.movilesandroid.sharedpreferences

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SharedPreferencesViewModel(application: Application) : AndroidViewModel(application) {
    private val sharedPreferences = application.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)

    private val _name = MutableStateFlow(sharedPreferences.getString("name", "") ?: "")
    val name: StateFlow<String> = _name

    fun saveName(newName: String) {
        viewModelScope.launch {
            sharedPreferences.edit().putString("name", newName).apply()
            _name.value = newName
        }
    }
}