package com.example.hydropome.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.hydropome.ui.home.HomeScreen
import com.example.hydropome.ui.home.HomeViewModel
import com.example.hydropome.ui.home.LamanTanamanScreen
import com.example.hydropome.ui.home.LamanTanamanViewModel
import com.example.hydropome.ui.login.LoginScreen
import com.example.hydropome.ui.main.MainScreen
import com.example.hydropome.ui.main.MainViewModel
import com.example.hydropome.ui.monitorplants.MonitorPlantsScreen
import com.example.hydropome.ui.monitorplants.MonitorPlantsViewModel
import com.example.hydropome.ui.onboarding.OnBoardingScreen
import com.example.hydropome.ui.onboarding.OnBoardingViewModel
import com.example.hydropome.ui.personalization.PersonalizationScreen
import com.example.hydropome.ui.personalization.PersonalizationViewModel
import com.example.hydropome.ui.plantprogress.PlantProgressScreen
import com.example.hydropome.ui.plantprogress.PlantProgressUiState
import com.example.hydropome.ui.plantprogress.PlantProgressViewModel
import com.example.hydropome.ui.register.RegisterScreen
import com.example.hydropome.ui.splash.SplashScreen

@Composable
fun AppNavHost() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AppDestination.Splash
    ) {
        composable<AppDestination.Splash> {
            SplashScreen(
                isLoggedIn = { false },
                navController = navController
            )
        }

        composable<AppDestination.Onboarding> {
            val viewModel: OnBoardingViewModel = viewModel()
            val uiState by viewModel.uiState.collectAsState()

            OnBoardingScreen(
                uiState = uiState,
                onNextPage = viewModel::incrementPage,
                onPreviousPage = viewModel::decrementPage,
                navController = navController
            )
        }

        composable<AppDestination.Login> {
            LoginScreen(
                navController = navController
            )
        }

        composable<AppDestination.Register> {
            RegisterScreen(
                navController = navController
            )
        }

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
            val mainViewModel: MainViewModel = viewModel()
            val mainUiState by mainViewModel.uiState.collectAsState()

            val homeViewModel: HomeViewModel = viewModel()
            val homeUiState by homeViewModel.uiState.collectAsState()

            val monitorPlantsViewModel: MonitorPlantsViewModel = viewModel()
            val monitorPlantsUiState by monitorPlantsViewModel.uiState.collectAsState()

            MainScreen(
                uiState = mainUiState,
                homeScreen = {
                    HomeScreen(
                        uiState = homeUiState,
                        onUserRefresh = {},
                        onSearchQueryChange = homeViewModel::search,
                        onPlantsRefresh = homeViewModel::refreshPlants,
                        onFlashSaleProductsRefresh = homeViewModel::refreshFlashSaleProducts,
                        navController = navController
                    )
                },
                monitorPlantsScreen = {
                    MonitorPlantsScreen(
                        uiState = monitorPlantsUiState,
                        onPlantProgressesRefresh = monitorPlantsViewModel::refreshPlantProgresses,
                        onSearchQueryChange = monitorPlantsViewModel::search,
                        navController = navController
                    )
                },
                marketplaceScreen = {},
                profileScreen = {},
                onSelectedNavItemChange = mainViewModel::changeSelectedIndex
            )

        }

        composable<AppDestination.PlantDetails> {
            val args = it.toRoute<AppDestination.PlantDetails>()
            val viewModel: LamanTanamanViewModel = viewModel()
            val uiState by viewModel.uiState.collectAsState()

            LamanTanamanScreen(
                plantId = args.plantId,
                isStartPlantEnabled = args.isStartPlantEnabled,
                uiState = uiState,
                videoPlayer = { url ->

                },
                onPlantRefresh = viewModel::refreshPlant,
                onStartPlant = {

                },
                navController = navController
            )
        }

        composable<AppDestination.PlantProgress> {
            val args = it.toRoute<AppDestination.PlantProgress>()
            val viewModel: PlantProgressViewModel = viewModel()
            val uiState by viewModel.uiState.collectAsState()

            PlantProgressScreen(
                plantProgressId = args.plantProgressId,
                uiState = uiState,
                onPlantProgressRefresh = viewModel::refreshPlantProgress,
                onTaskCompletionChange = viewModel::onTaskCompletionChange,
                onCompleteDay = viewModel::completeDay,
                onCompleteProgress = { _ -> },
                navController = navController
            )
        }

        composable<AppDestination.ProductDetails> {

        }
    }
}