package com.example.movilesandroid.examenTercerParcial

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.movilesandroid.R
import com.example.movilesandroid.Score.ExamenSegundoParcial
import com.example.movilesandroid.Score.SoccerScoreViewModel
import com.example.movilesandroid.ui.theme.MovilesAndroidTheme

@Composable
fun WaterScreen(viewModel: WaterViewModel) {
    val glass1 by remember { mutableDoubleStateOf(1.0) }
    val glass2 by remember { mutableDoubleStateOf(0.5) }
    val glass3 by remember { mutableDoubleStateOf(0.255) }

    val total by viewModel.getTotal().observeAsState(0.0)

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "¿Cuánta agua tomó?")
        Row(
            modifier = Modifier.padding(vertical = 20.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.jarraagua),
                contentDescription = "imagen de un litro",
                modifier = Modifier
                    .size(100.dp)
                    .clickable {
                        viewModel.sumWater(1, WaterModel(glass1,glass2,glass3))
                    }
                )
            Text(text = "1 litro")
        }
        Row(
            modifier = Modifier.padding(vertical = 20.dp)
        ){
            Image(
                painter = painterResource(id = R.drawable.botella),
                contentDescription = "imagen de 500 ml",
                modifier = Modifier
                    .size(100.dp)
                    .clickable {
                        viewModel.sumWater(2, WaterModel(glass1,glass2,glass3))
                    }
                )
            Text(text = "500 ml")
        }
        Row(
            modifier = Modifier.padding(vertical = 20.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.vaso),
                contentDescription = "imagen de 255 ml",
                modifier = Modifier
                    .size(100.dp)
                    .clickable {
                        viewModel.sumWater(3, WaterModel(glass1,glass2,glass3))
                    }
                )
            Text(text = "255 ml")
        }
        Text(text = "Total de agua consumida: $total")
        Button(onClick = { viewModel.resetTotal() }) {
            Text(text = "Restablecer")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WaterScreenPreview() {
    MovilesAndroidTheme {
        WaterScreen(viewModel = WaterViewModel())
    }
}