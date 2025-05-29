package com.softtech.multigroup.ui.navhost

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
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
        composable(
            Screen.Home.route
        ) {
            HomeScreen(navController)
        }

        composable(
            Screen.Detail.route,
            arguments = listOf(
                navArgument(ID_KEY) {
                    type = NavType.IntType
                },
                navArgument(NAME_KEY) {
                    type = NavType.StringType
                }
            ),
            enterTransition = {
                fadeIn(animationSpec = tween(500))
            },

            exitTransition = {
                fadeOut(animationSpec = tween(500))

            }

        ) {
            val id = it.arguments?.getInt(ID_KEY) ?: 0
            val name = it.arguments?.getString(NAME_KEY) ?: ""
            DetailScreen(navController, id, name)
        }

        composable(
            Screen.Profile.route,
            arguments = listOf(
                navArgument("profile") {
                    type = NavType.StringType
                    nullable = true
                }
            ),
            enterTransition = {
                slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.Left,
                    animationSpec = tween(700)
                )
            },
            exitTransition = {
                slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.Right,
                    animationSpec = tween(700)
                )
            }
        ) {
            val name = it.arguments?.getString("profile")
            ProfileScreen(navController, name)
        }

        composable(
            Screen.ProfileEdit.route,
            enterTransition = {
                slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.Up,
                    animationSpec = tween(500)
                )
            },
            exitTransition = {
                slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.Up,
                    animationSpec = tween(500)
                )
            }
        ) {
            ProfileEditScreen(navController)
        }
    }
}