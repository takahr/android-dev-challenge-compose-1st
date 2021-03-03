/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.data

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.androiddevchallenge.R

class PuppyListViewModel : ViewModel() {
    var puppyItems by mutableStateOf(dummyItems)
        private set

    fun find(puppyId: String?): PuppyItem? {
        return puppyItems.find { item -> (item.id.toString() == puppyId) }
    }
}

val dummyItems = listOf(
    PuppyItem(name = "pochi", thumbnailId = R.drawable.pexels_caio_69372_thumb, imageId = R.drawable.pexels_caio_69372),
    PuppyItem(name = "hachi", thumbnailId = R.drawable.pexels_pixabay_235805_thumb, imageId = R.drawable.pexels_pixabay_235805),
    PuppyItem(name = "john", thumbnailId = R.drawable.pexels_pixabay_33053_thumb, imageId = R.drawable.pexels_pixabay_33053)
)
