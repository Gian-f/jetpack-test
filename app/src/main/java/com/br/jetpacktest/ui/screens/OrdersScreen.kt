package com.br.jetpacktest.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.br.jetpacktest.data.dummy.OrderData
import com.br.jetpacktest.ui.components.ElevatedFilterChip
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OrdersScreen(navController: NavController) {
    val items = OrderData.items
    val chipStateInProgress = remember { mutableStateOf(false) }
    val chipStateDelivered = remember { mutableStateOf(true) }
    val chipStateCancelled = remember { mutableStateOf(false) }
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text("Meus Pedidos", maxLines = 1, overflow = TextOverflow.Ellipsis)
                },
                navigationIcon = {
                    IconButton(onClick = { navController.navigate("Home") }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBackIos,
                            contentDescription = "Comeback"
                        )
                    }
                },
                actions = {

                }
            )
        },
        content = { innerPadding ->
            Column {
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(innerPadding)
                        .fillMaxWidth()
                ) {
                    ElevatedFilterChip(
                        label = "Em andamento",
                        selected = chipStateInProgress,
                        onSelected = {
                            chipStateInProgress.value = true
                            chipStateDelivered.value = false
                            chipStateCancelled.value = false
                        }
                    )
                    ElevatedFilterChip(
                        label = "Entregues",
                        selected = chipStateDelivered,
                        onSelected = {
                            chipStateInProgress.value = false
                            chipStateDelivered.value = true
                            chipStateCancelled.value = false
                        }
                    )
                    ElevatedFilterChip(
                        label = "Canceladas",
                        selected = chipStateCancelled,
                        onSelected = {
                            chipStateInProgress.value = false
                            chipStateDelivered.value = false
                            chipStateCancelled.value = true
                        }
                    )
                }
                LazyColumn {
                    item {
                        val filteredItems = items.filter { item ->
                            (chipStateInProgress.value && item.status == "Pendente") ||
                                    (chipStateDelivered.value && item.status == "Entregue") ||
                                    (chipStateCancelled.value && item.status == "Cancelado")
                        }
                        filteredItems.forEach {
                            Card(
                                modifier = Modifier
                                    .padding(12.dp)
                                    .fillMaxWidth()
                                    .height(170.dp),
                                elevation = CardDefaults.cardElevation(5.dp),
                                colors = CardDefaults.cardColors(Color(0xFFF9F9F9))
                            ) {
                                Row(
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(top = 16.dp)
                                ) {
                                    Text(
                                        text = "Pedido #" + it.orderId.toString(),
                                        fontFamily = FontFamily.Monospace,
                                        fontWeight = FontWeight.Bold,
                                        textAlign = TextAlign.Start,
                                        modifier = Modifier.padding(start = 12.dp)
                                    )

                                    Text(
                                        text = it.requestedAt,
                                        modifier = Modifier.padding(end = 12.dp)
                                    )
                                }

                                Row(
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(top = 16.dp)
                                ) {
                                    Text(
                                        text = "Número de rastreio: ",
                                        fontFamily = FontFamily.SansSerif,
                                        modifier = Modifier.padding(start = 12.dp)
                                    )

                                    Text(
                                        text = it.trackingNumber,
                                        color = Color.Black,
                                        modifier = Modifier.padding(end = 12.dp)
                                    )
                                }
                                Row(
                                    horizontalArrangement = Arrangement.End,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(top = 16.dp)
                                ) {
                                    Text(
                                        text = "Subtotal: $" + it.total,
                                        fontWeight = FontWeight.Bold,
                                        fontFamily = FontFamily.SansSerif,
                                        modifier = Modifier.padding(end = 12.dp)
                                    )
                                }

                                Row(
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(top = 16.dp, bottom = 8.dp)
                                ) {
                                    Text(
                                        text = it.status.uppercase(Locale.ROOT),
                                        fontFamily = FontFamily.SansSerif,
                                        modifier = Modifier.padding(start = 12.dp),
                                        color =
                                        if (it.status.contains("Pendente")) Color(0xFFCF6212)
                                        else if (it.status.contains("Cancelado")) Color(0xFFC50000)
                                        else Color(0xFF009254)
                                    )

                                    OutlinedButton(
                                        onClick = { /*TODO*/ },
                                        modifier = Modifier
                                            .width(140.dp)
                                            .height(80.dp)
                                            .padding(end = 12.dp),
                                    ) {
                                        Text(
                                            text = "Detalhes",
                                            color = Color.Black,
                                            textAlign = TextAlign.Center
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    )
}