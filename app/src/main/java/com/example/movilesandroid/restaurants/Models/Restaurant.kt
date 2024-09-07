package com.example.movilesandroid.restaurants.Models

data class Restaurant (
    val name: String,
    val imgName: String,
    val schedule: String,
    val phone: String,
    val rating: Float,
    val delivery: String,
    val isFavorite: Boolean,
    val fee: String,
    val webSite: String,
    val latitude: String,
    val longitude: String
)