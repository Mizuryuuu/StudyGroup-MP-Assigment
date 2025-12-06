package com.example.hydropome.common

data class PlantProgress (
    val id: String = "",
    val plant: Plant = Plant(),
    val day: Int = 0,
    val taskState: List<Boolean> = listOf()
) {
    fun toFirestore(): Map<String, Any> = mapOf(
        "id" to id,
        "plantId" to plant.id,
        "day" to day,
        "taskState" to taskState
    )

    companion object {
        @Suppress("UNCHECKED_CAST")
        fun fromFirestore(data: Map<String, Any>, plant: Plant): PlantProgress = PlantProgress(
            id = data["id"] as? String ?: "",
            plant = plant,
            day = (data["day"] as? Long ?: 0).toInt(),
            taskState = data["taskState"] as? List<Boolean> ?: emptyList()
        )
    }
}