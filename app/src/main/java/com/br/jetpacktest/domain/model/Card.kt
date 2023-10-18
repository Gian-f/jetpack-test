package com.br.jetpacktest.domain.model

import java.util.Date

data class Card(
    val holderName: String,
    val cardNumber: String,
    val cardType: CardType,
    val cvv: String,
    val expiryDate: Date
)