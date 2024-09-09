package com.samplejetpeckcompose.presenter.main

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.samplejetpeckcompose.presenter.navigation.Navigation
import com.samplejetpeckcompose.ui.theme.SampleJetpeckComposeTheme
import dagger.android.support.DaggerAppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            SampleJetpeckComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ScaffoldExample()

                }
            }
        }
    }
}


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ScaffoldExample() {


    // create a scaffold state, set it to close by default
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))

    // Create a coroutine scope. Opening of Drawer
    // and snackbar should happen in background
    // thread without blocking main thread
    val coroutineScope = rememberCoroutineScope()

    // Scaffold Composable
    Scaffold(

        // pass the scaffold state
        scaffoldState = scaffoldState,

        // pass the topbar we created
        topBar = {
            TopBar(
                // When menu is clicked open the
                // drawer in coroutine scope
                onMenuClicked = {
                    coroutineScope.launch {
                        // to close use -> scaffoldState.drawerState.close()
                        scaffoldState.drawerState.open()
                    }
                })
        },

        // pass the bottomBar we created
//        bottomBar = { BottomBar() },

        // Pass the body in
        // content parameter
        content = {
            Navigation()
        },

        // pass the drawer
        drawerContent = {
            Drawer()
        },

//        floatingActionButton = {
//            // Create a floating action button in
//            // floatingActionButton parameter of scaffold
//            FloatingActionButton(
//                onClick = {
//                    // When clicked open Snackbar
//                    coroutineScope.launch {
//                        when (scaffoldState.snackbarHostState.showSnackbar(
//                            // Message In the snackbar
//                            message = "Snack Bar",
//                            actionLabel = "Dismiss"
//                        )) {
//                            SnackbarResult.Dismissed -> {
//                                // do something when
//                                // snack bar is dismissed
//                            }
//
//                            SnackbarResult.ActionPerformed -> {
//                                // when it appears
//                            }
//
//                        }
//                    }
//                }) {
//                // Simple Text inside FAB
//                Text(text = "+")
//
//            }
//        }
    )
}

// A function which will receive a
// callback to trigger to opening the drawer
@Composable
fun TopBar(onMenuClicked: () -> Unit) {
    // TopAppBar Composable
    val navController = rememberNavController()

    TopAppBar(
        // Provide Title
        title = {
            Text(text = "Jetpack Compose", color = Color.Black)
        },
        // Provide the navigation Icon ( Icon on the left to toggle drawer)
//        navigationIcon = {
//            if (navController.previousBackStackEntry != null) {
//                IconButton(onClick = { navController.navigateUp() }) {
//                    Icon(
//                        imageVector = Icons.Filled.ArrowBack,
//                        contentDescription = "Back"
//                    )
//                }
//            } else {
//                Icon(
//                    imageVector = Icons.Default.Menu,
//                    contentDescription = "Menu",
//
//                    // When clicked trigger onClick
//                    // Callback to trigger drawer open
//                    modifier = Modifier.clickable(onClick = onMenuClicked),
//                    tint = Color.Black
//                )
//            }
//        },

        // background color of topAppBar
        backgroundColor = Color.White
    )
}

//@Composable
//fun BottomBar() {
//    // BottomAppBar Composable
//    BottomAppBar(
//        backgroundColor = Color(0xFF0F9D58)
//    ) {
//        Text(text = "Bottom App Bar", color = Color.White)
//    }
//}


@Composable
fun Drawer() {
    // Column Composable
    Column(
        Modifier
            .background(Color.White)
            .fillMaxSize()
    ) {
        // Repeat is a loop which
        // takes count as argument
        repeat(5) { item ->
            Text(text = "Item number $item", modifier = Modifier.padding(8.dp), color = Color.Black)
        }
    }
}

