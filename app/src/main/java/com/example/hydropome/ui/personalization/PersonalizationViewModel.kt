package com.example.hydropome.ui.personalization

import androidx.lifecycle.ViewModel
import com.example.hydropome.ui.personalization.model.PersonalizationUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class PersonalizationViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(PersonalizationUiState())
    val uiState: StateFlow<PersonalizationUiState> = _uiState

    fun incrementPage() {
        _uiState.update {
            it.copy(page = it.page + 1)
        }
    }

    fun decrementPage() {
        _uiState.update {
            it.copy(page = it.page - 1)
        }
    }

    fun changeSelectedAnswers(questionId: String, selectedAnswers: List<Boolean>){
        _uiState.update {
            val newSelectedAnswers = it.selectedAnswers.mapValues { (_, innerMap) ->
                innerMap.toMutableMap()
            }.toMutableMap()

            newSelectedAnswers[it.page]?.set(questionId, selectedAnswers)

            it.copy(selectedAnswers = newSelectedAnswers)
        }
    }


}