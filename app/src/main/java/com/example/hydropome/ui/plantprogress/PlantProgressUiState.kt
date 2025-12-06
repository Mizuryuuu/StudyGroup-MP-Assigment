package com.example.hydropome.ui.plantprogress

import com.example.hydropome.common.PlantProgress

data class PlantProgressUiState (
    val plantProgress: PlantProgress? = null,
    val isLoading: Boolean = false
)