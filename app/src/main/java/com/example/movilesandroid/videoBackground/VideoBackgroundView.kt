package com.example.movilesandroid.videoBackground

import android.view.ViewGroup
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import com.example.movilesandroid.R
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.Player.REPEAT_MODE_ALL
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout
import com.google.android.exoplayer2.ui.StyledPlayerView
import com.google.android.exoplayer2.upstream.RawResourceDataSource

@Composable
fun VideoBackgroundView(navController: NavController) {
    val context = LocalContext.current
    val videoUri = RawResourceDataSource.buildRawResourceUri(com.example.movilesandroid.R.raw.videospotifylogin)
    val mediaItem = MediaItem.Builder()
        .setUri(videoUri)
        .build()

    val exoPlayer = remember(context, mediaItem) {
        ExoPlayer.Builder(context)
            .build()
            .also { exoPlayer ->
                exoPlayer.setMediaItem(mediaItem)
                exoPlayer.prepare()
                exoPlayer.playWhenReady = true
                exoPlayer.repeatMode = REPEAT_MODE_ALL
            }
    }
    DisposableEffect(
        AndroidView(
            factory = {
                StyledPlayerView(context).apply {
                    player = exoPlayer
                    useController = false
                    resizeMode = AspectRatioFrameLayout.RESIZE_MODE_ZOOM
                    layoutParams = ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT
                    )
                }
            }
        )
    ) {
        onDispose { exoPlayer.release() }
    }

    Box(
        modifier = Modifier.padding(0.dp,70.dp,0.dp,0.dp),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.spotify),
            contentDescription = "spotify image",
            modifier = Modifier.size(300.dp)
                .align (Alignment.TopCenter)
        )
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(0.dp,0.dp,0.dp,60.dp),
        contentAlignment = Alignment.BottomCenter
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = { /* Acción para Login */ },
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                shape = RectangleShape,
                colors = ButtonDefaults.buttonColors(containerColor = Color.Gray)
            ) {
                Text(text = "LOG IN", color = Color.White)
            }
            Button(
                onClick = { /* Acción para Sign Up */ },
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                shape = RectangleShape,
                colors = ButtonDefaults.buttonColors(containerColor = Color.Green)
            ) {
                Text(text = "SIGN UP", color = Color.White)
            }
        }
    }
}
