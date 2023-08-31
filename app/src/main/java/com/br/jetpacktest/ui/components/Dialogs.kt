package com.br.jetpacktest.ui.components

import androidx.compose.foundation.layout.width
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.br.jetpacktest.ui.routes.Screen

@Composable
fun ConfirmDialog(
    dialogState: MutableState<Boolean> = mutableStateOf(false),
    navController: NavHostController,
) {

    if (dialogState.value) {
        AlertDialog(modifier = Modifier.width(350.dp),
            onDismissRequest = {
                dialogState.value = false
            }, title = {
                Text(text = "Atenção!")
            }, text = {
                Text(
                    text = "Tem certeza que deseja sair?",
                    fontSize = TextUnit(16f, TextUnitType.Sp)
                )
            }, confirmButton = {
                TextButton(onClick = {
                    dialogState.value = false
                    navController.navigate(Screen.Login.route)
                }) {
                    Text("Confirmar")
                }
            }, dismissButton = {
                TextButton(onClick = {
                    dialogState.value = false
                }) {
                    Text("Cancelar")
                }
            })
    }
}