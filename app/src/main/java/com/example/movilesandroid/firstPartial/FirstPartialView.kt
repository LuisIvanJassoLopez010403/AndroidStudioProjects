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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.movilesandroid.R
import com.example.movilesandroid.navigation.BottomNavBarView
import com.example.movilesandroid.navigation.Routes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FirstPartialView(firstViewModel: FirstPartialViewModel = viewModel(), navController: NavController) {
    val name = firstViewModel.name.collectAsState()

    LaunchedEffect(Unit) {
        firstViewModel.updateName()
    }
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(id = R.string.first_partial_title) + " " + name.value, color = Color.White) },
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
                    navController.navigate(Routes.gymListView)
                }) {
                    Text(
                        (stringResource(id = R.string.gymList_button)),
                        modifier = Modifier
                            .fillMaxWidth())
                }
                Button(onClick = {
                    navController.navigate(Routes.restaurantListView)
                }) {
                    Text(
                        (stringResource(id = R.string.restaurantList_button)),
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
