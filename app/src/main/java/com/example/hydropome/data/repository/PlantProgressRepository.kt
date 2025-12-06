package com.example.hydropome.data.repository

import com.example.hydropome.R
import com.example.hydropome.common.Difficulty
import com.example.hydropome.common.Plant
import com.example.hydropome.common.PlantProgress

class PlantProgressRepository {
    private val plantProgress: MutableList<PlantProgress> = mutableListOf(
        PlantProgress(
            id = "progress_001",
            plant = Plant(
                title = "Selada Hidroponik",
                difficulty = Difficulty.EASY,
                duration = "3-5",
                tasksByDay = listOf(
                    Plant.DailyTasks(
                        tasks = listOf(
                            "Siapkan Nutrisi & Air \uD83E\uDDEA",
                            "Rendam Rockwool \uD83E\uDDFC",
                            "Tanam Benih Selada \uD83C\uDF31",
                            "Tutup & Simpan ☁\uFE0F"
                        ),
                        tip = "Gunakan air tanpa kaporit untuk hasil terbaik!"
                    ),
                    Plant.DailyTasks(
                        tasks = listOf(
                            "Siapkan Nutrisi & Air \uD83E\uDDEA",
                            "Rendam Rockwool \uD83E\uDDFC",
                            "Tanam Benih Selada \uD83C\uDF31",
                            "Tutup & Simpan ☁\uFE0F"
                        ),
                        tip = "Gunakan air tanpa kaporit untuk hasil terbaik!"
                    ),
                    Plant.DailyTasks(),
                    Plant.DailyTasks(),
                    Plant.DailyTasks(),
                    Plant.DailyTasks(),
                    Plant.DailyTasks(),
                ),
                image = R.drawable.im_plant_1
            ),
            day = 2,
            taskState = listOf(true, false, false)
        )
    )

    fun getPlantProgress(id: String): PlantProgress? {
        val targetPlantProgress = plantProgress.find {
            it.id == id
        }
        return targetPlantProgress
    }
}