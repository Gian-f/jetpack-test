package com.br.jetpacktest.ui.screens.auth.state

sealed class LoginUIEvent{

    data class EmailChanged(val email:String): LoginUIEvent()
    data class PasswordChanged(val password: String) : LoginUIEvent()
    object LoginButtonClicked : LoginUIEvent()
    object DismissError : LoginUIEvent()
}