package com.example.movilesandroid.timeFighter

import android.media.MediaPlayer
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.movilesandroid.R
import kotlinx.coroutines.delay

@Composable
fun TimeFighterView(viewModel: TimeFighterViewModel, navController: NavController) {
    val context = LocalContext.current

    var buttonSize by remember { mutableStateOf(100.dp) } // Tamaño inicial del botón
    var mediaPlayer by remember { mutableStateOf<MediaPlayer?>(null) }

    val animatedButtonSize by animateDpAsState(
        targetValue = buttonSize,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        ), label = ""
    )

    LaunchedEffect(viewModel.counter) {
        if (viewModel.counter == 1) {
            mediaPlayer?.release() // Libera el MediaPlayer anterior si existe
            mediaPlayer = MediaPlayer.create(context, R.raw.game).apply {
                isLooping = true
                start()
            }
        }
    }

    LaunchedEffect(viewModel.timeLeft) {
        if (viewModel.timeLeft == 0) {
            mediaPlayer?.stop()
            mediaPlayer?.release()
            mediaPlayer = null
        }
    }

    Box (
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "High Score",
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(16.dp)
        )
        Text(
            text = "Time left ${viewModel.timeLeft} secs",
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(16.dp)
        )
    }
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = viewModel.counter.toString())
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            viewModel.onButtonClick()
            buttonSize = 120.dp
        },
            enabled = viewModel.isButtonEnabled,
            modifier = Modifier.size(animatedButtonSize)
            ) {
            Text(text = "Press Me")
        }
        if (viewModel.isButtonEnabled == false) {
            Button(onClick = {
                viewModel.onRestartClick()
            }) {
                Text(text = "Restart")
            }
        }
    }
    LaunchedEffect(buttonSize) {
        if (buttonSize > 100.dp) {
            delay(10)
            buttonSize = 100.dp
        }
    }
}