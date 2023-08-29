package com.br.jetpacktest.data.model

import androidx.compose.ui.graphics.vector.ImageVector

data class NavigationDrawerItemData(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val badgeCount: Int? = null,
)