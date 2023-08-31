package com.br.jetpacktest.ui.routes

sealed class Screen(val route: String, val title: String) {
    object Products : Screen("home", "Produtos")
    object Offers : Screen("offers", "Ofertas")
    object News : Screen("news", "Novidades")
    object Client : Screen("client", "Cliente")
    object Orders: Screen("orders", "Meus Pedidos")
    object Titles: Screen("titles", "Títulos")
    object MyCards: Screen("mycards", "Meus Cartões")
    object Culture: Screen("culture", "Quem Somos")
    object Contact: Screen("contact", "Contato")
    object Tutorial: Screen("tutorial", "Tutorial")
    object Settings: Screen("settings", "Configurações")
    object Login : Screen("login", "Login")
    object Notifications: Screen("notifications", "Notificações")
    object Favorites : Screen("favorites", "Favoritos")
    object Profile : Screen("profile", "Perfil")
    object Email : Screen("email", "Email")
}