package com.example.movilesandroid.firstPartialExam

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.movilesandroid.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FirstPartialExamView(viewModel: FirstPartialExamViewModel,navController: NavController) {
    var totalProduction by remember { mutableStateOf("0") }
    var backgroundColor by remember { mutableStateOf(Color.White) }

    val currentProduction by viewModel.getCurrentProduction().observeAsState(initial = 0)
    val percentage by viewModel.getPercentage().observeAsState(0.0)
    val currentProductionUnits = viewModel.calculateCurrentProductionUnits()
    val context = LocalContext.current
    val currentProductionMessage = stringResource(
        id = R.string.currentProduction_message,
        currentProductionUnits
    )
    val totalProductionInt = totalProduction.toIntOrNull() ?: 0
    val totalProductionMessage = stringResource(id = R.string.totalProduction_message)

    LaunchedEffect(percentage) {
        if (percentage >= 70) {
            backgroundColor = Color.Red
        } else {
            backgroundColor = Color.White
        }
    }

    Box (
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
    ) {
        TopAppBar(
            title = { Text(stringResource(id = R.string.first_partial_title), color = Color.White) },
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = Color.Blue,
            )
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.apples),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(50.dp)
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier
                    .padding(vertical = 16.dp)
            ) {
                Text(
                    stringResource(id = R.string.totalProduction_string),
                    color = Color.LightGray
                )
                TextField(
                    value = totalProduction,
                    onValueChange = { totalProduction = it },
                    colors = TextFieldDefaults.colors(
                        unfocusedContainerColor = Color.Transparent,
                        focusedContainerColor = Color.Transparent,
                    ),
                    modifier = Modifier
                        .width(150.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.apple),
                    contentDescription = "",
                    modifier = Modifier
                        .size(50.dp)
                        .clickable {
                            val formattedMessage = String.format(totalProductionMessage, viewModel.calculateTotalProductionUnits(FirstPartialExamModel(totalProductionInt)))
                            Toast
                                .makeText(
                                    context,
                                    formattedMessage,
                                    Toast.LENGTH_LONG
                                )
                                .show()
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
                    stringResource(id = R.string.currentProduction_string),
                    color = Color.LightGray
                )
                TextField(
                    value = "$currentProduction",
                    onValueChange = {},
                    colors = TextFieldDefaults.colors(
                        unfocusedContainerColor = Color.Transparent,
                        focusedContainerColor = Color.Transparent,
                    ),
                    modifier = Modifier
                        .width(150.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.apple),
                    contentDescription = "",
                    modifier = Modifier
                        .size(50.dp)
                        .clickable {
                            Toast
                                .makeText(
                                    context,
                                    currentProductionMessage,
                                    Toast.LENGTH_SHORT
                                )
                                .show()
                        }
                )

            }
            Row(
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier
                    .padding(vertical = 16.dp)
            ) {
                Button(
                    onClick = { viewModel.sumProduction(5) },
                    modifier = Modifier
                        .width(75.dp)
                        .height(60.dp),
                    shape = RoundedCornerShape(5.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
                ) {
                    Text(text = "+5")
                }
                Button(
                    onClick = { viewModel.sumProduction(15) },
                    modifier = Modifier
                        .width(75.dp)
                        .height(60.dp),
                    shape = RoundedCornerShape(5.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
                ) {
                    Text(text = "+15")
                }
                Button(
                    onClick = { viewModel.sumProduction(30) },
                    modifier = Modifier
                        .width(75.dp)
                        .height(60.dp),
                    shape = RoundedCornerShape(5.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
                ) {
                    Text(text = "+30")
                }
                Button(
                    onClick = { viewModel.sumProduction(50) },
                    modifier = Modifier
                        .width(75.dp)
                        .height(60.dp),
                    shape = RoundedCornerShape(5.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
                ) {
                    Text(text = "+50")
                }
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier
                    .padding(vertical = 16.dp)
            ) {
                Text(
                    stringResource(id = R.string.percentage_string),
                    color = Color.LightGray
                )
                TextField(
                    value = "$percentage",
                    onValueChange = {},
                    colors = TextFieldDefaults.colors(
                        unfocusedContainerColor = Color.Transparent,
                        focusedContainerColor = Color.Transparent,
                    ),
                    modifier = Modifier
                        .width(250.dp)
                )
            }
            Button(
                onClick = { viewModel.calculatePercentage(FirstPartialExamModel(totalProduction.toInt())) },
                modifier = Modifier
                    .width(150.dp),
                shape = RoundedCornerShape(5.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
            ) {
                Text(text = stringResource(id = R.string.calculate_button))
            }
        }
    }
}