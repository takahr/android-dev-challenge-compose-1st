package com.example.androiddevchallenge.data

import androidx.annotation.DrawableRes
import java.util.*

data class PuppyItem(
    val name: String,
    val male: Boolean = false,
    val weight: Float = 0f,
    val description: String = "",
    @DrawableRes val thumbnailId: Int = 0,
    @DrawableRes val imageId: Int = 0,
    val id: UUID = UUID.randomUUID()
)
