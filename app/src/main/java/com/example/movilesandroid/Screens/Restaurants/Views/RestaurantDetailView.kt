package com.example.movilesandroid.Screens.Restaurants.Views

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.browser.customtabs.CustomTabsIntent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.movilesandroid.R
import com.example.movilesandroid.Screens.Restaurants.Viewmodel.RestaurantViewModel
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
fun RestaurantDetailView(viewModel: RestaurantViewModel, navController: NavController, item: String) {
    val restaurants by viewModel.restaurants.collectAsState()

    val context = LocalContext.current

    // Asegúrate de que los datos se cargan solo una vez
    LaunchedEffect(Unit) {
        if (restaurants.isEmpty()) {
            viewModel.getRestaurants()
        }
    }
    LazyColumn(modifier = Modifier.fillMaxWidth()) {
        items(restaurants) { restaurant ->
            if (restaurant.name == item) {
                Column {
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
                    val latLng = LatLng(restaurant.latitude.toDouble(), restaurant.longitude.toDouble())
                    val cameraPositionState = rememberCameraPositionState {
                        position = com.google.android.gms.maps.model.CameraPosition.fromLatLngZoom(latLng, 15f)
                    }

                    GoogleMap(
                        modifier = Modifier
                            .fillMaxWidth()
                            .aspectRatio(16f / 9f),
                        cameraPositionState = cameraPositionState
                    ) {
                        Marker(
                            state = com.google.maps.android.compose.MarkerState(position = latLng),
                            title = restaurant.name,
                            snippet = "Restaurant Location"
                        )
                    }
                    // Botón para hacer la llamada
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(
                        onClick = {
                            val intent = Intent(Intent.ACTION_DIAL).apply {
                                data = Uri.parse("tel:+52${restaurant.phone}")
                            }
                            context.startActivity(intent)
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        Text(text = "Call Restaurant")
                    }
                    // Botón para visitar el sitio web
                    val intent = remember {Intent(Intent.ACTION_VIEW, Uri.parse(restaurant.website))}
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(
                        onClick = {
                            context.startActivity(intent)
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        Text(text = "Sitio Web")
                    }
                }
            }
        }
    }
}
