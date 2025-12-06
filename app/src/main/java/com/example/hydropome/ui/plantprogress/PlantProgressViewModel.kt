package com.example.hydropome.ui.plantprogress

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hydropome.R
import com.example.hydropome.common.Difficulty
import com.example.hydropome.common.Plant
import com.example.hydropome.common.PlantProgress
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class PlantProgressViewModel : ViewModel() {

    private var _uiState = MutableStateFlow(PlantProgressUiState())
    val uiState = _uiState.asStateFlow()

    fun refreshPlantProgress(id: String) {

        _uiState.update {
            it.copy(isLoading = true)
        }
        _uiState.update {
            it.copy(
                plantProgress = PlantProgress(
                    plant = Plant(
                        title = "Selada Hidroponik",
                        difficulty = Difficulty.EASY,
                        duration = "3-5",
                        tasksByDay = listOf(
                            Plant.DailyTasks(
                                tasks = listOf(
                                    "Siapkan Nutrisi & Air 🧪",
                                    "Rendam Rockwool 🧽",
                                    "Tanam Benih Selada 🌱",
                                    "Tutup & Simpan ☁️"
                                ),
                                tip = "Gunakan air tanpa kaporit untuk hasil terbaik!"
                            ),
                            Plant.DailyTasks(
                                tasks = listOf(
                                    "Buka penutup di pagi hari ☀️",
                                    "Semprot air secukupnya 💧",
                                    "Pastikan media tetap lembab 🧽"
                                ),
                                tip = "Jangan menyiram berlebihan agar benih tidak membusuk."
                            ),
                            Plant.DailyTasks(
                                tasks = listOf(
                                    "Cek kecambah yang tumbuh 🌱",
                                    "Pastikan terkena cahaya matahari ☀️",
                                    "Tambahkan air jika media kering 💧"
                                ),
                                tip = "Sinar matahari pagi sangat baik untuk pertumbuhan awal."
                            ),
                            Plant.DailyTasks(
                                tasks = listOf(
                                    "Pindahkan ke sistem hidroponik 🔄",
                                    "Isi nutrisi AB Mix sesuai takaran 🧪",
                                    "Pastikan aliran air lancar 🚿"
                                ),
                                tip = "Gunakan nutrisi dengan dosis rendah terlebih dulu."
                            ),
                            Plant.DailyTasks(
                                tasks = listOf(
                                    "Periksa daun pertama 🌿",
                                    "Pastikan tanaman berdiri tegak 📏",
                                    "Cek ketinggian air nutrisi 💧"
                                ),
                                tip = "Daun yang sehat berwarna hijau cerah."
                            ),
                            Plant.DailyTasks(
                                tasks = listOf(
                                    "Tambah nutrisi jika berkurang 🧪",
                                    "Bersihkan sisa lumut di wadah 🧼",
                                    "Pastikan tanaman tidak roboh 🌱"
                                ),
                                tip = "Lingkungan bersih mencegah jamur dan hama."
                            ),
                            Plant.DailyTasks(
                                tasks = listOf(
                                    "Cek pertumbuhan tinggi tanaman 📏",
                                    "Pastikan daun tidak menguning 🍃",
                                    "Siapkan perawatan lanjutan 🪴"
                                ),
                                tip = "Jika daun menguning, kemungkinan nutrisi kurang."
                            )
                        ),
                        image = R.drawable.im_plant_1,
                    ),
                    day = 0,
                    taskState = listOf(
                        true,
                        false,
                        false,
                        false
                    )
                )
            )
        }
        _uiState.update {
            it.copy(isLoading = false)
        }
    }

    fun completeDay() {
        val plantProgress = uiState.value.plantProgress ?: return

        _uiState.update { it.copy(isLoading = true) }

        val nextDay = plantProgress.day + 1

        val updated = plantProgress.copy(
            day = nextDay,
            taskState = List(
                plantProgress.plant.tasksByDay[nextDay].tasks.size
            ) { false }
        )

        _uiState.update {
            it.copy(
                plantProgress = updated,
                isLoading = false
            )
        }
    }

    fun onTaskCompletionChange(index: Int) {
        val plantProgress = uiState.value.plantProgress ?: return

        _uiState.update { it.copy(isLoading = true) }

        val newTaskState = plantProgress.taskState.toMutableList().apply {
            if (index in indices) {
                this[index] = !this[index]
            }
        }

        val updatedPlantProgress = plantProgress.copy(
            taskState = newTaskState
        )

        _uiState.update {
            it.copy(
                plantProgress = updatedPlantProgress,
                isLoading = false
            )
        }
    }
}
