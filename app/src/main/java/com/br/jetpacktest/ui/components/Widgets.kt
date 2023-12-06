package com.br.jetpacktest.ui.components

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.SheetState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
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
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.constraintlayout.compose.ConstraintLayout
import com.br.jetpacktest.R
import com.br.jetpacktest.domain.model.CardType
import com.br.jetpacktest.ui.theme.GrayColor
import com.br.jetpacktest.ui.theme.TextColor
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
                    0 -> RoundedCornerShape(
                        topStartPercent = cornerRadius,
                        topEndPercent = 0,
                        bottomStartPercent = cornerRadius,
                        bottomEndPercent = 0
                    )

                    items.size - 1 -> RoundedCornerShape(
                        topStartPercent = 0,
                        topEndPercent = cornerRadius,
                        bottomStartPercent = 0,
                        bottomEndPercent = cornerRadius
                    )

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
            .padding(all = 11.dp)
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


@Composable
fun OtherServicesButton(
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
            .padding(all = 11.dp)
        ) {
            Icon(
                imageVector = icon,
                contentDescription = "services",
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier
                    .background(
                        Color.White,
                        RoundedCornerShape(30.dp)
                    )
                    .border(width = 1.dp, color = Color.Gray, shape = RoundedCornerShape(30.dp))
                    .padding(18.dp)
            )
        }
        Text(
            text = label,
            fontWeight = FontWeight.W600,
            fontSize = TextUnit(11f, TextUnitType.Sp)
        )
    }
}


