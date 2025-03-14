package no.uio.ifi.in2000.sondrein.openai_chatbot.data.openaiapi.repository

import no.uio.ifi.in2000.sondrein.openai_chatbot.BuildConfig
import no.uio.ifi.in2000.sondrein.openai_chatbot.data.openaiapi.datasource.OpenAIApiService
import no.uio.ifi.in2000.sondrein.openai_chatbot.data.openaiapi.models.Message
import no.uio.ifi.in2000.sondrein.openai_chatbot.data.openaiapi.models.OpenAIRequest

class OpenAIRepository(private val apiService: OpenAIApiService) {

    suspend fun getResponse(question: String): String {
        return try {
            val request = OpenAIRequest(messages = listOf(Message(content = question, role = "user")))
            val response = apiService.getCompletion("Bearer ${BuildConfig.OPENAI_API_KEY}", request)
            response.choices.firstOrNull()?.message?.content ?: "No response"
        } catch (e: Exception) {
            "Error: ${e.message}"
        }
    }
}