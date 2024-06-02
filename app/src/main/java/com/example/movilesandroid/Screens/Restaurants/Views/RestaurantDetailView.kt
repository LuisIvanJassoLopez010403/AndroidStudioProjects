package com.example.movilesandroid.Screens.Restaurants.Views

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.movilesandroid.R
import com.example.movilesandroid.Screens.Restaurants.Viewmodel.RestaurantViewModel

@Composable
fun RestaurantDetailView(viewModel: RestaurantViewModel, navController: NavController, item: String) {
    val restaurants by viewModel.restaurants.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.getRestaurants()
    }

    LazyColumn(modifier = Modifier.fillMaxWidth()) {
        items(restaurants) { restaurant ->
            if (restaurant.name == item) {
                Row {
                    Button(onClick = { navController.popBackStack() }) {
                        Text(text = "Back")
                    }
                    Text(
                        text = item,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                }
                AsyncImage(
                    model = restaurant.imgName,
                    placeholder = painterResource(id = R.drawable.logo),
                    error = painterResource(id = R.drawable.logo),
                    contentDescription = "Restaurant Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(16f / 9f)
                )
            }
        }
    }
}