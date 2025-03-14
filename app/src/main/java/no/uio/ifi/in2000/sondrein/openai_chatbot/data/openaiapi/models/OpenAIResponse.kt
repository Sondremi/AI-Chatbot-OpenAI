package no.uio.ifi.in2000.sondrein.openai_chatbot.data.openaiapi.models

data class OpenAIResponse(
    val id: String,
    val `object`: String,
    val created: Long,
    val model: String,
    val choices: List<Choice>,
    val usage: Usage
)