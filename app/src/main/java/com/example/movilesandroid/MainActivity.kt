package com.example.movilesandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.movilesandroid.BMI.BMIScreen
import com.example.movilesandroid.BMI.BMIViewModel
import com.example.movilesandroid.RockPaperScissor.RockPaperScissorScreen
import com.example.movilesandroid.RockPaperScissor.RockPaperScissorViewModel
import com.example.movilesandroid.Screens.Gyms.Models.Gym
import com.example.movilesandroid.Screens.Gyms.Viewmodel.GymViewModel
import com.example.movilesandroid.Screens.Gyms.Views.GymList
import com.example.movilesandroid.Sum.SumScreen
import com.example.movilesandroid.Sum.SumViewModel
import com.example.movilesandroid.examenTercerParcial.WaterScreen
import com.example.movilesandroid.examenTercerParcial.WaterViewModel
import com.example.movilesandroid.ui.theme.MovilesAndroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovilesAndroidTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    //ExamenSegundoParcial(viewModel = SoccerScoreViewModel())
                    //SumScreen(viewModel = SumViewModel())
                    //RockPaperScissorScreen(viewModel = RockPaperScissorViewModel())
                    //BMIScreen(viewModel = BMIViewModel())
                    //GymList(viewModel = GymViewModel())
                    WaterScreen(viewModel = WaterViewModel())
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MovilesAndroidTheme {
        //ExamenSegundoParcial(viewModel = SoccerScoreViewModel())
        //SumScreen(viewModel = SumViewModel())
        //RockPaperScissorScreen(viewModel = RockPaperScissorViewModel())
        //BMIScreen(viewModel = BMIViewModel())
        //GymList(viewModel = GymViewModel())
        WaterScreen(viewModel = WaterViewModel())
    }
}
