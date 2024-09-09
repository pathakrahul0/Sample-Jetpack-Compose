package com.samplejetpeckcompose.presenter.navigation

sealed class NavigationItem(val route:String){
    object AllUserScreenNavigationItem : NavigationItem("all_user")
    object UserDetailsNavigationItem : NavigationItem(route= "user_details")
}
