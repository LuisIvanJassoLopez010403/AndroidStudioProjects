package com.example.movilesandroid.buttonList

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.movilesandroid.ui.theme.MovilesAndroidTheme

@Composable
fun ButtonListView(navController: NavController){
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
    ) {
        val context = LocalContext.current
        Button(onClick =
        {Log.d("tag","click")
        Toast.makeText(context,"Boton 1",Toast.LENGTH_LONG).show()}) {
            Text(
                text = "Boton 1",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .background(Color.Green))
        }
        Button(onClick =
        {Log.d("tag","click")}) {
            Text(text = "Boton 2")
        }
        Button(onClick =
        {Log.d("tag","click")}) {
            Text(text = "Boton 3")
        }
        Button(onClick =
        {Log.d("tag","click")}) {
            Text(text = "Boton 4")
        }
        Button(onClick =
        {Log.d("tag","click")}) {
            Text(text = "Boton 5")
        }
        Button(onClick =
        {Log.d("tag","click")}) {
            Text(text = "Boton 6")
        }
        Button(onClick =
        {Log.d("tag","click")}) {
            Text(text = "Boton 7")
        }
        Button(onClick =
        {Log.d("tag","click")}) {
            Text(text = "Boton 8")
        }
        Button(onClick =
        {Log.d("tag","click")}) {
            Text(text = "Boton 9")
        }
        Button(onClick =
        {Log.d("tag","click")}) {
            Text(text = "Boton 10")
        }
        Button(onClick =
        {Log.d("tag","click")}) {
            Text(text = "Boton 11")
        }
        Button(onClick =
        {Log.d("tag","click")}) {
            Text(text = "Boton 12")
        }
        Button(onClick =
        {Log.d("tag","click")}) {
            Text(text = "Boton 13")
        }
        Button(onClick =
        {Log.d("tag","click")}) {
            Text(text = "Boton 14")
        }
        Button(onClick =
        {Log.d("tag","click")}) {
            Text(text = "Boton 15")
        }
    }
}
@Preview(showBackground = true)
@Composable
fun ButtonListPreview() {
    MovilesAndroidTheme {
        ButtonListView(navController = rememberNavController())
    }
}