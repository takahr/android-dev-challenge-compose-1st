package com.example.androiddevchallenge.ui

import androidx.compose.animation.*
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.InsertPhoto
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
                modifier = modifier)
        } else {
            Icon(
                imageVector = Icons.Default.InsertPhoto,
                tint = grayTintColor,
                contentDescription = null,
                modifier = modifier)
        }
        Column(modifier = Modifier.padding(all = 10f.dp)) {
            Text(text = puppyItem.name)
            Spacer(Modifier.height(600f.dp))
        }
    }
}

@ExperimentalAnimationApi
@Composable
fun PuppyProfileScreen(navController: NavController,
                       puppyId: String?,
                       puppyListViewModel: PuppyListViewModel = viewModel()) {

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
                animationSpec = tween(durationMillis = 400, easing = LinearOutSlowInEasing))
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
