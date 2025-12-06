package com.example.hydropome.ui.onboarding

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class OnBoardingViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(OnboardingUiState())
    val uiState = _uiState.asStateFlow()

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
}