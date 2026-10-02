package com.example.interviewcoach.ai

import android.content.Context
import java.io.File

class ModelManager(
    context: Context
) {

    companion object {
        private const val MODEL_FILE_NAME =
            "qwen2.5-1.5b-instruct-q4_k_m.gguf"
    }

    private val modelFile = File(
        context.filesDir,
        "models/$MODEL_FILE_NAME"
    )

    fun getModelFile(): File {
        return modelFile
    }
}