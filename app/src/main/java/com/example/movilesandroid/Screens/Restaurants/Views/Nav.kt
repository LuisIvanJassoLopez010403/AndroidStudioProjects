package com.example.movilesandroid.Screens.Restaurants.Views

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.movilesandroid.Screens.Restaurants.Viewmodel.RestaurantViewModel

@Composable
fun Nav() {
    val navController = rememberNavController()
    val restaurantViewModel: RestaurantViewModel = viewModel()
    NavHost(navController = navController, startDestination = "RestaurantList") {
        composable("RestaurantList") {
            RestaurantList(viewModel = restaurantViewModel, navController = navController)
        }
        composable("detail/{item}") { backStackEntry ->
            val item = backStackEntry.arguments?.getString("item")
            item?.let {
                RestaurantDetailView(viewModel = restaurantViewModel, navController = navController, item = it)
            }
        }
    }
}
