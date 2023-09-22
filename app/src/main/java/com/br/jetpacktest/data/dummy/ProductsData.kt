package com.br.jetpacktest.data.dummy

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.ImageNotSupported
import com.br.jetpacktest.domain.model.Products
import com.br.jetpacktest.util.FormatCurrency

object ProductsData {
    val products = listOf(
        Products(
            description = "Produto 1",
            image = Icons.Sharp.ImageNotSupported,
            price = FormatCurrency(10.00),
        ),
        Products(
            description = "Produto 2",
            image = Icons.Sharp.ImageNotSupported,
            price = FormatCurrency(80.00),
        ),
        Products(
            description = "Produto 3",
            image = Icons.Sharp.ImageNotSupported,
            price = FormatCurrency(120.00),
        ),
        Products(
            description = "Produto 4",
            image = Icons.Sharp.ImageNotSupported,
            price = FormatCurrency(15.00),
        ),
        Products(
            description = "Produto 5",
            image = Icons.Sharp.ImageNotSupported,
            price = FormatCurrency(100.00),
        ),
        Products(
            description = "Produto 6",
            image = Icons.Sharp.ImageNotSupported,
            price = FormatCurrency(200.00),
        )
    )
}