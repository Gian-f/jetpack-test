package com.br.jetpacktest.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OutlinedTextFieldWithValidation(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    validationErrorText: String,
) {

    OutlinedTextField(
        label = { Text(text = label) },
        value = value,
        onValueChange = {
            onValueChange(it)
        },
        supportingText = {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = validationErrorText,
            )
        },

        singleLine = true,
    )
}