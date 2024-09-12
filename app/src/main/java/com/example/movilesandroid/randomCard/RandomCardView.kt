package com.example.movilesandroid.randomCard

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.example.movilesandroid.R

@Composable
fun RandomCardView(viewModel: RandomCardViewModel,navController: NavController) {
    var randomImage by remember { mutableStateOf(R.drawable.back) }
    Column {
        Image(
            painter = painterResource(id = randomImage),
            contentDescription = "Random Image"
        )
        Button(onClick = {  randomImage = viewModel.getRandomImage() }) {
            Text(
                text = "Show Card",
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
        Button(onClick = { randomImage = viewModel.hideImage() }) {
            Text(
                text = "Hide Card",
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
    }
}