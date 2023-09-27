package com.example.quotesapp.models

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import com.example.quotesapp.Pages
import com.google.gson.Gson
import java.nio.charset.Charset
import java.security.AccessControlContext

object DataManager {
    var data = emptyArray<Quote>()
    var currPage = mutableStateOf(Pages.Listing)
    var currQuote : Quote? = null
    var isDataLoaded = mutableStateOf(false)

    fun loadAssetfromFile(context: Context){
        val inputStream = context.assets.open("quotes.json")
        val size : Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()

        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        data = gson.fromJson(json, Array<Quote>::class.java)
        isDataLoaded.value = true
    }

    fun switchPage(quote: Quote?)
    {
        if(currPage.value == Pages.Listing ){
            currQuote = quote
            currPage.value = Pages.Detail
        }
        else{
            currPage.value = Pages.Listing
        }
    }

}