@Composable
fun CreditCard(
    cardNumber: TextFieldValue,
    holderName: TextFieldValue,
    expiryDate: TextFieldValue,
    cardCVV: TextFieldValue,
) {

    // Mutable state to track the flip state of the card
    var backSwitch by remember { mutableStateOf(false) }

    // Mutable state to track the detected card type (Visa, Mastercard, etc.)
    var cardType by remember { mutableStateOf(CardType.None) }

    // Calculate the length of the card number and mask it for display
    val length = if (cardNumber.text.length > 16) 16 else cardNumber.text.length
    val maskedNumber =
        remember { "*****************" }.replaceRange(0..length, cardNumber.text.take(16))


    val cvv = if (cardCVV.text.length > 3) 3 else cardCVV.text.length
    val maskedCVV = remember { "*".repeat(3) }.replaceRange(0 until cvv, cardCVV.text.take(3))

    // Determine whether to switch to the back side of the card based on CVV length
    if (cardCVV.text.length == 1 && !backSwitch) {
        backSwitch = true
    } else if (cardCVV.text.length == 2) {
        backSwitch = true
    } else if (cardCVV.text.length == 3) {
        backSwitch = false
    }

    // Detect and set the card type logo based on the card number's first digit
    cardType = when {
        cardNumber.text.isNotEmpty() -> {
            when (cardNumber.text.take(2)) {
                "30", "36", "38" -> CardType.DinersClub
                "40" -> CardType.Visa
                "50", "51", "52", "53", "54", "55" -> CardType.Mastercard
                "56", "57", "58", "63", "67" -> CardType.Maestro
                "60" -> CardType.RuPay
                "37" -> CardType.AmericanExpress
                else -> CardType.None
            }
        }

        else -> CardType.None
    }

    // Set the card's background color based on its type
    val animatedColor = animateColorAsState(
        targetValue =
        when (cardType) {
            CardType.Visa -> {
                Color(0xFF1C478B)
            }

            CardType.Mastercard -> {
                Color(0xFF3BB9A1)
            }

            CardType.RuPay -> {
                Color(0xFFB2B1FD)
            }

            CardType.AmericanExpress -> {
                Color(0xFFA671FC)
            }

            CardType.Maestro -> {
                Color(0xFF99BEF8)
            }

            CardType.DinersClub -> {
                Color(0xFFFC4444)
            }

            else -> {
                MaterialTheme.colorScheme.onBackground
            }
        },
        label = ""
    )

    Box {
        Surface(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .height(200.dp)
                .graphicsLayer(
                    rotationY = animateFloatAsState(
                        if (backSwitch) 180f else 0f,
                        label = "",
                        animationSpec = tween(500),
                    ).value,
                    translationY = 0f
                )
                .clip(RoundedCornerShape(8))
                .clickable {
                    backSwitch = !backSwitch
                },
            shape = RoundedCornerShape(20.dp),
            color = animatedColor.value,
            shadowElevation = 18.dp
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.secondary)
            ) {
                AnimatedVisibility(visible = !backSwitch) {
                    ConstraintLayout(
                        modifier = Modifier.fillMaxSize()
                    ) {

                        val (cardImage, cardName, cardHolderName, number, cardExpiry, expiry) = createRefs()

                        AnimatedVisibility(visible = cardType != CardType.None,
                            modifier = Modifier
                                .padding(start = 12.dp, top = 10.dp)
                                .constrainAs(cardImage) {
                                    start.linkTo(parent.start)
                                    top.linkTo(parent.top)
                                }) {
                            Image(
                                painter = painterResource(id = cardType.image),
                                contentDescription = "Card Image"
                            )
                        }

                        Text(
                            text = maskedNumber.chunked(4).joinToString(" "),
                            style = MaterialTheme.typography.headlineSmall,
                            maxLines = 1,
                            color = Color.White,
                            modifier = Modifier
                                .animateContentSize(spring())
                                .padding(bottom = 20.dp)
                                .constrainAs(number) {
                                    linkTo(
                                        start = parent.start,
                                        end = parent.end
                                    )
                                    linkTo(
                                        top = parent.top,
                                        bottom = parent.bottom
                                    )
                                }
                        )

                        Text(
                            text = "Nome do Titular",
                            color = Color.White,
                            modifier = Modifier
                                .padding(horizontal = 16.dp)
                                .constrainAs(cardHolderName) {
                                    start.linkTo(parent.start)
                                    bottom.linkTo(cardName.top)
                                }
                        )

                        Text(
                            text = holderName.text,
                            color = Color.White,
                            modifier = Modifier
                                .animateContentSize(TweenSpec(300))
                                .padding(top = 10.dp, start = 16.dp, bottom = 16.dp)
                                .constrainAs(cardName) {
                                    start.linkTo(parent.start)
                                    bottom.linkTo(parent.bottom)
                                }
                        )

                        Text(
                            text = "Validade",
                            color = Color.White,
                            modifier = Modifier
                                .padding(horizontal = 16.dp)
                                .constrainAs(expiry) {
                                    end.linkTo(parent.end)
                                    bottom.linkTo(cardExpiry.top)
                                }
                        )

                        Text(
                            text = expiryDate.text.take(4).chunked(2).joinToString(" / "),
                            color = Color.White,
                            modifier = Modifier
                                .padding(top = 10.dp, end = 16.dp, bottom = 16.dp)
                                .constrainAs(cardExpiry) {
                                    end.linkTo(parent.end)
                                    bottom.linkTo(parent.bottom)
                                }
                        )
                    }
                }

                AnimatedVisibility(visible = backSwitch) {
                    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
                        val (back) = createRefs()
                        Spacer(modifier = Modifier
                            .height(50.dp)
                            .background(
                                Color.Black
                            )
                            .fillMaxWidth()
                            .constrainAs(back) {
                                linkTo(
                                    top = parent.top,
                                    bottom = parent.bottom
                                )
                            }
                        )
                    }
                }
            }
        }

        AnimatedVisibility(
            visible = backSwitch,
            modifier = Modifier
                .padding(end = 50.dp, bottom = 50.dp)
                .align(Alignment.BottomEnd)
        ) {
            Box(
                modifier = Modifier
                    .defaultMinSize(minWidth = 60.dp)
                    .clip(RoundedCornerShape(4.dp))
                    .background(Color.White),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = maskedCVV,
                    style = MaterialTheme.typography.headlineSmall,
                    color = Color.Black,
                    modifier = Modifier
                        .animateContentSize(TweenSpec(300))
                        .padding(vertical = 4.dp, horizontal = 16.dp)

                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewPaymentCard() {
    CreditCard(
        TextFieldValue("*****************"),
        TextFieldValue("Aritra Das"),
        TextFieldValue("0229"),
        TextFieldValue("699")
    )
}


@Composable
fun NormalTextComponent(value: String) {
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp),
        style = TextStyle(
            fontSize = 24.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal
        ), color = colorResource(id = R.color.colorText),
        textAlign = TextAlign.Center
    )
}

