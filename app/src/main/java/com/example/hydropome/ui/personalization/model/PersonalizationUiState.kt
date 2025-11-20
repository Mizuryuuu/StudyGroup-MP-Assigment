package com.example.hydropome.ui.personalization.model

import com.example.hydropome.ui.personalization.constants.questions

data class PersonalizationUiState (
    val page: Int = 0,
    val selectedAnswers: Map<Int, Map<String, List<Boolean>>> = questions
        .mapIndexed { pageIndex, questionsOnPage ->
            pageIndex to questionsOnPage.associate { question ->
                question.id to question.answers.map { false }
            }
        }.toMap(),
    val isLoading: Boolean = false
)

