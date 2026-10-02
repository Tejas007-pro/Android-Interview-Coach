package com.example.interviewcoach

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.arm.aichat.AiChat
import com.arm.aichat.InferenceEngine
import com.example.interviewcoach.ai.ModelManager
import kotlinx.coroutines.launch
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.lifecycleScope
import com.example.interviewcoach.navigation.AppNavigation
import com.example.interviewcoach.ui.theme.InterviewCoachTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val modelManager = ModelManager(applicationContext)
        val modelFile = modelManager.getModelFile()

        android.util.Log.d(
            "ModelManager",
            "Model exists=${modelFile.exists()}, size=${modelFile.length()}, path=${modelFile.path}"
        )

        val engine = AiChat.getInferenceEngine(applicationContext)

        lifecycleScope.launch {
            engine.state.collect { state ->
                android.util.Log.d(
                    "QwenEngine",
                    "State = $state"
                )
            }
        }

        lifecycleScope.launch {
            engine.state.collect { state ->
                if (state is InferenceEngine.State.Initialized) {
                    engine.loadModel(modelFile.path)

                    engine.setSystemPrompt(
                        "You are a helpful assistant. Answer briefly."
                    )

                    engine.sendUserPrompt(
                        """
    Question: What is the difference between val and var in Kotlin?

    Correct answer: val cannot be reassigned after initialization, while var can be reassigned.

    User answer: val cannot be reassigned.

    Judge the user's answer based on its meaning. Is the user's answer correct? Explain briefly.
    """.trimIndent()
                    ).collect { token ->
                        android.util.Log.d(
                            "QwenResponse",
                            token
                        )
                    }
                }
            }
        }

        setContent {
            InterviewCoachTheme {
                AppNavigation()
            }
        }
    }
}