package com.softtech.multigroup.ui.navhost

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.softtech.multigroup.ui.detail.DetailScreen
import com.softtech.multigroup.ui.home.HomeScreen
import com.softtech.multigroup.ui.route.Screen

@Composable
fun SetUpNavHost(navController: NavHostController){
    NavHost(
        navController,
        startDestination = Screen.Home.route
    )
    {
        composable(Screen.Home.route){
            HomeScreen(navController)
        }

        composable(Screen.Detail.route){
            DetailScreen(navController)
        }
    }
}