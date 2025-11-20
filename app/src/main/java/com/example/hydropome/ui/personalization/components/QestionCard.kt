package com.example.hydropome.ui.personalization.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hydropome.R
import com.example.hydropome.ui.personalization.mdoel.Question
import com.example.hydropome.ui.theme.HydropomeTheme

@Composable
fun QuestionCard(
    question: Question,
    selectedAnswers: List<Boolean>,
    onSelectedAnswersChange: (List<Boolean>) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(
                elevation = 8.dp,
                shape = RoundedCornerShape(12.dp),
                ambientColor = Color.Black.copy(alpha = 0.4f),
                spotColor = Color.Black.copy(alpha = 0.4f)
            )
            .clip((RoundedCornerShape(12.dp)))
            .background(Color(0xFFFFFFFF))
            .padding(12.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.ill_plant_circle),
                contentDescription = null,
                modifier = Modifier.size(40.dp)
            )
            Spacer(Modifier.width(8.dp))
            Text(
                text = question.title,

            )
        }
    }
}

@Preview
@Composable
private fun QuestionCardPreview() {
    HydropomeTheme {
        QuestionCard(
            question = Question(
                id = "0",
                title = "Apakah kamu pernah mencoba menanam hidroponik sebelumnya?",
                answers = listOf(
                    "Belum pernah",
                    "Pernah, tapi masih pemula",
                    "Sudah cukup berpengalaman"
                ),
            ),
            selectedAnswers = listOf(
                false,
                true,
                false
            ),
            onSelectedAnswersChange = {}
        )
    }
}