package com.softtech.multigroup.ui.navhost

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.softtech.multigroup.ui.detail.DetailScreen
import com.softtech.multigroup.ui.home.HomeScreen
import com.softtech.multigroup.ui.profileeditscreen.ProfileEditScreen
import com.softtech.multigroup.ui.profilescreen.ProfileScreen
import com.softtech.multigroup.ui.route.ID_KEY
import com.softtech.multigroup.ui.route.NAME_KEY
import com.softtech.multigroup.ui.route.Screen

@Composable
fun SetUpNavHost(navController: NavHostController) {
    NavHost(
        navController,
        startDestination = Screen.Home.route
    )
    {
        composable(Screen.Home.route) {
            HomeScreen(navController)
        }

        composable(Screen.Detail.route,
            arguments = listOf(
                navArgument(ID_KEY){
                    type = NavType.IntType
                },
                navArgument(NAME_KEY){
                    type = NavType.StringType
                }
            )
        ) {
            val id = it.arguments?.getInt(ID_KEY) ?: 0
            val name = it.arguments?.getString(NAME_KEY) ?: ""
            DetailScreen(navController,id,name)
        }

        composable(Screen.Profile.route,
            arguments = listOf(
                navArgument("profile"){
                    type = NavType.StringType
                    nullable = true
                }
            )
        ) {
            val name = it. arguments?.getString("profile")
            ProfileScreen(navController,name)
        }

        composable(Screen.ProfileEdit.route) {
            ProfileEditScreen(navController)
        }
    }
}