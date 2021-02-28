package com.example.androiddevchallenge.ui

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
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
        PuppyList(padding = innerPadding)
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    PuppyAppTheme {
        PuppyApp()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    PuppyAppTheme(darkTheme = true) {
        PuppyApp()
    }
}
