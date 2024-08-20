package com.example.movilesandroid.rockPaperScissor

import androidx.lifecycle.ViewModel
import com.example.movilesandroid.R
import kotlin.random.Random

class RockPaperScissorViewModel : ViewModel() {
    fun getRandomImage() : Int {
        val randomNumber = Random.nextInt(3)
        return when(randomNumber) {
            0 -> R.drawable.rock
            1 -> R.drawable.paper
            else -> R.drawable.scissors
        }
    }
}