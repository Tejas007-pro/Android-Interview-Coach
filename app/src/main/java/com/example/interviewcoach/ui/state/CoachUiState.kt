package com.example.interviewcoach.ui.state

import com.example.interviewcoach.ui.screens.saved.SavedQuestion
import com.example.interviewcoach.ui.screens.topics.InterviewTopic

data class CoachUiState(
    val practicedQuestions: Int = 0,
    val totalQuestions: Int = 0,
    val correctAnswers: Int = 0,
    val currentStreak: Int = 0,
    val overallProgress: Float = 0f,
    val topics: List<InterviewTopic> = emptyList(),
    val savedQuestions: List<SavedQuestion> = emptyList()
)