package com.example.movilesandroid.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Casino
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Image

val NavBarItems = listOf(
    BarItem(
        title = "First Partial",
        image = Icons.Filled.Casino,
        route = Routes.firstPartialView
    ),
    BarItem(
        title = "Second Partial",
        image = Icons.Filled.CheckCircle,
        route = Routes.secondPartialView
    ),
    BarItem(
        title = "Third Partial",
        image = Icons.Filled.Image,
        route = Routes.thirdPartialView
    ),
)
