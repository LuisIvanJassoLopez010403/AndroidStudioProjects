package com.example.movilesandroid.Screens.Restaurants.Views

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.movilesandroid.R
import com.example.movilesandroid.Screens.Restaurants.Viewmodel.RestaurantViewModel

@Composable
fun RestaurantList(viewModel: RestaurantViewModel,navController: NavHostController) {
    val restaurants by viewModel.restaurants.collectAsState()

    LazyColumn (modifier = Modifier.fillMaxWidth()) {
        items(restaurants) {
            restaurant ->
            Box (contentAlignment = Alignment.TopEnd) {
                AsyncImage(
                    model = restaurant.imgName,
                    placeholder = painterResource(id = R.drawable.logo),
                    error = painterResource(id = R.drawable.logo),
                    contentDescription = "Restaurant Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 5.dp)
                        .aspectRatio(16f / 9f)
                        .clickable {
                            navController.navigate("detail/${restaurant.name}")
                        }
                )
                IconToggleButton(
                    checked = restaurant.isFavorite,
                    onCheckedChange = {
                        restaurant.isFavorite
                    }
                ) {
                    Icon(
                        modifier = Modifier.graphicsLayer {
                            scaleX = 1.3f
                            scaleY = 1.3f
                        },
                        imageVector = if (restaurant.isFavorite) {
                            Icons.Filled.Favorite
                        } else {
                            Icons.Default.FavoriteBorder
                        },
                        contentDescription = null
                    )
                }
            }
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween) {
                    Text(text = restaurant.name, fontWeight = FontWeight.Bold)
                    Text(text = "${restaurant.rating}", modifier = Modifier.background(color = Color.LightGray))
            }
            Row (
                modifier = Modifier
                    .padding(10.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.id_card),
                    contentDescription = "Icon Description",
                    tint = Color(0xFFD3A13C),
                    modifier = Modifier.size(24.dp)
                )
                Text(text = " MX ${restaurant.fee} Delivery fee · ${restaurant.delivery}")
            }
        }
    }
    DisposableEffect(Unit) {
        viewModel.getRestaurants()
        onDispose {}
    }
}