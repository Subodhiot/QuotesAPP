package com.example.quotesapp.Screens

import android.service.autofill.OnClickAction
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.node.ModifierNodeElement
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quotesapp.models.Quote
import kotlin.text.Typography.quote

@Composable
fun QuotesListitems(Quote : Quote,onClick: (quote :Quote )-> Unit){
    Card(
//        elevation = 4.dp ,
        modifier = Modifier.padding(8.dp)
            .clickable { onClick(Quote) }
            .padding(8.dp)

    ) {
        Row (
            modifier = Modifier.padding(16.dp)
        ){

            Image(imageVector = Icons.Filled.AccountCircle,
                colorFilter = ColorFilter.tint(Color.White),
                alignment = Alignment.TopStart,

                contentDescription = "Quotes" ,
                modifier = Modifier
                    .size(40.dp)
                    .rotate(180F)
                    .background(Color.Black))

            Spacer(modifier = Modifier.padding(4.dp))
            Column (modifier = Modifier.weight(1f)){
                Text(text = Quote.text,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(0.dp,0.dp,0.dp,1.dp)
                    )
                Box(modifier = Modifier
                    .background(Color.LightGray)
                    .fillMaxWidth(.4f)
                    .height(1.dp)
                )
                Text(text = Quote.author,
                    style = MaterialTheme.typography.bodySmall,
                    fontWeight = FontWeight.Thin,
                    modifier = Modifier.padding(top = 4.dp)
                )


            }

        }

    }
}


