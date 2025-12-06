package com.example.hydropome.ui.home

import com.example.hydropome.common.Plant
import com.example.hydropome.common.Product
import com.example.hydropome.common.User

data class HomeUiState(
    val user: User? = null,
    val searchQuery: String = "",
    val plants: List<Plant> = listOf(),
    val flashSaleProducts: List<Product> = listOf(),
    val isLoading: Boolean = false
)