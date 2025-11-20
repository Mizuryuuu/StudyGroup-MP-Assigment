package com.example.hydropome.ui

import kotlinx.serialization.Serializable

@Serializable
sealed class AppDestination {
    @Serializable
    data object Personalization: AppDestination()

    @Serializable
    data object Main : AppDestination()
}