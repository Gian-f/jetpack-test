package com.br.jetpacktest.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


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


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ElevatedFilterChip(
    label: String,
    selected: MutableState<Boolean>,
    onSelected: () -> Unit,
) {
    androidx.compose.material3.ElevatedFilterChip(
        selected = selected.value,
        onClick = {
            if (!selected.value) {
                onSelected()
            }
        },
        label = { Text(label) },
        shape = CircleShape,
        leadingIcon = if (selected.value) {
            {
                Icon(
                    imageVector = Icons.Filled.Done,
                    contentDescription = "Localized Description",
                    modifier = Modifier.size(FilterChipDefaults.IconSize)
                )
            }
        } else {
            null
        }
    )
}


@Composable
fun RadioOption(text: String, isSelected: Boolean, onSelect: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .clip(CircleShape)
            .clickable(
                onClick = onSelect
            )
            .padding(vertical = 8.dp)
    ) {
        Text(text = text, modifier = Modifier.weight(1f))
        RadioButton(
            selected = isSelected,
            onClick = onSelect
        )
    }
}

@Composable
fun FilterButton(onClick: () -> Unit, modifier: Modifier = Modifier) {
    IconButton(
        onClick = onClick,
        modifier = modifier
    ) {
        Icon(
            imageVector = Icons.Filled.FilterList,
            tint = MaterialTheme.colorScheme.primary,
            contentDescription = "Filter list..."
        )
    }
}


@Composable
fun HistoryItem(name: String) {
    Row(modifier = Modifier.padding(14.dp)) {
        Icon(
            modifier = Modifier.padding(end = 10.dp),
            imageVector = Icons.Default.History,
            contentDescription = "History"
        )
        Text(text = name)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheetModalFilter(state: SheetState, scope: CoroutineScope) {
    var selectedOption by remember { mutableStateOf("") }
    LaunchedEffect(Unit) { state.show() }

    if (state.isVisible) {
        ModalBottomSheet(
            onDismissRequest = {
                scope.launch {
                    state.hide()
                }
            }) {
            // Conteúdo do ModalBottomSheet
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                // Título do filtro
                Text(
                    text = "Filtre por",
                    style = MaterialTheme.typography.titleLarge,
                )

                // Opções do filtro
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                ) {
                    RadioOption("Novos", selectedOption == "Opção 1") {
                        selectedOption = "Opção 1"
                        scope.launch {
                            delay(500) // Atraso de 1 segundo
                            state.hide() // Fecha o ModalBottomSheet
                        }
                    }
                    RadioOption("Recomendados", selectedOption == "Opção 2") {
                        selectedOption = "Opção 2"
                        scope.launch {
                            delay(300) // Atraso de 1 segundo
                            state.hide() // Fecha o ModalBottomSheet
                        }
                    }
                    RadioOption("Preço - do menor para o maior", selectedOption == "Opção 3") {
                        selectedOption = "Opção 3"
                        scope.launch {
                            delay(200) // Atraso de 1 segundo
                            state.hide() // Fecha o ModalBottomSheet
                        }
                    }
                    RadioOption("Preço - do maior para o menor", selectedOption == "Opção 4") {
                        selectedOption = "Opção 4"
                        scope.launch {
                            delay(200) // Atraso de 1 segundo
                            state.hide() // Fecha o ModalBottomSheet
                        }
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

@Composable
fun SegmentedButton(
    items: List<String>,
    defaultSelectedItemIndex: Int = 0,
    useFixedWidth: Boolean = false,
    itemWidth: Dp = 120.dp,
    cornerRadius: Int = 30,
    color: Color = MaterialTheme.colorScheme.secondary,
    onItemSelection: (selectedItemIndex: Int) -> Unit,
) {
    val selectedIndex = remember { mutableIntStateOf(defaultSelectedItemIndex) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 25.dp),
        horizontalArrangement = Arrangement.Start
    ) {
        items.forEachIndexed { index, item ->
            OutlinedButton(
                modifier = when (index) {
                    0 -> {
                        if (useFixedWidth) {
                            Modifier
                                .width(itemWidth)
                                .offset(0.dp, 0.dp)
                                .zIndex(if (selectedIndex.intValue == index) 1f else 0f)
                        } else {
                            Modifier
                                .wrapContentSize()
                                .offset(0.dp, 0.dp)
                                .zIndex(if (selectedIndex.intValue == index) 1f else 0f)
                        }
                    }

                    else -> {
                        if (useFixedWidth)
                            Modifier
                                .width(itemWidth)
                                .offset((-1 * index).dp, 0.dp)
                                .zIndex(if (selectedIndex.intValue == index) 1f else 0f)
                        else Modifier
                            .wrapContentSize()
                            .offset((-1 * index).dp, 0.dp)
                            .zIndex(if (selectedIndex.intValue == index) 1f else 0f)
                    }
                },
                onClick = {
                    selectedIndex.intValue = index
                    onItemSelection(selectedIndex.intValue)
                },
                shape = when (index) {
                    /**
                     * left outer button
                     */
                    /**
                     * left outer button
                     */
                    0 -> RoundedCornerShape(
                        topStartPercent = cornerRadius,
                        topEndPercent = 0,
                        bottomStartPercent = cornerRadius,
                        bottomEndPercent = 0
                    )
                    /**
                     * right outer button
                     */
                    /**
                     * right outer button
                     */
                    items.size - 1 -> RoundedCornerShape(
                        topStartPercent = 0,
                        topEndPercent = cornerRadius,
                        bottomStartPercent = 0,
                        bottomEndPercent = cornerRadius
                    )
                    /**
                     * middle button
                     */
                    /**
                     * middle button
                     */
                    else -> RoundedCornerShape(
                        topStartPercent = 0,
                        topEndPercent = 0,
                        bottomStartPercent = 0,
                        bottomEndPercent = 0
                    )
                },
                border = BorderStroke(
                    1.dp, color.copy(alpha = 0.2f)
                ),
                colors = if (selectedIndex.intValue == index) {

                    ButtonDefaults.outlinedButtonColors(
                        contentColor = color
                    )
                } else {
                    ButtonDefaults.outlinedButtonColors(contentColor = Color.Transparent)
                },
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = if (index == 0) Icons.Filled.LightMode else Icons.Filled.DarkMode,
                        contentDescription = "Icon modes",
                        tint = if (selectedIndex.intValue == index) {
                            MaterialTheme.colorScheme.primary
                        } else {
                            color.copy(alpha = 0.9f)
                        }
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = item,
                        fontWeight = FontWeight.Normal,
                        color = if (selectedIndex.intValue == index) {
                            MaterialTheme.colorScheme.primary
                        } else {
                            color.copy(alpha = 0.9f)
                        },
                    )
                }
            }
        }
    }
}

@Composable
fun CategoriesButton(
    label: String,
    icon: ImageVector,
    onClick: () -> Unit,
) {
    var isClicked by remember { mutableStateOf(false) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Box(modifier = Modifier
            .clip(CircleShape)
            .clickable {
                isClicked = !isClicked
                onClick()
            }
            .padding(all = 10.dp)
        ) {
            Icon(
                imageVector = icon,
                contentDescription = "categories",
                tint = if (isClicked) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSecondary,
                modifier = Modifier
                    .background(
                        MaterialTheme.colorScheme.inversePrimary,
                        RoundedCornerShape(30.dp)
                    )
                    .padding(12.dp)
            )
        }
        Text(
            text = label,
            fontWeight = FontWeight.W600,
            fontSize = TextUnit(11f, TextUnitType.Sp)
        )
    }
}