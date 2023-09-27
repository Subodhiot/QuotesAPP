package com.example.quotesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import com.example.quotesapp.Screens.QuotesDetails
import com.example.quotesapp.Screens.QuotesList
import com.example.quotesapp.Screens.QuotesListScreen
import com.example.quotesapp.models.DataManager
import com.example.quotesapp.models.Quote
import com.example.quotesapp.ui.theme.QuotesAPPTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CoroutineScope(Dispatchers.IO).launch {
            delay(10000)
            DataManager.loadAssetfromFile(this@MainActivity)
        }


        setContent {
            // A surface container using the 'background' color from the them

            App()
        }
    }
@Composable
fun App(){
    if(DataManager.isDataLoaded.value){
        if(DataManager.currPage.value == Pages.Listing){
            QuotesListScreen(data = DataManager.data) {
                DataManager.switchPage(it)
            }
        }
        else{
            DataManager.currQuote?.let { QuotesDetails(Quotes =  it) }
        }
       

    }
    else{
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize(1f)


        )
        {
            Text(text = "Loading ....",
                style = MaterialTheme.typography.displayLarge
            )
        }
    }
}
//    @Composable
//    fun Greeting(name: String, modifier: Modifier = Modifier) {
//        Text(
//            text = "Hello $name!",
//            modifier = modifier
//        )
//    }
//
//    @Preview(showBackground = true)
//    @Composable
//    fun GreetingPreview() {
//        QuotesAPPTheme {
//            Greeting("Android")
//        }
//    }
//}
}
enum class Pages{
    Listing,
    Detail
}