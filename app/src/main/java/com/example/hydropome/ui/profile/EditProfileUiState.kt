package com.example.hydropome.ui.profile

// State khusus untuk halaman Edit Profil
data class EditProfileUiState(
    val isLoading: Boolean = false,
    val name: String = "",
    val email: String = "",
    val password: String = "",
    val newPassword: String = "",
    val errorMessage: String? = null,
    val isSuccess: Boolean = false
)
