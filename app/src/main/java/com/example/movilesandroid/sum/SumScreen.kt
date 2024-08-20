package com.example.movilesandroid.sum

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.movilesandroid.ui.theme.MovilesAndroidTheme

@Composable
fun SumScreen(viewModel: SumViewModel,navController: NavController) {
    var number1 by remember { mutableStateOf("") }
    var number2 by remember { mutableStateOf("") }
    var number3 by remember { mutableStateOf("") }

    val resultbyViewModel by viewModel.getResult().observeAsState(0)


    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(16.dp)
    ) {
        TextField(value = number1, onValueChange = {number1 = it}, label = { Text(text = "Number 1")})
        TextField(value = number2, onValueChange = {number2= it}, label = { Text(text = "Number 2")})
        TextField(value = number3, onValueChange = {number3= it}, label = { Text(text = "Number 3")})
        Button(onClick = { viewModel.sumNumbers(
            SumModel(
                number1.toInt(),
                number2.toInt(),
                number3.toInt()
            )
        )}) {
            Text(text = "Sum")
        }
        Text(text = "Result: $resultbyViewModel")
    }
}

@Preview(showBackground = true)
@Composable
fun SumaPreview() {
    MovilesAndroidTheme {
        SumScreen(viewModel = SumViewModel(), navController = rememberNavController())
    }
}