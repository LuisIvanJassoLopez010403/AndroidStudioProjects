package com.example.movilesandroid.RockPaperScissor

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.movilesandroid.R
import com.example.movilesandroid.ui.theme.MovilesAndroidTheme

@Composable
fun RockPaperScissorScreen(viewModel: RockPaperScissorViewModel) {
    var randomImage by remember { mutableStateOf(R.drawable.reveal) }
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Image(
            painter = painterResource(id = randomImage),
            contentDescription = "Random Image"
        )
        Button(onClick = {
            randomImage = viewModel.getRandomImage()
        }) {
            Text(text = "Change image")
        }
    }
}
@Preview(showBackground = true)
@Composable
fun RockPaperScissorPreview() {
    MovilesAndroidTheme {
        RockPaperScissorScreen(viewModel = RockPaperScissorViewModel())
    }
}
