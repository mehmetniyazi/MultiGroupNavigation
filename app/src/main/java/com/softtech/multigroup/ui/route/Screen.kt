package com.softtech.multigroup.ui.route

sealed class Screen(val route: String) {
    data object Home : Screen("home_screen")
    data object Detail : Screen("detail_screen")
}