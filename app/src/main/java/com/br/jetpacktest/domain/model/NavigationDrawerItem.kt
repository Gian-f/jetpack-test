package com.br.jetpacktest.domain.model

import androidx.compose.ui.graphics.vector.ImageVector

data class NavigationDrawerItem(
    val title: String,
    val route: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val badgeCount: Int? = null,
)