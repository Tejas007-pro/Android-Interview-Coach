package com.example.interviewcoach.ai

import com.google.mlkit.genai.common.FeatureStatus
import com.google.mlkit.genai.prompt.Generation

class GeminiNanoManager {

    private val generativeModel = Generation.getClient()

    suspend fun checkAvailability(): Int {
        return generativeModel.checkStatus()
    }
}