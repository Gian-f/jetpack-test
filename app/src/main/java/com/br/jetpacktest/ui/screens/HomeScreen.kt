package com.br.jetpacktest.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.NotificationsNone
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material.icons.rounded.Link
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DockedSearchBar
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.br.jetpacktest.data.dummy.NavigationDrawerData
import com.br.jetpacktest.data.dummy.NotificationsData.items
import com.br.jetpacktest.ui.components.ConfirmDialog
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@Composable
fun HomeScreen(navController: NavHostController) {
    HomeContent(navController)
}

@OptIn(
    ExperimentalFoundationApi::class
)
@Composable
private fun HomeContent(
    navController: NavHostController,
) {
    val items = NavigationDrawerData.items
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    var selectedItemIndex by rememberSaveable { mutableIntStateOf(0) }
    val scope = rememberCoroutineScope()
    val pagerState = rememberPagerState { 5 }
    val openDialog = remember { mutableStateOf(false) }

    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet(modifier = Modifier.width(300.dp)) {
                LazyColumn {
                    item {
                        DrawerHeader(openDialog)
                        items.forEachIndexed { index, item ->
                            NavigationDrawerItem(
                                modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding),
                                label = { Text(text = item.title) },
                                selected = index == selectedItemIndex,
                                onClick = {
                                    if (item.title.contains("Configurações")) {
                                        navController.navigate("Settings")
                                    }
                                    if (item.title.contains("Pedidos")) {
                                        navController.navigate("Orders")
                                    }
                                    selectedItemIndex = index
                                    scope.launch {
                                        drawerState.close()
                                    }
                                },
                                icon = {
                                    Icon(
                                        imageVector = if (index == selectedItemIndex) {
                                            item.selectedIcon
                                        } else {
                                            item.unselectedIcon
                                        },
                                        contentDescription = item.title
                                    )
                                },
                                badge = {
                                    item.badgeCount?.let {
                                        Text(text = item.badgeCount.toString())
                                    }
                                }
                            )
                        }
                    }
                }
            }
        },
        gesturesEnabled = true,
        drawerState = drawerState
    ) {
        PageContent(scope, drawerState, navController, pagerState)
        ConfirmDialog(openDialog, navController)
    }
}

@Composable
private fun DrawerHeader(openDialog: MutableState<Boolean>) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 26.dp, horizontal = 20.dp)
    ) {
        Row(
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                modifier = Modifier
                    .border(
                        1.dp,
                        Color.LightGray,
                        CircleShape
                    )
                    .padding(12.dp)
                    .size(70.dp, 70.dp),
                imageVector = Icons.Default.Person,
                contentDescription = "Person",
            )
            Column(
                verticalArrangement = Arrangement.Center,
            ) {
                Text(
                    text = "Gian Felipe",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(start = 16.dp),
                    style = MaterialTheme.typography.titleLarge,
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "12345678",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(start = 16.dp),
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.W400,
                    color = Color.Gray
                )
                Row(
                    horizontalArrangement = Arrangement.End,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Button(
                        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.surface),
                        onClick = { openDialog.value = true }) {
                        Icon(
                            imageVector = Icons.Filled.Logout,
                            tint = Color.Black,
                            contentDescription = "Logout"
                        )
                    }
                }
            }
        }
    }
}

@Composable
@OptIn(
    ExperimentalMaterial3Api::class,
    ExperimentalFoundationApi::class
)
private fun PageContent(
    scope: CoroutineScope,
    drawerState: DrawerState,
    navController: NavHostController,
    pagerState: PagerState,
) {
    var isSearchBarVisible by remember { mutableStateOf(false) }
    var query by remember { mutableStateOf("") }
    var active by remember { mutableStateOf(false) }
    val items = remember { mutableStateListOf("teste") }

    val sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true,
    )
    val scope = rememberCoroutineScope()


    Scaffold(
        topBar = {
            Column {
                CenterAlignedTopAppBar(
                    title = {
                        Text("Produtos", maxLines = 1, overflow = TextOverflow.Ellipsis)
                    },
                    navigationIcon = {
                        IconButton(onClick = { scope.launch { drawerState.open() } }) {
                            Icon(
                                imageVector = Icons.Default.Menu,
                                contentDescription = "Localized description"
                            )
                        }
                    },
                    actions = {
                        TopAppBarActions(navController)
                    }
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    DockedSearchBar(
                        modifier = Modifier
                            .width(300.dp)
                            .padding(start = 8.dp, end = 8.dp),
                        query = query,
                        onQueryChange = { query = it },
                        onSearch = {
                            items.add(query)
                            active = false
                            query = ""
                        },
                        active = active,
                        onActiveChange = { active = it },
                        placeholder = { Text(text = "Procure...") },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = "Search"
                            )
                        },
                        trailingIcon = {
                            if (active) {
                                Icon(
                                    imageVector = Icons.Filled.Close,
                                    contentDescription = "Search",
                                    modifier = Modifier.clickable {
                                        if (query.isNotEmpty()) {
                                            query = ""
                                        } else {
                                            active = false
                                            isSearchBarVisible = false
                                        }
                                    }
                                )
                            }
                        },
                    ) {
                        items.forEach { itemName ->
                            Row(modifier = Modifier.padding(14.dp)) {
                                Icon(
                                    modifier = Modifier.padding(end = 10.dp),
                                    imageVector = Icons.Default.History,
                                    contentDescription = "History"
                                )
                                Text(text = itemName)
                            }
                        }
                    }
                    OutlinedButton(
                        onClick = {
                            scope.launch { sheetState.show() }
                        },
                        modifier = Modifier.width(70.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Filled.FilterList,
                            tint = MaterialTheme.colorScheme.primary,
                            contentDescription = "Filter list..."
                        )
                    }
                }
            }
        },
        content = { innerPadding ->
            HorizontalPager(state = pagerState, contentPadding = innerPadding) {
                // Conteúdo do pager
            }
        }
    )
    if (sheetState.isVisible) {
        ModalBottomSheetWithVerticalActions(sheetState, scope)
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ModalBottomSheetWithVerticalActions(state: SheetState, scope: CoroutineScope) {
    // Define o estado das opções do filtro
    var selectedOption by remember { mutableStateOf("Opção 1") }

    LaunchedEffect(Unit) {
        state.show()
    }

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
                    modifier = Modifier.padding(bottom = 16.dp)
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
fun RadioOption(text: String, isSelected: Boolean, onSelect: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
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
@OptIn(ExperimentalMaterial3Api::class)
private fun TopAppBarActions(navController: NavHostController) {
    BadgedBox(
        badge = {
            if (items.isNotEmpty()) {
                Badge()
            }
        }) {
    }
    IconButton(onClick = { navController.navigate("notifications") }) {
        Icon(
            imageVector = Icons.Default.NotificationsNone,
            contentDescription = "Notifications"
        )
    }
}