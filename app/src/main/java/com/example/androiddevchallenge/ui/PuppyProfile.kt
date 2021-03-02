package com.example.androiddevchallenge.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.InsertPhoto
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.androiddevchallenge.data.PuppyItem
import com.example.androiddevchallenge.data.PuppyListViewModel
import com.example.androiddevchallenge.ui.theme.grayTintColor

@Composable
fun PuppyProfile(puppyItem: PuppyItem) {
    Column {
        Icon(modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1.2f),
            imageVector = Icons.Default.InsertPhoto,
            tint = grayTintColor,
            contentDescription = null)
        Column(modifier = Modifier.padding(all = 10f.dp)) {
            Text(text = puppyItem?.name.toString())
        }
    }
}

@Composable
fun PuppyProfileScreen(navController: NavController,
                       puppyId: String?,
                       puppyListViewModel: PuppyListViewModel = viewModel()) {

    val puppyItem: PuppyItem? = puppyListViewModel.find(puppyId)

    Surface {
        Box {
            PuppyProfile(puppyItem = puppyItem!!)
            TopAppBar(
                title = {
                    Text(text = "PuppyApp")
                },
                backgroundColor = Color.Transparent,
                elevation = 0f.dp
            )
        }
    }
}

@Preview
@Composable
fun PuppyProfilePreview() {
    PuppyProfile(PuppyItem(name = "name"))
}
