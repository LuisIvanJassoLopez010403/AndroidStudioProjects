package com.example.movilesandroid.firstPartial

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.movilesandroid.navigation.Routes

@Composable
fun FirstPartialView(navController: NavController) {
    Column {
        Text(
            text = "First View",
            fontSize = 50.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
            )
        Button(onClick = {
            navController.navigate(Routes.sumView)
        }) {
            Text(
                text = "Go to Sum View",
                modifier = Modifier
                    .fillMaxWidth())
        }
        Button(onClick = {
            navController.navigate(Routes.rockPaperScissorView)
        }) {
            Text(
                text = "Go to RockPaperScissor View",
                modifier = Modifier
                    .fillMaxWidth())
        }
        Button(onClick = {
            navController.navigate(Routes.scoreView)
        }) {
            Text(
                text = "Go to Score View",
                modifier = Modifier
                    .fillMaxWidth())
        }
        Button(onClick = {
            navController.navigate(Routes.waterView)
        }) {
            Text(
                text = "Go to Water View",
                modifier = Modifier
                    .fillMaxWidth())
        }
        Button(onClick = {
            navController.navigate(Routes.bmiView)
        }) {
            Text(text = "Go to BMI View",
                modifier = Modifier
                    .fillMaxWidth())
        }
        Button(onClick = {
            navController.navigate(Routes.studentListView)
        }) {
            Text(text = "Go to Student List View",
                modifier = Modifier
                    .fillMaxWidth())
        }
        Button(onClick = {
            navController.navigate(Routes.buttonListView)
        }) {
            Text(text = "Go to Button List View",
                modifier = Modifier
                    .fillMaxWidth())
        }
        Button(onClick = {
            navController.navigate(Routes.loginView)
        }) {
            Text(text = "Go to Login View",
                modifier = Modifier
                    .fillMaxWidth())
        }
    }
}