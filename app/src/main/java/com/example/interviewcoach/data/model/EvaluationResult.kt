package com.example.interviewcoach.data.model

enum class EvaluationStatus {
    CORRECT,
    PARTIAL,
    INCORRECT
}

data class EvaluationResult(
    val status: EvaluationStatus,
    val feedback: String
)