package com.example.interviewcoach.data

import android.content.Context
import com.example.interviewcoach.data.model.InterviewQuestion
import kotlinx.serialization.json.Json

class QuestionLoader(
    private val context: Context
) {

    fun loadQuestions(): List<InterviewQuestion> {
        val jsonString = context.assets
            .open("questions.json")
            .bufferedReader()
            .use { it.readText() }

        return Json.decodeFromString(jsonString)
    }
}