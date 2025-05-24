package com.softtech.multigroup.ui.profilescreen

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
fun ProfileScreen(navHostController: NavHostController,profile:String?) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.error),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "Profile Screen",
            modifier = Modifier.clickable {
                navHostController.navigate(Screen.ProfileEdit.route)
            },
            color = MaterialTheme.colorScheme.scrim,
            style = MaterialTheme.typography.bodySmall
        )

        Spacer(modifier = Modifier.size(24.dp))

        Text(
            "profilearg == $profile",
            color = MaterialTheme.colorScheme.scrim,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

