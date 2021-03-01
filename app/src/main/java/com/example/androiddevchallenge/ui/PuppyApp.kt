package com.example.androiddevchallenge.ui

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.ui.theme.PuppyAppTheme

@Composable
fun PuppyApp() {
    val navController = rememberNavController()
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "PuppyApp")
                }
            )
        }
    ) { innerPadding ->
        NavHost(navController, startDestination = "list") {
            composable("list") {
                PuppyList(navController, padding = innerPadding)
            }
            composable("profile/{puppyId}") { backstackEntry ->
                val puppyId = backstackEntry.arguments?.getString("puppyId")
                PuppyProfile(navController, puppyId)
            }
        }
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
