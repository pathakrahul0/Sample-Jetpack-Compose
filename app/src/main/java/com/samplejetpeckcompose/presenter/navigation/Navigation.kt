package com.samplejetpeckcompose.presenter.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.samplejetpeckcompose.domain.entity.user.User
import com.samplejetpeckcompose.presenter.user.AllUserScreen
import com.samplejetpeckcompose.presenter.user.UserDetailsScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = NavigationItem.AllUserScreenNavigationItem.route
    ) {
        composable(NavigationItem.UserDetailsNavigationItem.route) {
            val user = navController.previousBackStackEntry?.savedStateHandle?.get<User>("user")
            if (user != null)
                UserDetailsScreen(user = user)
        }
        composable(NavigationItem.AllUserScreenNavigationItem.route) {
            AllUserScreen(navController = navController)
        }

    }


}