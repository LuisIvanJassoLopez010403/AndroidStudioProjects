package com.example.movilesandroid.firstPartial

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.movilesandroid.navigation.Routes

@Composable
fun FirstPartialView(navController: NavController) {
    Column {
        Text(text = "First View")
        Button(onClick = {
            navController.navigate(Routes.sumView)
        }) {
            Text(text = "Go to Sum View")
        }
        Button(onClick = {
            navController.navigate(Routes.rockPaperScissorView)
        }) {
            Text(text = "Go to RockPaperScissor View")
        }
        Button(onClick = {
            navController.navigate(Routes.scoreView)
        }) {
            Text(text = "Go to Score View")
        }
        Button(onClick = {
            navController.navigate(Routes.waterView)
        }) {
            Text(text = "Go to Water View")
        }
        Button(onClick = {
            navController.navigate(Routes.bmiView)
        }) {
            Text(text = "Go to BMI View")
        }
        Button(onClick = {
            navController.navigate(Routes.loginView)
        }) {
            Text(text = "Go to Login View")
        }
        Button(onClick = {
            navController.navigate(Routes.buttonListView)
        }) {
            Text(text = "Go to ButtonList View")
        }
        Button(onClick = {
            navController.navigate(Routes.studentListView)
        }) {
            Text(text = "Go to StudentList View")
        }
    }
}