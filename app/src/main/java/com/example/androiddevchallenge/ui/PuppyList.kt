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

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.InsertPhoto
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.data.PuppyItem
import com.example.androiddevchallenge.data.PuppyListViewModel
import com.example.androiddevchallenge.ui.theme.grayTintColor

@Composable
fun ListItem(
    puppyItem: PuppyItem,
    modifier: Modifier = Modifier,
    onClick: (PuppyItem) -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .clickable {
                onClick(puppyItem)
            }
    ) {
        val thumbModifier = Modifier
            .width(120f.dp)
            .height(120f.dp)
        if (puppyItem.thumbnailId > 0) {
            Image(
                painter = painterResource(id = puppyItem.thumbnailId),
                contentDescription = null,
                modifier = thumbModifier
            )
        } else {
            Icon(
                imageVector = Icons.Default.InsertPhoto,
                tint = grayTintColor,
                contentDescription = null,
                modifier = thumbModifier
            )
        }
        Spacer(modifier = Modifier.width(10f.dp))
        Text(text = puppyItem.name, fontSize = 18f.sp)
    }
}

@Composable
fun PuppyList(
    navController: NavController,
    puppyList: List<PuppyItem>
) {
    val scrollState = rememberLazyListState()

    LazyColumn(state = scrollState) {
        items(count = puppyList.size) {
            ListItem(
                puppyList[it],
                onClick = { puppyItem ->
                    navController.navigate("profile/${puppyItem.id}")
                }
            )
        }
    }
}

@Composable
fun PuppyListScreen(
    navController: NavController,
    puppyListViewModel: PuppyListViewModel = viewModel()
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(R.string.app_name))
                }
            )
        }
    ) {
        PuppyList(
            navController = navController,
            puppyList = puppyListViewModel.puppyItems
        )
    }
}

@Preview
@Composable
fun ListItemPreview() {
    ListItem(PuppyItem(name = "name"), onClick = {})
}
