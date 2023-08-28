package com.br.jetpacktest.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun CustomDivider(middleText: String) {
    Box(
        modifier = Modifier.fillMaxWidth()
    ) {
        Divider(
            modifier = Modifier.align(Alignment.Center),
            color = Color.LightGray,
            thickness = 1.dp
        )
        Text(
            text = middleText,
            modifier = Modifier
                .padding(horizontal = 12.dp)
                .background(Color.White)
                .align(Alignment.Center),
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                color = Color.Gray
            )
        )
    }
}