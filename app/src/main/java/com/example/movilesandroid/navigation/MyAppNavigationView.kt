package com.example.movilesandroid.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.movilesandroid.bmi.BMIView
import com.example.movilesandroid.bmi.BMIViewModel
import com.example.movilesandroid.buttonList.ButtonListView
import com.example.movilesandroid.rockPaperScissor.RockPaperScissorScreen
import com.example.movilesandroid.rockPaperScissor.RockPaperScissorViewModel
import com.example.movilesandroid.score.ScoreView
import com.example.movilesandroid.score.SoccerScoreViewModel
import com.example.movilesandroid.sum.SumScreen
import com.example.movilesandroid.sum.SumViewModel
import com.example.movilesandroid.water.WaterView
import com.example.movilesandroid.water.WaterViewModel
import com.example.movilesandroid.firstPartial.FirstPartialView
import com.example.movilesandroid.login.LoginView
import com.example.movilesandroid.secondPartial.SecondPartialView
import com.example.movilesandroid.studentList.StudentListView
import com.example.movilesandroid.thirdPartial.ThirdPartialView

@Composable
fun MyAppNavigationView() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.firstPartialView, builder =  {
        composable(Routes.firstPartialView) {
            FirstPartialView(navController)
        }
        composable(Routes.secondPartialView) {
            SecondPartialView(navController)
        }
        composable(Routes.thirdPartialView) {
            ThirdPartialView(navController)
        }
        composable(Routes.sumView) {
            SumScreen(viewModel = SumViewModel(),navController)
        }
        composable(Routes.rockPaperScissorView) {
            RockPaperScissorScreen(viewModel = RockPaperScissorViewModel(),navController)
        }
        composable(Routes.scoreView) {
            ScoreView(viewModel = SoccerScoreViewModel(),navController)
        }
        composable(Routes.waterView) {
            WaterView(viewModel = WaterViewModel(),navController)
        }
        composable(Routes.bmiView) {
            BMIView(viewModel = BMIViewModel(),navController)
        }
        composable(Routes.studentListView) {
            StudentListView(navController)
        }
        composable(Routes.buttonListView) {
            ButtonListView(navController)
        }
        composable(Routes.loginView) {
            LoginView(navController)
        }
    })
}