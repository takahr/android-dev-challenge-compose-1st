package com.example.androiddevchallenge.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.InsertPhoto
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.PuppyItem
import com.example.androiddevchallenge.ui.theme.grayTintColor

@Composable
fun ListItem(index: Int) {
    Row() {
        Icon(imageVector = Icons.Default.InsertPhoto,
            tint = grayTintColor,
            contentDescription = null)
        Text(text = "aaa")
    }
}

@Composable
fun PuppyList(padding: PaddingValues = PaddingValues(all = 0f.dp)) {
    val scrollState = rememberLazyListState()

    LazyColumn(state = scrollState,
        contentPadding = padding) {
        items(count = 10) {
            ListItem(it)
        }
    }
}

@Preview
@Composable
fun ListItemPreview() {
    ListItem(1)
}

@Preview
@Composable
fun PuppyListPreview() {
    PuppyList()
}
