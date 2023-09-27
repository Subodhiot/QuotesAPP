package com.example.quotesapp.Screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.quotesapp.models.Quote

@Composable
fun QuotesList(data : Array<Quote> , onClick :(quote: Quote)-> Unit) {
    LazyColumn(content = {
        items(data){
            QuotesListitems(Quote = it, onClick)
        }
    })

}