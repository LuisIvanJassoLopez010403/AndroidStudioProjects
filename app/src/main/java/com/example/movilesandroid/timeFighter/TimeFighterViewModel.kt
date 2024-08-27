package com.example.movilesandroid.timeFighter

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class TimeFighterViewModel : ViewModel() {
    var counter by mutableStateOf(0)
        private set
    var timeLeft by mutableStateOf(10)
        private set
    var isButtonEnabled by mutableStateOf(true)
        private set
    private var timerJob: Job? = null

    fun onButtonClick() {
        counter++
        if (timerJob == null || timeLeft == 0) {
            startTimer()
        }
    }
    fun onRestartClick() {
        restart()
    }
    private fun startTimer() {
        timerJob?.cancel()
        isButtonEnabled = true
        timerJob = viewModelScope.launch {
            while (timeLeft > 0) {
                delay(1000L)
                timeLeft--
            }
            isButtonEnabled = false
            timerJob = null
        }
    }
    private fun restart() {
        counter = 0
        timeLeft = 10
        isButtonEnabled = true
        timerJob = null
    }
}