package com.example.androiddevchallenge.data

import androidx.annotation.DrawableRes
import java.util.*

data class PuppyItem(
    val name: String,
    val male: Boolean,
    val weight: Float,
    val description: String,
    @DrawableRes val thumbnailId: Int,
    @DrawableRes val imageId: Int,
    val id: UUID = UUID.randomUUID()
)
