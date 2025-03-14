package no.uio.ifi.in2000.sondrein.openai_chatbot.ui.homescreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import no.uio.ifi.in2000.sondrein.openai_chatbot.data.openaiapi.datasource.OpenAIApiService
import no.uio.ifi.in2000.sondrein.openai_chatbot.data.openaiapi.repository.OpenAIRepository

class OpenAIViewModel : ViewModel() {
    private val repository = OpenAIRepository(OpenAIApiService.create())

    private val _response = MutableStateFlow("")
    val response: StateFlow<String> = _response

    fun askQuestion(question: String) {
        viewModelScope.launch {
            try {
                val answer = repository.getResponse(question)
                _response.value = answer
            } catch (e: Exception) {
                _response.value = "Error: ${e.message}"
            }
        }
    }
}