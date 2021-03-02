package com.example.androiddevchallenge.data

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.androiddevchallenge.R

class PuppyListViewModel : ViewModel() {
    var puppyItems by mutableStateOf(dummyItems)
        private set

    fun find(puppyId: String?) : PuppyItem? {
        return puppyItems.find { item -> (item.id.toString() == puppyId) }
    }
}

val dummyItems = listOf(
    PuppyItem(name = "pochi", thumbnailId = R.drawable.pexels_caio_69372_thumb, imageId = R.drawable.pexels_caio_69372),
    PuppyItem(name = "hachi", thumbnailId = R.drawable.pexels_pixabay_235805_thumb, imageId = R.drawable.pexels_pixabay_235805),
    PuppyItem(name = "john", thumbnailId = R.drawable.pexels_pixabay_33053_thumb, imageId = R.drawable.pexels_pixabay_33053)
)

