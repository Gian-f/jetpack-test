package com.br.jetpacktest.domain.model

import java.util.Date

data class HistoryTransaction(
    val price: Double,
    val place: String,
    val orderNumber: String,
    val orderedAt: Date,
)
