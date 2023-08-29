package com.br.jetpacktest.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun OrdersScreen(navController: NavController) {
    Scaffold(
        topBar = {
            Text(text = "")
        }
    ) {
        Text(text = "", modifier = Modifier.padding(it))
    }
}