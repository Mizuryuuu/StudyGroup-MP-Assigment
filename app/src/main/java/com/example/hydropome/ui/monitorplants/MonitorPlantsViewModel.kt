package com.example.hydropome.ui.monitorplants

import androidx.lifecycle.ViewModel
import com.example.hydropome.R
import com.example.hydropome.common.Difficulty
import com.example.hydropome.common.Plant
import com.example.hydropome.common.PlantProgress
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MonitorPlantsViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(MonitorPlantsUiState())
    val uiState = _uiState.asStateFlow()

    fun refreshPlantProgresses() {
        _uiState.update {
            it.copy(isLoading = true)
        }

        _uiState.update {
            it.copy(
                plantProgresses = listOf(
                    PlantProgress(
                        plant = Plant(
                            title = "Selada Hidroponik",
                            difficulty = Difficulty.EASY,
                            duration = "3-5",
                            image = R.drawable.selada_hidroponik,
                        )
                    ),
                    PlantProgress(
                        plant = Plant(
                            title = "Bayam Hidroponik",
                            difficulty = Difficulty.MEDIUM,
                            duration = "3-4",
                            image = R.drawable.bayam_hidroponik,
                        ),
                        day = 4
                    )
                )
            )
        }

        _uiState.update {
            it.copy(isLoading = false)
        }
    }

    fun search(query: String) {
        _uiState.update {
            it.copy(searchQuery = query)
        }
    }

}