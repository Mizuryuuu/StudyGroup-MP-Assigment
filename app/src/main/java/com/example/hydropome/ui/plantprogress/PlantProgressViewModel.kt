package com.example.hydropome.ui.plantprogress

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hydropome.common.Plant
import com.example.hydropome.common.PlantProgress
import com.example.hydropome.data.repository.PlantProgressRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class PlantProgressViewModel : ViewModel() {

    private var _uiState = MutableStateFlow(PlantProgressUiState())
    val uiState = _uiState.asStateFlow()
    private val repository = PlantProgressRepository()

    fun getIdPlantProgress(id: String) {
        _uiState.update {
            it.copy(plantProgress = repository.getPlantProgress(id))
        }
    }

    fun onClickDay(index: Int){
        val progress = _uiState.value.plantProgress ?: return

        _uiState.value = _uiState.value.copy(
            plantProgress = progress.copy(
                day = index,
                taskState = List(progress.plant.tasksByDay[index].tasks.size) {false}
            )
        )
    }

    fun onTaskCompletionChange(index: Int) {
        val current = _uiState.value
        val progress = current.plantProgress ?: return

        val newState = progress.taskState.toMutableList()

        if (index < newState.size) {
            newState[index] = !newState[index]
        }

        _uiState.value = current.copy(
            plantProgress = progress.copy(taskState = newState)
        )
    }


}