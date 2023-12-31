package com.example.carcatalogue.ui_components

import androidx.compose.foundation.background
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.carcatalogue.MainViewModule
import com.example.carcatalogue.ui.theme.mycolor
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainTopBar(
    title: String,
    drawerState: DrawerState,
    mainViewModule: MainViewModule = hiltViewModel(),
    onFavClick: () -> Unit
) {
    val coroutine = rememberCoroutineScope()
    TopAppBar(
        title = {
            Text(
                text = title,
                color = Color.White,
                fontWeight = FontWeight.Bold
                )
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = mycolor),
        navigationIcon = {
            IconButton(onClick = {
                coroutine.launch {
                    drawerState.open()
                }
            }) {
                Icon(imageVector = Icons.Default.Menu, contentDescription = "menu")
            }
        },
        actions = {
            IconButton(onClick = {
                mainViewModule.getFavourites()
                onFavClick()
            }) {
                Icon(imageVector = Icons.Default.Favorite, contentDescription = "favourite")
            }
        }
    )
}