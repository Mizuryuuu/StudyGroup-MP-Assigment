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

@Composable
fun AppNavHost() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AppDestination.Personalization
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

        composable<AppDestination.Main> {

        }
    }
}