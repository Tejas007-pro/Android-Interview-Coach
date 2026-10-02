package com.example.interviewcoach.data.model

enum class EvaluationStatus {
    CORRECT,
    INCORRECT
}

data class EvaluationResult(
    val status: EvaluationStatus,
    val feedback: String
)