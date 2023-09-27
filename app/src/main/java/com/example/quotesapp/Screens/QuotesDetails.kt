package com.example.quotesapp.Screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quotesapp.models.DataManager
import com.example.quotesapp.models.Quote

@Composable

fun QuotesDetails(Quotes : Quote){
    BackHandler() {
        DataManager.switchPage(null)
    }
    Box (
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize(1f)
            .background(
                Brush.linearGradient(
                    colors = listOf(

                        Color.Cyan,
                        Color.LightGray

                    )
                )
            )
    ){
        Card(
            modifier = Modifier.padding(32.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
//                    .align(Alignment.Center)

                    .padding(16.dp,24.dp)
            ) {
                Image(imageVector = Icons.Filled.AccountCircle, contentDescription ="Quotes",
                    modifier = Modifier
                        .size(80.dp)
                        .rotate(180f)
                )
                Text(text = Quotes.text,
                    fontFamily = FontFamily.Monospace,
                    style = MaterialTheme.typography.displaySmall

                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = Quotes.author,
                    fontFamily = FontFamily.Default,
                    style = MaterialTheme.typography.bodySmall,
                    fontSize = 16.sp
                )

            }
        }
    }
}