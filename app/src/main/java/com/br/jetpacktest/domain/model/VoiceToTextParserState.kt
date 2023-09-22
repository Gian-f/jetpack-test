package com.br.jetpacktest.domain.model

data class VoiceToTextParserState(
    var spokenText: String = "",
    val isSpeaking: Boolean = false,
    val error: String? = null,
)