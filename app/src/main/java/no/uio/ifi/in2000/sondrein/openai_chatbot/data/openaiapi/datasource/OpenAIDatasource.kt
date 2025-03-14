package no.uio.ifi.in2000.sondrein.openai_chatbot.data.openaiapi.datasource

import no.uio.ifi.in2000.sondrein.openai_chatbot.data.openaiapi.models.OpenAIRequest
import no.uio.ifi.in2000.sondrein.openai_chatbot.data.openaiapi.models.OpenAIResponse
import retrofit2.Retrofit
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.converter.gson.GsonConverterFactory

interface OpenAIApiService {
    @POST("v1/chat/completions")
    suspend fun getCompletion(
        @Header("Authorization") auth: String,
        @Body request: OpenAIRequest
    ): OpenAIResponse

    companion object {
        private const val BASE_URL = "https://api.openai.com/"

        fun create(): OpenAIApiService {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(OpenAIApiService::class.java)
        }
    }
}