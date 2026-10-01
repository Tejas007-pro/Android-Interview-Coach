package com.example.interviewcoach.ui.screens.ai

import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.interviewcoach.ai.GeminiNanoManager
import com.google.mlkit.genai.common.FeatureStatus
import kotlinx.coroutines.launch

@Composable
fun AiTestScreen(
    modifier: Modifier = Modifier
) {
    var statusText by remember {
        mutableStateOf("Checking Gemini Nano...")
    }

    val scope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        scope.launch {
            val manager = GeminiNanoManager()
            val status = manager.checkAvailability()

            statusText = when (status) {
                FeatureStatus.AVAILABLE -> "Gemini Nano is AVAILABLE"
                FeatureStatus.DOWNLOADABLE -> "Gemini Nano is DOWNLOADABLE"
                FeatureStatus.DOWNLOADING -> "Gemini Nano is DOWNLOADING"
                FeatureStatus.UNAVAILABLE -> "Gemini Nano is UNAVAILABLE"
                else -> "Unknown status: $status"
            }
        }
    }

    Text(
        text = statusText,
        modifier = modifier
    )
}