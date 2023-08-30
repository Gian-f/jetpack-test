package com.br.jetpacktest.data.dummy

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBalance
import androidx.compose.material.icons.filled.Business
import androidx.compose.material.icons.filled.ContactSupport
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.Help
import androidx.compose.material.icons.filled.LocalOffer
import androidx.compose.material.icons.filled.Newspaper
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingBag
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.AccountBalance
import androidx.compose.material.icons.outlined.Business
import androidx.compose.material.icons.outlined.ContactSupport
import androidx.compose.material.icons.outlined.CreditCard
import androidx.compose.material.icons.outlined.Help
import androidx.compose.material.icons.outlined.LocalOffer
import androidx.compose.material.icons.outlined.Newspaper
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.ShoppingBag
import androidx.compose.material.icons.outlined.ShoppingCart
import com.br.jetpacktest.domain.model.NavigationDrawerItemData

object NavigationDrawerData {
    val items = listOf(
        NavigationDrawerItemData(
            title = "Produtos",
            selectedIcon = Icons.Filled.ShoppingCart,
            unselectedIcon = Icons.Outlined.ShoppingCart,
        ),
        NavigationDrawerItemData(
            title = "Ofertas",
            selectedIcon = Icons.Filled.LocalOffer,
            unselectedIcon = Icons.Outlined.LocalOffer,
        ),
        NavigationDrawerItemData(
            title = "Novidades",
            selectedIcon = Icons.Filled.Newspaper,
            unselectedIcon = Icons.Outlined.Newspaper,
            badgeCount = 10
        ),
        NavigationDrawerItemData(
            title = "Cliente",
            selectedIcon = Icons.Filled.Person,
            unselectedIcon = Icons.Outlined.Person,
        ),
        NavigationDrawerItemData(
            title = "Pedidos",
            selectedIcon = Icons.Filled.ShoppingBag,
            unselectedIcon = Icons.Outlined.ShoppingBag,
        ),
        NavigationDrawerItemData(
            title = "Títulos",
            selectedIcon = Icons.Filled.AccountBalance,
            unselectedIcon = Icons.Outlined.AccountBalance,
        ),
        NavigationDrawerItemData(
            title = "Meus cartões",
            selectedIcon = Icons.Filled.CreditCard,
            unselectedIcon = Icons.Outlined.CreditCard,
        ),
        NavigationDrawerItemData(
            title = "Quem somos",
            selectedIcon = Icons.Filled.Business,
            unselectedIcon = Icons.Outlined.Business,
        ),
        NavigationDrawerItemData(
            title = "Contato",
            selectedIcon = Icons.Filled.ContactSupport,
            unselectedIcon = Icons.Outlined.ContactSupport,
        ),
        NavigationDrawerItemData(
            title = "Tutorial",
            selectedIcon = Icons.Filled.Help,
            unselectedIcon = Icons.Outlined.Help,
        ),
        NavigationDrawerItemData(
            title = "Configurações",
            selectedIcon = Icons.Filled.Settings,
            unselectedIcon = Icons.Outlined.Settings,
        ),
    )
}