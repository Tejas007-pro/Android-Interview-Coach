package com.example.interviewcoach.data.model

import kotlinx.serialization.Serializable

@Serializable
enum class Difficulty {
    EASY,
    MEDIUM,
    HARD
}

@Serializable
data class InterviewQuestion(
    val id: String,
    val question: String,
    val expectedAnswer: String,
    val keyPoints: List<String>,
    val topic: String,
    val difficulty: Difficulty
)