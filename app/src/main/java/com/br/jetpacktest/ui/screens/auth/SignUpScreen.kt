package com.br.jetpacktest.ui.screens.auth

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person2
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.br.jetpacktest.R
import com.br.jetpacktest.ui.components.ButtonComponent
import com.br.jetpacktest.ui.components.CheckboxComponent
import com.br.jetpacktest.ui.components.ClickableLoginTextComponent
import com.br.jetpacktest.ui.components.DividerTextComponent
import com.br.jetpacktest.ui.components.HeadingTextComponent
import com.br.jetpacktest.ui.components.MyTextFieldComponent
import com.br.jetpacktest.ui.components.NormalTextComponent
import com.br.jetpacktest.ui.components.PasswordTextFieldComponent
import com.br.jetpacktest.ui.routes.Screen
import com.br.jetpacktest.ui.screens.auth.state.SignupUIEvent

@Composable
fun SignUpScreen(
    signUpViewModel: SignUpViewModel = viewModel(),
    navController: NavHostController,
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(28.dp)
        ) {

            NormalTextComponent(value = stringResource(id = R.string.hello))
            HeadingTextComponent(value = stringResource(id = R.string.create_account))
            Spacer(modifier = Modifier.height(20.dp))

            MyTextFieldComponent(
                labelValue = stringResource(id = R.string.first_name),
                painterResource = Icons.Filled.Person2,
                fieldName = "Primeiro nome",
                onTextChanged = {
                    signUpViewModel.onEvent(SignupUIEvent.FirstNameChanged(it))
                },
                errorStatus = signUpViewModel.registrationUIState.value.firstNameError
            )

            MyTextFieldComponent(
                labelValue = stringResource(id = R.string.last_name),
                painterResource = Icons.Filled.Person2,
                fieldName = "Sobrenome",
                onTextChanged = {
                    signUpViewModel.onEvent(SignupUIEvent.LastNameChanged(it))
                },
                errorStatus = signUpViewModel.registrationUIState.value.lastNameError
            )

            MyTextFieldComponent(
                labelValue = stringResource(id = R.string.email),
                painterResource = Icons.Filled.Email,
                onTextChanged = {
                    signUpViewModel.onEvent(SignupUIEvent.EmailChanged(it))
                },
                fieldName = "E-mail",
                errorStatus = signUpViewModel.registrationUIState.value.emailError
            )

            PasswordTextFieldComponent(
                labelValue = stringResource(id = R.string.password),
                painterResource = Icons.Filled.Lock,
                onTextSelected = {
                    signUpViewModel.onEvent(SignupUIEvent.PasswordChanged(it))
                },
                errorStatus = signUpViewModel.registrationUIState.value.passwordError
            )

            CheckboxComponent(
                value = stringResource(id = R.string.terms_and_conditions),
                onTextSelected = {
//                        Router.navigateTo(Screen.TermsAndConditionsScreen)
                },
                onCheckedChange = {
                    signUpViewModel.onEvent(SignupUIEvent.PrivacyPolicyCheckBoxClicked(it))
                }
            )

            Spacer(modifier = Modifier.height(30.dp))

            ButtonComponent(
                value = stringResource(id = R.string.register),
                onButtonClicked = {
                    signUpViewModel.onEvent(SignupUIEvent.RegisterButtonClicked)
                },
                isEnabled = signUpViewModel.allValidationsPassed.value
            )

            Spacer(modifier = Modifier.height(15.dp))

            DividerTextComponent()

            Spacer(modifier = Modifier.height(15.dp))

            ClickableLoginTextComponent(tryingToLogin = true, onTextSelected = {
                navController.navigate(Screen.Login.route)
            })
        }
        if (signUpViewModel.signUpInProgress.value) {
            CircularProgressIndicator()
        }
    }
}