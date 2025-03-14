package no.uio.ifi.in2000.sondrein.openai_chatbot.data.openaiapi.models

data class Usage(
    val prompt_tokens: Int,
    val completion_tokens: Int,
    val total_tokens: Int
)