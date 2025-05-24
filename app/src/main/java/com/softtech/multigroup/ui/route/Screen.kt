package com.softtech.multigroup.ui.route

sealed class Screen(val route: String) {
    data object Home : Screen("home_screen")
    data object Detail : Screen("detail_screen")
    data object Profile : Screen("profile_screen")
    data object ProfileEdit : Screen("profile_edit")
}