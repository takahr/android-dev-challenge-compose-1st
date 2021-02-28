package com.example.androiddevchallenge

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.androiddevchallenge.ui.theme.PuppyAppTheme

@Composable
fun PuppyApp() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "PuppyApp")
                }
            )
        }
    ) { innerPadding ->
        BodyContent(Modifier.padding(innerPadding))
    }
}

@Composable
fun BodyContent(modifier: Modifier = Modifier) {
    PuppyList()
}

@Preview
@Composable
fun PuppyAppPreview() {
    PuppyAppTheme {
        PuppyApp()
    }
}
