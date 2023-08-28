package com.br.jetpacktest.ui.routes

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.br.jetpacktest.ui.screens.Home
import com.br.jetpacktest.ui.screens.Login
import com.br.jetpacktest.ui.screens.SettingsScreen


@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination =  Screen.Login.route
    ) {
        composable(Screen.Login.route) {
            Login(navController)
        }
        composable(Screen.Home.route) {
            Home(navController)
        }
        composable(Screen.Settings.route) {
            SettingsScreen(navController)
        }
    }
}