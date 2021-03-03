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
package com.example.androiddevchallenge.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.InsertPhoto
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.data.PuppyItem
import com.example.androiddevchallenge.data.PuppyListViewModel
import com.example.androiddevchallenge.ui.theme.grayTintColor

@Composable
fun PuppyProfile(puppyItem: PuppyItem) {
    Column {
        val modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1.2f)
        if (puppyItem.imageId > 0) {
            Image(
                painter = painterResource(id = puppyItem.imageId),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = modifier
            )
        } else {
            Icon(
                imageVector = Icons.Default.InsertPhoto,
                tint = grayTintColor,
                contentDescription = null,
                modifier = modifier
            )
        }
        Column(modifier = Modifier.padding(all = 10f.dp)) {
            Text(text = puppyItem.name, fontSize = 18f.sp)
            Spacer(Modifier.height(600f.dp))
        }
    }
}

@ExperimentalAnimationApi
@Composable
fun PuppyProfileScreen(
    navController: NavController,
    puppyId: String?,
    puppyListViewModel: PuppyListViewModel = viewModel()
) {

    val puppyItem: PuppyItem? = puppyListViewModel.find(puppyId)
    val scrollState = rememberScrollState()
    var visibility by remember { mutableStateOf(false) }
    Surface {
        LaunchedEffect("PuppyProfile") {
            visibility = true
        }

        AnimatedVisibility(
            visible = visibility,
            enter = slideInHorizontally(
                initialOffsetX = { it / 2 },
                animationSpec = tween(durationMillis = 400, easing = LinearOutSlowInEasing)
            )
        ) {
            Box(Modifier.verticalScroll(scrollState)) {
                PuppyProfile(puppyItem = puppyItem!!)
                TopAppBar(
                    title = {
                        Text(text = puppyItem.name)
                    },
                    backgroundColor = Color.Transparent,
                    elevation = 0f.dp,
                    navigationIcon = {
                        IconButton(onClick = { navController.navigateUp() }) {
                            Icon(
                                imageVector = Icons.Rounded.ArrowBack,
                                contentDescription = stringResource(R.string.label_back)
                            )
                        }
                    }
                )
            }
        }
    }
}

@Preview
@Composable
fun PuppyProfilePreview() {
    PuppyProfile(PuppyItem(name = "name"))
}
