package com.example.androiddevchallenge.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.InsertPhoto
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.androiddevchallenge.data.PuppyItem
import com.example.androiddevchallenge.data.PuppyListViewModel
import com.example.androiddevchallenge.ui.theme.grayTintColor

@Composable
fun PuppyProfile(navController: NavController,
                 puppyId: String?,
                 puppyListViewModel: PuppyListViewModel = viewModel(),
                 padding: PaddingValues = PaddingValues(all = 0f.dp)) {
    val puppyItem: PuppyItem? = puppyListViewModel.find(puppyId)

    Column(modifier = Modifier.padding(padding)) {
        Icon(modifier = Modifier.fillMaxWidth().aspectRatio(1.2f),
            imageVector = Icons.Default.InsertPhoto,
            tint = grayTintColor,
            contentDescription = null)
        Column(modifier = Modifier.padding(all = 10f.dp)) {
            Text(text = puppyItem?.name.toString())
        }
    }
}
