package com.example.movilesandroid

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.movilesandroid.ui.theme.MovilesAndroidTheme

@Composable
fun LoginView(){
    Column {
        Image(painter = painterResource(id = R.drawable.carro), contentDescription = "imagen del carro")
        Text( "Usuario", modifier = Modifier
            .background(Color.Green)
            .fillMaxWidth())
        Text(stringResource(id = R.string.password_string))
        Button(onClick = {
            Log.d("tag","click")}) {
            Text(stringResource(id = R.string.login_string))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    MovilesAndroidTheme {
        LoginView()
    }
}