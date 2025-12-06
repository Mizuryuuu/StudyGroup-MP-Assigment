package com.example.hydropome.ui.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ProfileViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(ProfileUiState())
    val uiState = _uiState.asStateFlow()

    init {
        loadProfile()
        loadDummyOrders()
    }

    // Di sini kita isi data dummy saja, bukan ambil dari repository
    private fun loadProfile() {
        viewModelScope.launch {
            _uiState.update {
                it.copy(
                    isLoading = false,
                    name = "Mellafesa",
                    email = "mellafesa@gmail.com",
                    avatarInitial = "M"
                )
            }
        }
    }

    private fun loadDummyOrders() {
        val dummyOrders = listOf(
            OrderItemUi(
                id = "1",
                title = "Paket Lengkap",
                price = "Rp 25.000",
                total = "Rp 35.000",
                status = OrderTab.DIPROSES
            )
        )

        _uiState.update {
            it.copy(orders = dummyOrders)
        }
    }

    fun onTabSelected(tab: OrderTab) {
        _uiState.update {
            it.copy(selectedTab = tab)
        }
    }

    // Untuk tugas, logout cukup navigate ke halaman login / sebelumnya
    fun logout(onSuccess: () -> Unit) {
        onSuccess()
    }
}
