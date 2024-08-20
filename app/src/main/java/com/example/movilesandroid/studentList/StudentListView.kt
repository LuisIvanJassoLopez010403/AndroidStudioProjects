package com.example.movilesandroid.studentList

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.movilesandroid.R
import com.example.movilesandroid.ui.theme.MovilesAndroidTheme

@Composable
fun StudentListView(navController: NavController) {
    Column {
        val context = LocalContext.current
        Image(painter = painterResource(id = R.drawable.logo), contentDescription = "imagen de logo")
        Text(text = "Ingenieria de Software 2")
        Text(text = "Juvey Valadez Miramontes")
        Text(text = "Dariel Armando Morua Ramirez")
        Text(text = "Victor Mauricio Hernandez Carreon")
        Text(text = "Ricardo Andres Jimenez Madero")
        Text(text = "Luis Ivan Jasso Lopez")
        Button(onClick = {
        Log.d("tag","click")
        Toast.makeText(context,"Luis Ivan Jasso Lopez he terminado mi primer examen parcial de IDS2",Toast.LENGTH_LONG).show()}) {
            Text(
                text = "Enviar",
                modifier = Modifier
                    .background(Color.Blue))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun StudentListPreview() {
    MovilesAndroidTheme {
        StudentListView(navController = rememberNavController())
    }
}