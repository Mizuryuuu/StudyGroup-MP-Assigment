package com.example.hydropome.ui.profile

// Status tab di halaman "Status Pesanan"
enum class OrderTab {
    DIPROSES,
    DIKIRIM,
    SELESAI
}

// Data untuk 1 kartu pesanan
data class OrderItemUi(
    val id: String,
    val title: String,
    val price: String,
    val total: String,
    val status: OrderTab
)

// State untuk halaman profil + status pesanan
data class ProfileUiState(
    val isLoading: Boolean = false,
    val name: String = "",
    val email: String = "",
    val avatarInitial: String = "",
    val selectedTab: OrderTab = OrderTab.DIPROSES,
    val orders: List<OrderItemUi> = emptyList()
)
