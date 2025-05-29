package com.softtech.multigroup.ui.profileeditscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.softtech.multigroup.ui.route.Screen

@Composable
fun ProfileEditScreen(navController: NavHostController) {

    Column(
        modifier = Modifier.fillMaxSize().background(color = MaterialTheme.colorScheme.scrim),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            "ProfileEditScreen",
            modifier = Modifier,
            color = MaterialTheme.colorScheme.secondary,
            style = MaterialTheme.typography.bodySmall
        )

        Spacer(modifier = Modifier.size(12.dp))

        Text(
            "Navigate back",
            modifier = Modifier.clickable {
                navController.popBackStack()
            },
            color = MaterialTheme.colorScheme.secondary,
            style = MaterialTheme.typography.displayMedium
        )

        Spacer(modifier = Modifier.size(12.dp))


        Text(
            "Navigate to Detial Screen inclusive true",
            modifier = Modifier.clickable {
                navController.popBackStack(Screen.Detail.route,true)
            },
            color = MaterialTheme.colorScheme.secondary,
            style = MaterialTheme.typography.bodySmall
        )


        Spacer(modifier = Modifier.size(12.dp))


        Text(
            "Navigate to Detail PopUp to Profile Screen inclisuve false",
            modifier = Modifier.clickable {
                navController.navigate(Screen.Detail.route) {
                    popUpTo(Screen.Profile.route) { inclusive = false }
                }
            },
            color = MaterialTheme.colorScheme.secondary,
            style = MaterialTheme.typography.bodySmall
        )

        Spacer(modifier = Modifier.size(12.dp))

        Text(
            "Navigate to Detail PopUp to Profile Screen inclisuve true",
            modifier = Modifier.clickable {
                navController.navigate(Screen.Detail.route) {
                    popUpTo(Screen.Profile.route) { inclusive = true }
                }
            },
            color = MaterialTheme.colorScheme.secondary,
            style = MaterialTheme.typography.bodySmall
        )

        Spacer(modifier = Modifier.size(12.dp))

        Button(onClick = {
            navController.previousBackStackEntry
                ?.savedStateHandle
                ?.set("result_key", "data deneme")

            navController.popBackStack()
        }) {
            Text("Geri dön ve veri gönder")
        }
    }
}