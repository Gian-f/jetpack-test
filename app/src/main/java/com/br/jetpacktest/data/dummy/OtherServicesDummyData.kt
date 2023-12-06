package com.br.jetpacktest.data.dummy

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChildFriendly
import androidx.compose.material.icons.filled.DirectionsCar
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MonitorHeart
import androidx.compose.material.icons.filled.NoteAlt
import com.br.jetpacktest.domain.model.OtherServices

object OtherServicesDummyData {
    val services: List<OtherServices> = listOf(
        OtherServices(
            label = "Serviço 1",
            icon = Icons.Filled.Home
        ),
        OtherServices(
            label = "Serviço 2",
            icon = Icons.Filled.DirectionsCar
        ),
        OtherServices(
            label = "Serviço 3",
            icon = Icons.Filled.MonitorHeart
        ),
        OtherServices(
            label = "Serviço 4",
            icon = Icons.Filled.ChildFriendly
        ),
        OtherServices(
            label = "Serviço 5",
            icon = Icons.Filled.NoteAlt
        ),
        OtherServices(
            label = "Serviço 6",
            icon = Icons.Filled.NoteAlt
        ),
        OtherServices(
            label = "Serviço 7",
            icon = Icons.Filled.NoteAlt
        ),
        OtherServices(
            label = "Serviço 8",
            icon = Icons.Filled.NoteAlt
        ),
        OtherServices(
            label = "Serviço 9",
            icon = Icons.Filled.NoteAlt
        ),
    )

}