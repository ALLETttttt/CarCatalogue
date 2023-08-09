package com.example.carcatalogue

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.example.carcatalogue.ui.theme.CarCatalogueTheme
import com.example.carcatalogue.ui_components.DrawerMenu
import com.example.carcatalogue.ui_components.MainTopBar

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
            val topBarTitle = remember {
                mutableStateOf("Audi")
            }
            CarCatalogueTheme {
                ModalNavigationDrawer(
                    drawerState = drawerState,
                    drawerContent = {
                        DrawerMenu()
                    }
                ) {
                    Scaffold(
                        topBar = {
                            MainTopBar(title = topBarTitle.value, drawerState)
                        }
                    ) {

                    }
                }
            }
        }
    }
}
