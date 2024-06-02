package com.example.movilesandroid.Screens.Restaurants.Views

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.movilesandroid.Screens.Restaurants.Viewmodel.RestaurantViewModel

@Composable
fun Nav() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "RestaurantList") {
        composable("RestaurantList") {
            RestaurantList(viewModel = RestaurantViewModel(), navController)
        }
        composable("detail/{item}") { backStackEntry ->
            val item = backStackEntry.arguments?.getString("item")
            item?.let {
                RestaurantDetailView(viewModel = RestaurantViewModel(), navController, item = it)
            }
        }
    }
}