package com.example.movilesandroid.Screens.Restaurants.Views

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.movilesandroid.R
import com.example.movilesandroid.Screens.Restaurants.Viewmodel.RestaurantViewModel

@Composable
fun RestaurantList(viewModel: RestaurantViewModel) {
    val restaurants by viewModel.restaurants.collectAsState()
    LazyColumn (modifier = Modifier.fillMaxWidth()) {
        items(restaurants) {
            restaurant ->
            AsyncImage(
                model = restaurant.imgName,
                placeholder = painterResource(id = R.drawable.logo),
                error = painterResource(id = R.drawable.logo),
                contentDescription = "Restaurant Image",
                modifier = Modifier
                    .fillMaxWidth()
            )
            Row {
                Text(text = restaurant.name, fontWeight = FontWeight.Bold)
                Text(text = restaurant.phone)
            }

            Text(text = "MX ${restaurant.fee} Delivery fee 35-45 min")

        }
    }
    DisposableEffect(Unit) {
        viewModel.getRestaurants()
        onDispose {}
    }
}