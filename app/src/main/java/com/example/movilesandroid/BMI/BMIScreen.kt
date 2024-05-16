package com.example.movilesandroid.BMI

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.movilesandroid.R
import com.example.movilesandroid.ui.theme.MovilesAndroidTheme

@Composable
fun BMIScreen(viewModel: BMIViewModel){
    var weight by remember { mutableStateOf("") }
    var height by remember { mutableStateOf("") }

    val bmibyViewModel by viewModel.getResult().observeAsState(0)
    val bmiResultStatusbyViewModel by viewModel.getStatus().observeAsState("")

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.padding(16.dp)
    ) {
        TextField(value = weight, onValueChange = {weight = it}, label = { Text(text = "Weight (kg)")})
        TextField(value = height, onValueChange = {height = it}, label = { Text(text = "Height (m)")})
        Button(onClick = { viewModel.calculateBMI(
            BMIModel(
            weight.toDouble(),
            height.toDouble()
        )
        )}) {
            Text(text = "Calculate BMI")
        }
        Text(text = "BMI: $bmibyViewModel")
        Text(text = "BMI status: $bmiResultStatusbyViewModel")
        Image(painter = painterResource(id = R.drawable.bmimeter), contentDescription = "meter image")
    }
}
@Preview(showBackground = true)
@Composable
fun BMIPreview() {
    MovilesAndroidTheme {
        BMIScreen(viewModel = BMIViewModel())
    }
}