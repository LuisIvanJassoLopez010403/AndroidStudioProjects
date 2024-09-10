package com.example.movilesandroid.randomCard

import androidx.lifecycle.ViewModel
import com.example.movilesandroid.R
import kotlin.random.Random

class RandomCardViewModel : ViewModel() {

    fun getRandomImage() : Int {
        val randomNumber: Int = Random.nextInt(12)
        return when(randomNumber) {
            0 -> R.drawable.h01
            1 -> R.drawable.h02
            2 -> R.drawable.h03
            3 -> R.drawable.h04
            4 -> R.drawable.h05
            5 -> R.drawable.h06
            6 -> R.drawable.h07
            7 -> R.drawable.h08
            8 -> R.drawable.h09
            9 -> R.drawable.h10
            10 -> R.drawable.hc1j
            11 -> R.drawable.hc2q
            else -> {R.drawable.hc3k}
        }
    }
    fun hideImage(): Int {
        return R.drawable.back
    }
}