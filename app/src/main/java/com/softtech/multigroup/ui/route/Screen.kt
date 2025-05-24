package com.softtech.multigroup.ui.route

const val ID_KEY = "id"
const val NAME_KEY = "name"

sealed class Screen(val route: String) {
    data object Home : Screen("home_screen")
    data object Detail : Screen("detail_screen/{$ID_KEY}/{$NAME_KEY}"){
        fun getRoute(id:Int) =  "detail_screen/$id"
        fun getRoute(id:Int,name:String) =  "detail_screen/$id/${name}"
    }
    data object Profile : Screen("profile_screen?=profile={profile}"){
        fun getRoute(profile:String) = "profile_screen?=profile=$profile"
    }
    data object ProfileEdit : Screen("profile_edit")
}