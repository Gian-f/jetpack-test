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
import androidx.compose.material.icons.outlined.HelpOutline
import androidx.compose.material.icons.outlined.LocalOffer
import androidx.compose.material.icons.outlined.Newspaper
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.ShoppingBag
import androidx.compose.material.icons.outlined.ShoppingCart
import com.br.jetpacktest.domain.model.NavigationDrawerItemData
import com.br.jetpacktest.ui.routes.Screen

object NavigationDrawerData {
    val items = listOf(
        NavigationDrawerItemData(
            title = Screen.Products.title,
            route = Screen.Products.route,
            selectedIcon = Icons.Filled.ShoppingCart,
            unselectedIcon = Icons.Outlined.ShoppingCart,
        ),
        NavigationDrawerItemData(
            title = Screen.Offers.title,
            route = Screen.Offers.route,
            selectedIcon = Icons.Filled.LocalOffer,
            unselectedIcon = Icons.Outlined.LocalOffer,
        ),
        NavigationDrawerItemData(
            title = Screen.News.title,
            route = Screen.News.route,
            selectedIcon = Icons.Filled.Newspaper,
            unselectedIcon = Icons.Outlined.Newspaper,
            badgeCount = 10
        ),
        NavigationDrawerItemData(
            title = Screen.Client.title,
            route = Screen.Client.route,
            selectedIcon = Icons.Filled.Person,
            unselectedIcon = Icons.Outlined.Person,
        ),
        NavigationDrawerItemData(
            title = Screen.Orders.title,
            route = Screen.Orders.route,
            selectedIcon = Icons.Filled.ShoppingBag,
            unselectedIcon = Icons.Outlined.ShoppingBag,
        ),
        NavigationDrawerItemData(
            title = Screen.Titles.title,
            route = Screen.Titles.route,
            selectedIcon = Icons.Filled.AccountBalance,
            unselectedIcon = Icons.Outlined.AccountBalance,
        ),
        NavigationDrawerItemData(
            title = Screen.MyCards.title,
            route = Screen.MyCards.route,
            selectedIcon = Icons.Filled.CreditCard,
            unselectedIcon = Icons.Outlined.CreditCard,
        ),
        NavigationDrawerItemData(
            title = Screen.Culture.title,
            route = Screen.Culture.route,
            selectedIcon = Icons.Filled.Business,
            unselectedIcon = Icons.Outlined.Business,
        ),
        NavigationDrawerItemData(
            title = Screen.Contact.title,
            route = Screen.Contact.route,
            selectedIcon = Icons.Filled.ContactSupport,
            unselectedIcon = Icons.Outlined.ContactSupport,
        ),
        NavigationDrawerItemData(
            title = Screen.Tutorial.title,
            route = Screen.Tutorial.route,
            selectedIcon = Icons.Filled.Help,
            unselectedIcon = Icons.Outlined.HelpOutline,
        ),
        NavigationDrawerItemData(
            title = Screen.Settings.title,
            route = Screen.Settings.route,
            selectedIcon = Icons.Filled.Settings,
            unselectedIcon = Icons.Outlined.Settings,
        ),
    )
}