@Composable
fun HeadingTextComponent(value: String) {
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(),
        style = TextStyle(
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal
        ), color = colorResource(id = R.color.colorText),
        textAlign = TextAlign.Center
    )
}

@Composable
fun MyTextFieldComponent(
    labelValue: String, painterResource: ImageVector,
    onTextChanged: (String) -> Unit,
    fieldName: String,
    errorStatus: Boolean = false,
) {

    val textValue = remember { mutableStateOf("") }
    val isFocused = remember { mutableStateOf(false) }

    val localFocusManager = LocalFocusManager.current

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(4.dp))
            .onFocusChanged { hasFocus -> isFocused.value = hasFocus.isFocused }
            .focusRequester(FocusRequester()),
        label = { Text(text = labelValue) },
        colors = OutlinedTextFieldDefaults.colors(
            cursorColor = MaterialTheme.colorScheme.primary,
            focusedBorderColor = MaterialTheme.colorScheme.primary,
            focusedLabelColor = MaterialTheme.colorScheme.primary,
        ),
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
        singleLine = true,
        maxLines = 1,
        value = textValue.value,
        onValueChange = {
            textValue.value = it
            onTextChanged(it)
        },
        leadingIcon = {
            Icon(imageVector = painterResource, contentDescription = "")
        },
        supportingText = {
            Text(text = if (isFocused.value) if (!errorStatus) "Digite um $fieldName válido" else "" else "")
        },
        isError = if (isFocused.value) !errorStatus else false,
    )
}


@Composable
fun PasswordTextFieldComponent(
    labelValue: String, painterResource: ImageVector,
    onTextSelected: (String) -> Unit,
    errorStatus: Boolean = false,
) {

    val isFocused = remember { mutableStateOf(false) }

    val localFocusManager = LocalFocusManager.current
    val password = remember { mutableStateOf("") }

    val passwordVisible = remember { mutableStateOf(false) }

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(4.dp))
            .onFocusChanged { hasFocus ->
                isFocused.value = hasFocus.isFocused
            },
        label = { Text(text = labelValue) },
        colors = OutlinedTextFieldDefaults.colors(
            cursorColor = MaterialTheme.colorScheme.primary,
            focusedBorderColor = MaterialTheme.colorScheme.primary,
            focusedLabelColor = MaterialTheme.colorScheme.primary,
        ),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Done
        ),
        singleLine = true,
        keyboardActions = KeyboardActions {
            localFocusManager.clearFocus()
        },
        maxLines = 1,
        value = password.value,
        onValueChange = {
            password.value = it
            onTextSelected(it)
        },
        leadingIcon = {
            Icon(imageVector = painterResource, contentDescription = "")
        },
        trailingIcon = {

            val iconImage = if (passwordVisible.value) {
                Icons.Filled.Visibility
            } else {
                Icons.Filled.VisibilityOff
            }

            val description = if (passwordVisible.value) {
                stringResource(id = R.string.hide_password)
            } else {
                stringResource(id = R.string.show_password)
            }

            IconButton(onClick = { passwordVisible.value = !passwordVisible.value }) {
                Icon(imageVector = iconImage, contentDescription = description)
            }

        },
        supportingText = {
            Text(text = if (isFocused.value) if (!errorStatus) "Digite uma senha válida" else "" else "")
        },
        visualTransformation = if (passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation(),
        isError = if (isFocused.value) !errorStatus else false,
    )
}

