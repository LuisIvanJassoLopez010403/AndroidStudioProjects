package com.example.movilesandroid

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext

@Composable
fun OpenURL() {
    Column {
        val website = "https://www.youtube.com/"
        val context = LocalContext.current
        val intent = remember { Intent(Intent.ACTION_VIEW, Uri.parse(website)) }
        
        Button(onClick = { context.startActivity(intent)}) {
            
        }
    }
}