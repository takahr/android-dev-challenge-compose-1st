package com.example.androiddevchallenge.data

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class PuppyListViewModel : ViewModel() {
    var puppyItems by mutableStateOf(dummyItems())
        private set
}

fun dummyItems() : List<PuppyItem> {
    return listOf(
        PuppyItem(name = "pochi"),
        PuppyItem(name = "hachi"),
        PuppyItem(name = "john")
    )
}
