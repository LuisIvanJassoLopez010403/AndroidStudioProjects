package com.example.movilesandroid.score

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.movilesandroid.R
import com.example.movilesandroid.ui.theme.MovilesAndroidTheme

@Composable
fun ScoreView(viewModel: SoccerScoreViewModel,navController: NavController) {
    val localScoreResult by viewModel.getLocalScore().observeAsState(0)
    val visitScoreResult by viewModel.getVisitScore().observeAsState(0)

    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Marcador Oficial",
            fontSize = 40.sp,
            modifier = Modifier.padding(bottom = 15.dp)
        )
        Row (
            modifier = Modifier.padding(bottom = 15.dp)
        ) {
            Image(painter = painterResource(id = R.drawable.chivas),
                contentDescription = "imagen de logo 1",
                modifier = Modifier
                    .size(100.dp)
                    .clickable {
                        Log.d("sumar", "local")
                        viewModel.incrementLocalScore(SoccerScoreLocalModel(localScoreResult))
                    }
            )
            Text(
                text = "${localScoreResult}",
                fontSize = 40.sp,
                modifier = Modifier.padding(horizontal = 20.dp)
            )
            Text(
                text = "${visitScoreResult}",
                fontSize = 40.sp,
                modifier = Modifier.padding(horizontal = 20.dp)
            )
            Image(painter = painterResource(id = R.drawable.america),
                contentDescription = "imagen de logo 2",
                modifier = Modifier
                    .size(100.dp)
                    .clickable {
                        Log.d("sumar", "local")
                        viewModel.incrementVisitScore(SoccerScoreVisitModel(visitScoreResult))
                    }
            ) 
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ScoreView() {
    MovilesAndroidTheme {
        ScoreView(viewModel = SoccerScoreViewModel(), navController = rememberNavController())
    }
}
