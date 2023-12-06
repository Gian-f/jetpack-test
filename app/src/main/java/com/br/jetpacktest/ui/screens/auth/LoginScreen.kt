package com.br.jetpacktest.ui.screens.auth

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Mail
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.br.jetpacktest.R
import com.br.jetpacktest.ui.components.ButtonComponent
import com.br.jetpacktest.ui.components.ClickableLoginTextComponent
import com.br.jetpacktest.ui.components.DividerTextComponent
import com.br.jetpacktest.ui.components.HeadingTextComponent
import com.br.jetpacktest.ui.components.LoadingBottomSheet
import com.br.jetpacktest.ui.components.MyTextFieldComponent
import com.br.jetpacktest.ui.components.PasswordTextFieldComponent
import com.br.jetpacktest.ui.routes.Screen
import com.br.jetpacktest.ui.screens.auth.state.LoginUIEvent
import com.br.jetpacktest.ui.viewmodel.AuthViewModel

@Composable
fun LoginScreen(loginViewModel: AuthViewModel = viewModel(), navController: NavController) {

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(28.dp)
        ) {
            Spacer(modifier = Modifier.height(50.dp))

            HeadingTextComponent(value = stringResource(id = R.string.login))

            Spacer(modifier = Modifier.height(20.dp))

            MyTextFieldComponent(
                labelValue = stringResource(id = R.string.email),
                Icons.Filled.Mail,
                onTextChanged = {
                    loginViewModel.onEvent(LoginUIEvent.EmailChanged(it))
                },
                fieldName = "E-mail",
                errorStatus = loginViewModel.loginUIState.value.emailError,
            )

            PasswordTextFieldComponent(
                labelValue = stringResource(id = R.string.password),
                Icons.Filled.Lock,
                onTextSelected = {
                    loginViewModel.onEvent(LoginUIEvent.PasswordChanged(it))
                },
                errorStatus = loginViewModel.loginUIState.value.passwordError,
            )

            Spacer(modifier = Modifier.height(20.dp))

            ButtonComponent(
                value = stringResource(id = R.string.login),
                onButtonClicked = {
                    loginViewModel.onEvent(LoginUIEvent.LoginButtonClicked)
                },
                isEnabled = loginViewModel.allValidationsPassed.value
            )

            Spacer(modifier = Modifier.height(20.dp))

            DividerTextComponent()

            Spacer(modifier = Modifier.height(20.dp))

            ClickableLoginTextComponent(
                tryingToLogin = false,
                onTextSelected = {
                    navController.navigate(Screen.Products.route)
                }
            )
        }
        if (loginViewModel.loginError.value || loginViewModel.loginInProgress.value) {
            LoadingBottomSheet(
                errorMessage = loginViewModel.errorMessage.value,
                onDismiss = {
                    loginViewModel.onEvent(LoginUIEvent.DismissError)
                }
            )
        }
    }
}