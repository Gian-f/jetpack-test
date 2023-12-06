package com.br.jetpacktest.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.br.jetpacktest.data.dummy.CardsData.cards
import com.br.jetpacktest.data.dummy.HistoryTransactionDummyData.historyTransactions
import com.br.jetpacktest.data.dummy.OtherServicesDummyData.services
import com.br.jetpacktest.ui.components.CreditCard
import com.br.jetpacktest.ui.components.OtherServicesButton
import com.br.jetpacktest.ui.routes.Screen
import com.br.jetpacktest.ui.viewmodel.CardViewModel
import com.br.jetpacktest.util.CardNumberFilter
import com.br.jetpacktest.util.formattedDate

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardsScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(Screen.MyCards.title, maxLines = 1, overflow = TextOverflow.Ellipsis)
                },
                navigationIcon = {
                    IconButton(onClick = { navController.navigate(Screen.Products.route) }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBackIosNew,
                            contentDescription = "Go back"
                        )
                    }
                },
            )
        },
        content = { paddingValues ->
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                item {
                    BalanceSection(paddingValues)
                }
                item {
                    FormPaymentsSection(paddingValues)
                }
                item {
                    OtherServicesSection()
                }
                item {
                    HistoryTransactionSection()
                }
            }
        },
    )
}

@Composable
private fun BalanceSection(paddingValues: PaddingValues) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = CenterVertically,
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxWidth(),
    ) {
        androidx.compose.material3.Card(
            modifier = Modifier
                .width(300.dp)
                .height(150.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp)
                ) {
                    Text(text = "Saldo")
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp)
                ) {
                    Column {
                        Text(text = "Saldo Disponível")
                        Text(text = "R$ 0,00")
                    }
                }
            }
        }
    }
}

@Composable
private fun FormPaymentsSection(paddingValues: PaddingValues) {
    Row(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxWidth(),
        Arrangement.SpaceEvenly,
        CenterVertically
    ) {
        Text(
            text = "Formas de Pagamento",
            fontWeight = FontWeight.SemiBold,
            fontSize = TextUnit(18F, TextUnitType.Sp)
        )
        Spacer(modifier = Modifier.width(12.dp))
        Text(text = "Ver mais", color = MaterialTheme.colorScheme.secondary)

    }
    Spacer(modifier = Modifier.height(12.dp))
    LazyRow(Modifier.padding(horizontal = 8.dp)) {
        items(cards) {
            androidx.compose.material3.Card(
                modifier = Modifier
                    .width(300.dp)
                    .height(200.dp)
                    .padding(12.dp),
                elevation = CardDefaults.cardElevation(3.dp),
            ) {
                Column(modifier = Modifier.padding(12.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End,
                        verticalAlignment = CenterVertically
                    ) {
                        Text(text = it.cardType.name)
                    }
                    Text(text = it.cardNumber)
                    Text(text = it.holderName)
                    Text(text = formattedDate(it.expiryDate))
                }
            }
        }
    }
}

@Composable
private fun OtherServicesSection() {
    Row(
        modifier = Modifier
            .padding(vertical = 12.dp)
            .fillMaxWidth(),
        Arrangement.Start,
        CenterVertically
    ) {
        Text(
            text = "Outros Serviços",
            fontWeight = FontWeight.SemiBold,
            fontSize = TextUnit(18F, TextUnitType.Sp),
            modifier = Modifier.padding(start = 22.dp)
        )
    }
    LazyColumn(Modifier.padding(horizontal = 8.dp).fillMaxSize()) {
        items(services) {
            OtherServicesButton(
                label = it.label,
                icon = it.icon
            ) {

            }
        }
    }
}

@Composable
private fun HistoryTransactionSection() {
    Row(
        modifier = Modifier
            .padding(top = 30.dp)
            .fillMaxWidth(),
        Arrangement.SpaceEvenly,
        CenterVertically
    ) {
        Text(
            text = "Histórico de Transações",
            fontWeight = FontWeight.SemiBold,
            fontSize = TextUnit(18F, TextUnitType.Sp)
        )
        Spacer(modifier = Modifier.width(12.dp))
        Text(text = "Ver mais", color = MaterialTheme.colorScheme.secondary)

    }
    Spacer(modifier = Modifier.height(12.dp))
    LazyRow(Modifier.padding(8.dp)) {
        items(historyTransactions) {
            androidx.compose.material3.Card(
                modifier = Modifier
                    .width(300.dp)
                    .height(200.dp)
                    .padding(12.dp),
                elevation = CardDefaults.cardElevation(3.dp),
            ) {

            }
        }
    }
}

@Composable
fun CardDetails() {

    val viewModel = remember { CardViewModel() }

    Column(modifier = Modifier.fillMaxSize()) {

        CreditCard(
            cardNumber = viewModel.cardNumber,
            holderName = viewModel.cardHolderName,
            expiryDate = viewModel.expiryDate,
            cardCVV = viewModel.cardCVV
        )

        LazyColumn(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            item {
                OutlinedTextField(
                    value = viewModel.cardNumber.text,
                    onValueChange = { viewModel.cardNumber = TextFieldValue(it) },
                    label = { Text("Seu número de cartão") },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Number
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 5.dp),
                    visualTransformation = CardNumberFilter
                )
            }

            item {
                OutlinedTextField(
                    value = viewModel.cardHolderName.text,
                    onValueChange = { viewModel.cardHolderName = TextFieldValue(it) },
                    label = { Text("Seu nome no cartão") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 5.dp),
                )
            }

            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 5.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    OutlinedTextField(
                        value = viewModel.expiryDate.text,
                        onValueChange = { viewModel.expiryDate = TextFieldValue(it) },
                        label = { Text("Validade") },
                        keyboardOptions = KeyboardOptions.Default.copy(
                            keyboardType = KeyboardType.Number
                        ),
                        modifier = Modifier
                            .weight(1f)
                            .padding(end = 8.dp)
                    )
                    OutlinedTextField(
                        value = viewModel.cardCVV.text,
                        onValueChange = { viewModel.cardCVV = TextFieldValue(it) },
                        label = { Text("CVV") },
                        keyboardOptions = KeyboardOptions.Default.copy(
                            keyboardType = KeyboardType.Number
                        ),
                        modifier = Modifier
                            .weight(1f)
                            .padding(start = 8.dp)
                    )
                }
            }

            item {
                Button(
                    onClick = { },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 20.dp),
                    shape = RoundedCornerShape(15.dp),
                    colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.secondary)
                ) {
                    Text(
                        text = "Salvar",
                        color = MaterialTheme.colorScheme.onPrimary,
                        modifier = Modifier.padding(horizontal = 30.dp, vertical = 8.dp)
                    )
                }
            }
        }
    }
}

@Preview(
    showBackground = true, backgroundColor = 0xFFFFFEFE,
    device = "id:pixel_6_pro"
)
@Composable
fun Card() {
    CardDetails()
}
