package com.example.movilesandroid.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Call

val NavBarItems = listOf(
    BarItem(
        title = "First Partial",
        image = Icons.Filled.AccountBox,
        route = Routes.firstPartialView
    ),
    BarItem(
        title = "Second Partial",
        image = Icons.Filled.AddCircle,
        route = Routes.secondPartialView
    ),
    BarItem(
        title = "Third Partial",
        image = Icons.Filled.Call,
        route = Routes.thirdPartialView
    ),
)
