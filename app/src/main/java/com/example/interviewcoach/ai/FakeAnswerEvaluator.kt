package com.example.interviewcoach.ai

import com.example.interviewcoach.data.model.EvaluationResult
import com.example.interviewcoach.data.model.EvaluationStatus

class FakeAnswerEvaluator : AnswerEvaluator {

    override suspend fun evaluate(
        question: String,
        expectedAnswer: String,
        userAnswer: String
    ): EvaluationResult {

        return EvaluationResult(
            status = EvaluationStatus.CORRECT,
            feedback = "Test feedback from evaluator."
        )
    }
}