package com.softtech.multigroup.ui.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.softtech.multigroup.ui.route.Screen

@Composable
fun DetailScreen(navController: NavHostController,id:Int,name:String) {
    Column(modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.primary), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {

        Text(
            "Detail Screen",
            modifier = Modifier.clickable {
                navController.navigate(Screen.Profile.getRoute("multi group"))
            },
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.error
        )

        Spacer(modifier = Modifier.size(20.dp))

        Text(
            "id ::: $id ,, name::: $name",
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.error
        )

    }
}