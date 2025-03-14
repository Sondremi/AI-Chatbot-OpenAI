package no.uio.ifi.in2000.sondrein.openai_chatbot

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import no.uio.ifi.in2000.sondrein.openai_chatbot.ui.homescreen.OpenAIApp
import no.uio.ifi.in2000.sondrein.openai_chatbot.ui.theme.OpenAIchatbotTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            OpenAIchatbotTheme {
                OpenAIApp()
            }
        }
    }
}
