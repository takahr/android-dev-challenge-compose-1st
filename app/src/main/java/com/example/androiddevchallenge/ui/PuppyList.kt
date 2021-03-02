package com.example.androiddevchallenge.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.data.PuppyItem
import com.example.androiddevchallenge.data.PuppyListViewModel
import com.example.androiddevchallenge.ui.theme.PuppyAppTheme
import com.example.androiddevchallenge.ui.theme.grayTintColor

@Composable
fun ListItem(item: PuppyItem,
             modifier: Modifier = Modifier,
             onClick: (PuppyItem) -> Unit) {
    Row(verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .clickable {
                onClick(item)
            }) {
        Icon(modifier = Modifier
            .width(50f.dp)
            .height(50f.dp),
            imageVector = Icons.Default.InsertPhoto,
            tint = grayTintColor,
            contentDescription = null)
        Text(text = item.name)
    }
}

@Composable
fun PuppyList(
    navController: NavController,
    puppyList: List<PuppyItem>) {
    val scrollState = rememberLazyListState()

    LazyColumn(state = scrollState) {
        items(count = puppyList.size) {
            ListItem(puppyList[it], onClick = { puppyItem ->
                navController.navigate("profile/${puppyItem.id}")
            })
        }
    }
}

@Composable
fun PuppyListScreen(navController: NavController,
                    puppyListViewModel: PuppyListViewModel = viewModel()) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "PuppyApp")
                }
            )
        }
    ) { 
        PuppyList(navController = navController,
            puppyList = puppyListViewModel.puppyItems)
    }
}

@Preview
@Composable
fun ListItemPreview() {
    ListItem(PuppyItem(name = "name"), onClick = {})
}