@Composable
fun CheckboxComponent(
    value: String,
    onTextSelected: (String) -> Unit,
    onCheckedChange: (Boolean) -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(56.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {

        val checkedState = remember {
            mutableStateOf(false)
        }

        Checkbox(checked = checkedState.value,
            onCheckedChange = {
                checkedState.value = !checkedState.value
                onCheckedChange.invoke(it)
            })

        ClickableTextComponent(value = value, onTextSelected)
    }
}

@Composable
fun ClickableTextComponent(value: String, onTextSelected: (String) -> Unit) {
    val initialText = "Ao continuar você aceita nossa "
    val privacyPolicyText = "Politica de privacidade"
    val andText = " e "
    val termsAndConditionsText = "Termos de uso"

    val annotatedString = buildAnnotatedString {
        append(initialText)
        withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.primary)) {
            pushStringAnnotation(tag = privacyPolicyText, annotation = privacyPolicyText)
            append(privacyPolicyText)
        }
        append(andText)
        withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.primary)) {
            pushStringAnnotation(tag = termsAndConditionsText, annotation = termsAndConditionsText)
            append(termsAndConditionsText)
        }
    }

    ClickableText(text = annotatedString, onClick = { offset ->

        annotatedString.getStringAnnotations(offset, offset)
            .firstOrNull()?.also { span ->
                Log.d("ClickableTextComponent", "{${span.item}}")

                if ((span.item == termsAndConditionsText) || (span.item == privacyPolicyText)) {
                    onTextSelected(span.item)
                }
            }

    })
}

@Composable
fun ButtonComponent(value: String, onButtonClicked: () -> Unit, isEnabled: Boolean = false) {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(48.dp),
        onClick = {
            onButtonClicked.invoke()
        },
        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(Color.Transparent),
        shape = RoundedCornerShape(15.dp),
        enabled = isEnabled
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(48.dp)
                .background(
                    brush = Brush.horizontalGradient(
                        listOf(
                            MaterialTheme.colorScheme.secondary,
                            MaterialTheme.colorScheme.primary
                        )
                    ),
                    shape = RoundedCornerShape(15.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = value,
                fontSize = 18.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun DividerTextComponent() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            color = GrayColor,
            thickness = 1.dp
        )

        Text(
            modifier = Modifier.padding(8.dp),
            text = stringResource(R.string.or),
            fontSize = 18.sp,
            color = TextColor
        )
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            color = GrayColor,
            thickness = 1.dp
        )
    }
}

@Composable
fun ClickableLoginTextComponent(tryingToLogin: Boolean = true, onTextSelected: (String) -> Unit) {
    val initialText = if (tryingToLogin) "Já possui uma conta? " else "Não tem uma conta? "
    val loginText = if (tryingToLogin) "Entrar" else "Registre-se"

    val annotatedString = buildAnnotatedString {
        append(initialText)
        withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.primary)) {
            pushStringAnnotation(tag = loginText, annotation = loginText)
            append(loginText)
        }
    }

    ClickableText(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp),
        style = TextStyle(
            fontSize = 21.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal,
            textAlign = TextAlign.Center
        ),
        text = annotatedString,
        onClick = { offset ->

            annotatedString.getStringAnnotations(offset, offset)
                .firstOrNull()?.also { span ->
                    Log.d("ClickableTextComponent", "{${span.item}}")

                    if (span.item == loginText) {
                        onTextSelected(span.item)
                    }
                }

        },
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoadingBottomSheet(
    errorMessage: String?,
    onDismiss: () -> Unit,
) {
    val sheetState = rememberModalBottomSheetState(true)
    ModalBottomSheet(
        sheetState = sheetState,
        onDismissRequest = {
            onDismiss.invoke()
        },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                if (errorMessage != null) {
                    Text(
                        text = "Atenção!",
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            fontSize = 28.sp
                        ),
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(30.dp))
                    Text(
                        text = errorMessage,
                        modifier = Modifier.fillMaxWidth(),
                        fontSize = 22.sp,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(30.dp))

                    Button(
                        onClick = {
                            onDismiss.invoke()
                        },
                        shape = RoundedCornerShape(15.dp),
                    ) {
                        Text(
                            text = "OK",
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth(),
                            fontSize = 18.sp,
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                    }
                } else {
                    CircularProgressIndicator()
                }
            }
        }
    )
}