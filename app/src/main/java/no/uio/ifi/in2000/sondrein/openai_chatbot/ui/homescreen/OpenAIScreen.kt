package no.uio.ifi.in2000.sondrein.openai_chatbot.ui.homescreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun OpenAIApp() {
    val viewModel: OpenAIViewModel = viewModel()
    var question by remember { mutableStateOf("") }
    val response by viewModel.response.collectAsState()

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "OpenAI Chatbot",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = question,
            onValueChange = { question = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            placeholder = { Text("Ask a question...") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            viewModel.askQuestion(question)
        }) {
            Text("Ask")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = response)
    }
}