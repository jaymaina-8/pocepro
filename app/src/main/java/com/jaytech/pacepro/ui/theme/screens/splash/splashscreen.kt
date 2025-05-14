package com.jaytech.pacepro.ui.theme.screens.splash

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    LaunchedEffect(Unit) {
        delay(2000) // Show splash for 2 seconds
        val auth = FirebaseAuth.getInstance()
        val route = if (auth.currentUser != null) "home" else "login"
        navController.navigate(route) {
            popUpTo(navController.graph.startDestinationId)
            launchSingleTop = true
        }
    }
    Box(Modifier.fillMaxSize(), Alignment.Center) {
        Text("ShoeTrend", style = MaterialTheme.typography.headlineLarge)
    }
}