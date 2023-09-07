package com.br.jetpacktest.ui.routes

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.br.jetpacktest.ui.screens.HomeScreen
import com.br.jetpacktest.ui.screens.LoginScreen
import com.br.jetpacktest.ui.screens.NotificationsScreen
import com.br.jetpacktest.ui.screens.OrdersScreen
import com.br.jetpacktest.ui.screens.ProfileScreen
import com.br.jetpacktest.ui.screens.SettingsScreen


@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination =  Screen.Login.route
    ) {
        composable(Screen.Login.route) {
            LoginScreen(navController)
        }
        composable(Screen.Products.route) {
            HomeScreen(navController)
        }
        composable(Screen.Settings.route) {
            SettingsScreen(navController)
        }
        composable(Screen.Notifications.route) {
            NotificationsScreen(navController)
        }
        composable(Screen.Orders.route) {
            OrdersScreen(navController)
        }
        composable(Screen.Profile.route) {
            ProfileScreen(navController)
        }
    }
}