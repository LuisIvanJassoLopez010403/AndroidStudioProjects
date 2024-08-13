package com.example.movilesandroid.CookBook

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun MainScreen() {
    Column {
       Button(onClick = { }) {
           Text(
               text = "BMI",
               modifier = Modifier
                   .fillMaxWidth()
           )
       }
        Button(onClick = { }) {
            Text(
                text = "RockPaperScissor",
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
        Button(onClick = { }) {
            Text(
                text = "Score",
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
        Button(onClick = { }) {
            Text(
                text = "Sum",
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
        Button(onClick = { }) {
            Text(
                text = "Gyms",
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
        Button(onClick = { }) {
            Text(
                text = "Restaurants",
                modifier = Modifier
                    .fillMaxWidth())
        }
    }
}