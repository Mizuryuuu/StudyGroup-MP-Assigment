package com.example.hydropome.ui.personalization.mdoel

import androidx.annotation.DrawableRes

data class Question (
    val id: String,
    val title: String,
    val answers:  List<String>,
    val isMultipleAnswer: Boolean = false,
    @DrawableRes val answerImage: List<Int>? = null
)