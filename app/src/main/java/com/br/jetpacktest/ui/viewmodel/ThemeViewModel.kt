package com.br.jetpacktest.ui.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.br.jetpacktest.util.ComposeTheme
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ThemeViewModel @Inject constructor() : ViewModel() {
    val currentTheme = mutableStateOf(ComposeTheme.Light)

    fun setTheme(theme: ComposeTheme) {
        currentTheme.value = theme
    }
}
