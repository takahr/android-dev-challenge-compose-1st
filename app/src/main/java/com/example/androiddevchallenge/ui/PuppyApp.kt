package com.example.androiddevchallenge.ui

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.ui.theme.PuppyAppTheme

@ExperimentalAnimationApi
@Composable
fun PuppyApp() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "list") {
        composable("list") {
            PuppyListScreen(navController)
        }
        composable("profile/{puppyId}") { backstackEntry ->
            val puppyId = backstackEntry.arguments?.getString("puppyId")
            PuppyProfileScreen(navController, puppyId)
        }
    }
}
