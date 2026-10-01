package com.example.interviewcoach

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.interviewcoach.navigation.AppNavigation
import com.example.interviewcoach.ui.theme.InterviewCoachTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


        setContent {
            InterviewCoachTheme {
                AppNavigation()
            }
        }
    }
}