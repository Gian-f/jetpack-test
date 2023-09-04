package com.br.jetpacktest.data.dummy

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.ImageNotSupported
import com.br.jetpacktest.domain.model.Products
import com.br.jetpacktest.util.FormatCurrency

object ProductsData {
    val products = listOf(
        Products(
            description = "Testando",
            image = Icons.Sharp.ImageNotSupported,
            price = FormatCurrency(10.00),
        ),
        Products(
            description = "teste",
            image = Icons.Sharp.ImageNotSupported,
            price = FormatCurrency(80.00),
        ),
        Products(
            description = "teste",
            image = Icons.Sharp.ImageNotSupported,
            price = FormatCurrency(120.00),
        ),
        Products(
            description = "teste",
            image = Icons.Sharp.ImageNotSupported,
            price = FormatCurrency(15.00),
        ),
        Products(
            description = "teste",
            image = Icons.Sharp.ImageNotSupported,
            price = FormatCurrency(100.00),
        ),
        Products(
            description = "teste",
            image = Icons.Sharp.ImageNotSupported,
            price = FormatCurrency(200.00),
        )
    )
}