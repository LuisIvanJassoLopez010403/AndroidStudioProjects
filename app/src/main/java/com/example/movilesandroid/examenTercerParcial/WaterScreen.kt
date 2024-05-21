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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.movilesandroid.R

@Composable
fun WaterScreen(viewModel: WaterViewModel) {

    val total by viewModel.getCurrentWaterAmount().observeAsState(0.0)

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
                        viewModel.sumWater(WaterConsumeModel(1.0))
                    }
            )
            Text(text = "1 litro")
        }
        Row(
            modifier = Modifier.padding(vertical = 20.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.botella),
                contentDescription = "imagen de 500 ml",
                modifier = Modifier
                    .size(100.dp)
                    .clickable {
                        viewModel.sumWater(WaterConsumeModel(0.5))
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
                        viewModel.sumWater(WaterConsumeModel(0.255))
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
