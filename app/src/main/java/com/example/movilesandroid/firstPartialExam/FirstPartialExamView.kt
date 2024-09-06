package com.example.movilesandroid.firstPartialExam

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.movilesandroid.R

@Composable
fun FirstPartialExamView(viewModel: FirstPartialExamViewModel,navController: NavController) {
    val currentProduction by viewModel.getCurrentProduction().observeAsState(initial = 0)
    var totalProduction by remember {
        mutableStateOf("")
    }
    val percentage by viewModel.getPercentage().observeAsState(0.0)

    val productionUnits = viewModel.calculateCurrentProductionUnits()

    val context = LocalContext.current

    var backgroundColor by remember { mutableStateOf(Color.White) }

    LaunchedEffect(percentage) {
        if (percentage >= 70) {
            backgroundColor = Color.Red
        } else {
            backgroundColor = Color.White
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
            .background(backgroundColor),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.apples),
            contentDescription = "",
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier
                .padding(vertical = 16.dp)
        ) {
            Text(
                text = "Producción Total",
                color = Color.LightGray
            )
            TextField(
                value = totalProduction,
                onValueChange = {totalProduction = it},
                modifier = Modifier
                    .width(100.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.apple),
                contentDescription = "",
                modifier = Modifier
                    .size(30.dp)
                    .clickable {
                        Toast.makeText(
                            context,
                            "Hay un total de ${(totalProduction.toDouble() * 80)} manzanas",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier
                .padding(vertical = 16.dp)
        ) {
            Text(
                text = "Producción Actual",
                color = Color.LightGray
            )
            TextField(
                value = "$currentProduction",
                onValueChange = {},
                modifier = Modifier
                    .width(100.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.apple),
                contentDescription = "",
                modifier = Modifier
                    .size(30.dp)
                    .clickable {
                        Toast.makeText(
                            context,
                            "Hay un total de $productionUnits manzanas",
                            Toast.LENGTH_LONG
                        ).show()
                    }
            )

        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier
                .padding(vertical = 16.dp)
        ) {
            Button(onClick = { viewModel.sumProduction(5) }) {
                Text(text = "+5")
            }
            Button(onClick = { viewModel.sumProduction(15) }) {
                Text(text = "+15")
            }
            Button(onClick = { viewModel.sumProduction(30) }) {
                Text(text = "+30")
            }
            Button(onClick = { viewModel.sumProduction(50) }) {
                Text(text = "+50")
            }
        }
        Row {
            Text(text = "Porcentaje")
            TextField(value = "$percentage", onValueChange = {})
        }
        Button(onClick = {
            viewModel.calculatePercentage(totalProduction.toInt())

        }) {
            Text(text = "Calcular")
        }
    }
}