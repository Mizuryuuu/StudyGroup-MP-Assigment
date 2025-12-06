package com.example.hydropome.ui.home

import androidx.lifecycle.ViewModel
import com.example.hydropome.common.Category
import com.example.hydropome.common.Difficulty
import com.example.hydropome.common.Plant
import com.example.hydropome.common.Product
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class HomeViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState = _uiState.asStateFlow()

    fun refreshPlants() {
        _uiState.update {
            it.copy(isLoading = true)
        }
        _uiState.update {
            it.copy(
                plants = listOf(
                    Plant(
                        title = "Selada Hidroponik",
                        difficulty = Difficulty.EASY,
                        duration = "3-5"
                    ),
                    Plant(
                        title = "Bayam Hidroponik",
                        difficulty = Difficulty.MEDIUM,
                        duration = "3-4"
                    ),
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

    fun refreshFlashSaleProducts() {
        _uiState.update {
            it.copy(isLoading = true)
        }
        _uiState.update {
            it.copy(
                flashSaleProducts = listOf(
                    Product(
                        title = "Basic Starter Kit",
                        regularPrice = 50000,
                        discountedPrice = 25000,
                        category = Category.STARTER_KIT
                    ),
                    Product(
                        title = "Basic Starter Kit",
                        regularPrice = 50000,
                        discountedPrice = 25000,
                        category = Category.STARTER_KIT
                    ),
                    Product(
                        title = "Basic Starter Kit",
                        regularPrice = 50000,
                        discountedPrice = 25000,
                        category = Category.STARTER_KIT
                    )
                )
            )
        }
        _uiState.update {
            it.copy(isLoading = false)
        }
    }
}