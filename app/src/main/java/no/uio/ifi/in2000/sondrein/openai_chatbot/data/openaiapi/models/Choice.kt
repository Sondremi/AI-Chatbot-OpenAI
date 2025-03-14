package no.uio.ifi.in2000.sondrein.openai_chatbot.data.openaiapi.models

data class Choice(
    val index: Int,
    val message: Message,
    val finish_reason: String
)