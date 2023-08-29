package com.br.jetpacktest.ui.routes

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingBag
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(val route: String, val label: String, val icon: ImageVector) {
    object Home : Screen("home", "Home", Icons.Default.Home)
    object Login : Screen("login", "Login", Icons.Default.Person)
    object Settings: Screen("settings", "Settings", Icons.Default.Settings)
    object Notifications: Screen("notifications", "Settings", Icons.Default.Notifications)
    object Orders: Screen("orders", "Orders", Icons.Default.ShoppingBag)
    object Favorites : Screen("favorites", "Favoritos", Icons.Default.Favorite)
    object Profile : Screen("profile", "Perfil", Icons.Default.Face)
    object Email : Screen("email", "Email", Icons.Default.Email)
}