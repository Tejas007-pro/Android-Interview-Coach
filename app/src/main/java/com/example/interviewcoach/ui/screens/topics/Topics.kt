package com.example.interviewcoach.ui.screens.topics

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Android
import androidx.compose.material.icons.filled.Code
import androidx.compose.material.icons.filled.DataObject
import androidx.compose.material.icons.filled.Layers
import androidx.compose.material.icons.filled.Memory
import androidx.compose.material.icons.filled.Storage
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

data class InterviewTopic(
    val name: String,
    val questionCount: Int,
    val icon: ImageVector
)

@Composable
fun TopicsScreen(
    onTopicClick: (String) -> Unit = {},
    modifier: Modifier = Modifier
) {
    var searchText by remember {
        mutableStateOf("")
    }

    val topics = listOf(
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

    val filteredTopics = topics.filter { topic ->
        topic.name.contains(
            other = searchText,
            ignoreCase = true
        )
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp, vertical = 20.dp)
    ) {

        Text(
            text = "Explore Topics",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )

        Spacer(
            modifier = Modifier.height(6.dp)
        )

        Text(
            text = "Choose a topic and improve your Android interview skills.",
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        OutlinedTextField(
            value = searchText,
            onValueChange = {
                searchText = it
            },
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text("Search topics...")
            },
            singleLine = true,
            shape = RoundedCornerShape(14.dp)
        )

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(bottom = 20.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            items(filteredTopics) { topic ->

                Card(
                    onClick = {
                        onTopicClick(topic.name)
                    },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surfaceVariant
                    )
                ) {

                    Column(
                        modifier = Modifier.padding(14.dp)
                    ) {

                        Icon(
                            imageVector = topic.icon,
                            contentDescription = topic.name,
                            tint = MaterialTheme.colorScheme.primary
                        )

                        Spacer(
                            modifier = Modifier.height(12.dp)
                        )

                        Text(
                            text = topic.name,
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(
                            modifier = Modifier.height(6.dp)
                        )

                        Text(
                            text = "${topic.questionCount} Questions",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }
        }
    }
}