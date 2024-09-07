package com.example.movilesandroid.firstPartial

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
fun FirstPartialView(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(id = R.string.first_partial_title), color = Color.White) },
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
                Text(
                    (stringResource(id = R.string.first_partial_screen_title)),
                    fontSize = 50.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
                Button(onClick = {
                    navController.navigate(Routes.sumView)
                }) {
                    Text(
                        (stringResource(id = R.string.sum_button)),
                        modifier = Modifier
                            .fillMaxWidth())
                }
                Button(onClick = {
                    navController.navigate(Routes.rockPaperScissorView)
                }) {
                    Text(
                        (stringResource(id = R.string.rockPaperScissor_button)),
                        modifier = Modifier
                            .fillMaxWidth())
                }
                Button(onClick = {
                    navController.navigate(Routes.scoreView)
                }) {
                    Text(
                        (stringResource(id = R.string.score_button)),
                        modifier = Modifier
                            .fillMaxWidth())
                }
                Button(onClick = {
                    navController.navigate(Routes.waterView)
                }) {
                    Text(
                        (stringResource(id = R.string.water_button)),
                        modifier = Modifier
                            .fillMaxWidth())
                }
                Button(onClick = {
                    navController.navigate(Routes.bmiView)
                }) {
                    Text(
                        (stringResource(id = R.string.bmi_button)),
                        modifier = Modifier
                            .fillMaxWidth())
                }
                Button(onClick = {
                    navController.navigate(Routes.studentListView)
                }) {
                    Text(
                        (stringResource(id = R.string.studentList_button)),
                        modifier = Modifier
                            .fillMaxWidth())
                }
                Button(onClick = {
                    navController.navigate(Routes.buttonListView)
                }) {
                    Text(
                        (stringResource(id = R.string.buttonList_button)),
                        modifier = Modifier
                            .fillMaxWidth())
                }
                Button(onClick = {
                    navController.navigate(Routes.loginView)
                }) {
                    Text(
                        (stringResource(id = R.string.login_button)),
                        modifier = Modifier
                            .fillMaxWidth())
                }
                Button(onClick = {
                    navController.navigate(Routes.timeFighterView)
                }) {
                    Text(
                        (stringResource(id = R.string.timeFighter_button)),
                        modifier = Modifier
                            .fillMaxWidth())
                }
                Button(onClick = {
                    navController.navigate(Routes.lottieAnimationView)
                }) {
                    Text(
                        (stringResource(id = R.string.lottieAnimation_button)),
                        modifier = Modifier
                            .fillMaxWidth())
                }
                Button(onClick = {
                    navController.navigate(Routes.videoBackgroundView)
                }) {
                    Text(
                        (stringResource(id = R.string.videoBackground_button)),
                        modifier = Modifier
                            .fillMaxWidth())
                }
                Button(onClick = {
                    navController.navigate(Routes.firstPartialExamView)
                }) {
                    Text(
                        (stringResource(id = R.string.firstPartialTest_button)),
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