package com.example.interviewcoach.ai

import com.example.interviewcoach.data.model.EvaluationResult

interface AnswerEvaluator {

    suspend fun evaluate(
        question: String,
        expectedAnswer: String,
        userAnswer: String
    ): EvaluationResult
}