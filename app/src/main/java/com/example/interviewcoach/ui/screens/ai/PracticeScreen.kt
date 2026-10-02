package com.example.interviewcoach.ui.screens.ai

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.interviewcoach.viewmodel.CoachViewModel

@Composable
fun PracticeScreen(
    viewModel: CoachViewModel
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    val question = uiState.questions.firstOrNull()

    var userAnswer by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Text(
            text = question?.question ?: "No questions available"
        )

        OutlinedTextField(
            value = userAnswer,
            onValueChange = { userAnswer = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            label = {
                Text("Your answer")
            }
        )

        Button(
            onClick = {
                viewModel.submitAnswer(userAnswer)
            },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Submit Answer")
        }

        uiState.evaluationResult?.let { result ->

            Text(
                text = "Result: ${result.status}",
                modifier = Modifier.padding(top = 16.dp)
            )

            Text(
                text = result.feedback,
                modifier = Modifier.padding(top = 8.dp)
            )
        }
    }
}