package com.example.hydropome.ui.home

import androidx.lifecycle.ViewModel
import com.example.hydropome.R
import com.example.hydropome.common.Difficulty
import com.example.hydropome.common.Plant
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class LamanTanamanViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(LamanTanamanUiState())
    val uiState = _uiState.asStateFlow()

    fun refreshPlant(plantId: String) {
        _uiState.update {
            it.copy(isLoading = true)
        }
        _uiState.update {
            it.copy(
                plant = Plant(
                    title = "Selada Hidroponik",
                    difficulty = Difficulty.EASY,
                    duration = "3-5",
                    image = R.drawable.im_plant_1,
                    description = "Selada merupakan salah satu tanaman paling populer dalam budidaya hidroponik karena pertumbuhannya yang cepat dan perawatannya yang mudah. Tanaman ini cocok untuk pemula karena tidak memerlukan banyak nutrisi khusus atau perawatan intensif. Selada tumbuh subur di sistem hidroponik seperti NFT (Nutrient Film Technique) dan dapat dipanen dalam waktu 3–5 minggu setelah tanam",
                    toolsAndMaterials = listOf(
                        Plant.ToolMaterial(
                            title = "Wadah atau Bak Tanam",
                            description = "Tempat air nutrisi dan tanaman diletakkan."
                        ),
                        Plant.ToolMaterial(
                            title = "Net Pot / Pot kecil berlubang",
                            description = "Untuk menahan tanaman dan media tanam."
                        ),
                        Plant.ToolMaterial(
                            title = "Spons/Rockwool",
                            description = "Media tanam tempat benih tumbuh."
                        ),
                        Plant.ToolMaterial(
                            title = "Benih selada"
                        ),
                        Plant.ToolMaterial(
                            title = "Air Bersih"
                        )
                    )
                ),
            )
        }
        _uiState.update {
            it.copy(isLoading = false)
        }
    }
}