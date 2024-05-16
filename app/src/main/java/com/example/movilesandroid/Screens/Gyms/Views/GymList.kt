package com.example.movilesandroid.Screens.Gyms.Views

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.movilesandroid.R
import com.example.movilesandroid.Screens.Gyms.Viewmodel.GymViewModel

@Composable
fun GymList(viewModel: GymViewModel) {
    val gyms by viewModel.gyms.collectAsState()
    LazyColumn{
        items(gyms) {
            gym ->
            Text(text = gym.name)
            Text(text = gym.latitude)
            Text(text = gym.longitude)
            AsyncImage(
                model = gym.imageURL,
                placeholder = painterResource(id = R.drawable.logo),
                error = painterResource(id = R.drawable.logo),
                contentDescription = "Gym Image",
                modifier = Modifier
                    .size(350.dp)
                )
        }
    }
    DisposableEffect(Unit) {
        viewModel.getGyms()
        onDispose {}
    }
}
