package com.example.hydropome.ui.monitorplants

import com.example.hydropome.common.PlantProgress

data class MonitorPlantsUiState(
    val plantProgresses: List<PlantProgress> = listOf(),
    val searchQuery: String = "",
    val isLoading: Boolean = false
)