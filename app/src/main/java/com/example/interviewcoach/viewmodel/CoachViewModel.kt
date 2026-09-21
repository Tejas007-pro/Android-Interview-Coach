package com.example.interviewcoach.viewmodel

import androidx.lifecycle.ViewModel
import com.example.interviewcoach.ui.screens.topics.InterviewTopic
import com.example.interviewcoach.ui.state.CoachUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Android
import androidx.compose.material.icons.filled.Code
import androidx.compose.material.icons.filled.DataObject
import androidx.compose.material.icons.filled.Layers
import androidx.compose.material.icons.filled.Memory
import androidx.compose.material.icons.filled.Storage

class CoachViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(
        CoachUiState(
            practicedQuestions = 12,
            totalQuestions = 100,
            correctAnswers = 9,
            currentStreak = 3,
            overallProgress = 0.70f,

            topics = listOf(
                InterviewTopic(
                    name = "Kotlin",
                    questionCount = 25,
                    icon = Icons.Default.Code
                ),
                InterviewTopic(
                    name = "Android Fundamentals",
                    questionCount = 30,
                    icon = Icons.Default.Android
                ),
                InterviewTopic(
                    name = "Jetpack Compose",
                    questionCount = 20,
                    icon = Icons.Default.Layers
                ),
                InterviewTopic(
                    name = "MVVM & Architecture",
                    questionCount = 20,
                    icon = Icons.Default.Memory
                ),
                InterviewTopic(
                    name = "Coroutines & Flow",
                    questionCount = 20,
                    icon = Icons.Default.DataObject
                ),
                InterviewTopic(
                    name = "Room Database",
                    questionCount = 15,
                    icon = Icons.Default.Storage
                )
            )
        )
    )

    val uiState: StateFlow<CoachUiState> = _uiState.asStateFlow()
}