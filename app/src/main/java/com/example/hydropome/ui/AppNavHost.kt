package com.example.hydropome.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.hydropome.ui.personalization.PersonalizationScreen
import com.example.hydropome.ui.personalization.PersonalizationViewModel
import com.example.hydropome.ui.plantprogress.PlantProgressScreen
import com.example.hydropome.ui.plantprogress.PlantProgressUiState
import com.example.hydropome.ui.plantprogress.PlantProgressViewModel

@Composable
fun AppNavHost() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AppDestination.PlantProgress("plant_01")
    ) {
        composable<AppDestination.Personalization> {
            val viewModel: PersonalizationViewModel = viewModel()
            val uiState by viewModel.uiState.collectAsState()

            PersonalizationScreen(
                uiState = uiState,
                onNextPage = viewModel::incrementPage,
                onPreviousPage = viewModel::decrementPage,
                onSelectedAnswerChange = viewModel::changeSelectedAnswers,
                navController = navController
            )
        }

        composable<AppDestination.PlantProgress> {
            val viewModel: PlantProgressViewModel = viewModel()
            val uiState by viewModel.uiState.collectAsState()

            PlantProgressScreen(
                plantProgressId = "progress_001",
                uiState = uiState,

                onPlantProgressRefresh = viewModel::getIdPlantProgress,
                onTaskCompletionChange = viewModel::onTaskCompletionChange,
                onCompleteDay = { },
                onCompleteProgress = { _ -> },

                navController = navController
            )
        }
    }
}