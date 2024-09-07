package com.example.movilesandroid.thirdPartial

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.movilesandroid.R
import com.example.movilesandroid.navigation.BottomNavBarView
import com.example.movilesandroid.navigation.Routes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ThirdPartialView(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(id = R.string.third_partial_title), color = Color.White) },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.Red,
                )
            )
        },
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
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
            }
        },
        bottomBar = {
            BottomNavBarView(navController = navController)
        }
    )
}