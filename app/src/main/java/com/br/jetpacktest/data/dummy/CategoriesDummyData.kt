package com.br.jetpacktest.data.dummy

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChildFriendly
import androidx.compose.material.icons.filled.DirectionsCar
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MonitorHeart
import androidx.compose.material.icons.filled.NoteAlt
import com.br.jetpacktest.domain.model.CategoriesData

object CategoriesDummyData {
    val categories = listOf(
        CategoriesData(
            label = "HomeCare",
            icon = Icons.Filled.Home
        ),
        CategoriesData(
            label = "Automotivo",
            icon = Icons.Filled.DirectionsCar
        ),
        CategoriesData(
            label = "Saúde",
            icon = Icons.Filled.MonitorHeart
        ),
        CategoriesData(
            label = "Crianças",
            icon = Icons.Filled.ChildFriendly
        ),
        CategoriesData(
            label = "Papelaria",
            icon = Icons.Filled.NoteAlt
        ),
    )
}