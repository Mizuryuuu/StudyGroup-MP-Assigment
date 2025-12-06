package com.example.hydropome.ui.monitorplants

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.hydropome.R
import com.example.hydropome.common.Difficulty
import com.example.hydropome.common.Plant
import com.example.hydropome.common.PlantProgress
import com.example.hydropome.ui.AppDestination
import com.example.hydropome.ui.common.components.CustomButton
import com.example.hydropome.ui.common.components.SearchBox
import com.example.hydropome.ui.common.shape.BottomArcShape
import com.example.hydropome.ui.theme.AppColors
import com.example.hydropome.ui.theme.HydropomeTheme
import com.example.hydropome.ui.theme.plusJakartaSansFontFamily

@Composable
fun MonitorPlantsScreen(
    uiState: MonitorPlantsUiState,
    onPlantProgressesRefresh: () -> Unit,
    onSearchQueryChange: (String) -> Unit,
    navController: NavController
) {
    LaunchedEffect(Unit) {
        onPlantProgressesRefresh()
    }

    AnimatedVisibility(
        visible = uiState.isLoading,
        enter = fadeIn(),
        exit = fadeOut()
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = WindowInsets.statusBars.asPaddingValues().calculateTopPadding()),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    }
    AnimatedVisibility(
        visible = !uiState.isLoading,
        enter = fadeIn(),
        exit = fadeOut()
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            val scrollState = rememberScrollState()

            AnimatedVisibility(
                visible = scrollState.value == 0,
                enter = fadeIn() + expandVertically(),
                exit = shrinkVertically() + fadeOut()
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(
                            WindowInsets.statusBars.asPaddingValues()
                                .calculateTopPadding() + 152.dp
                        )
                        .clip(BottomArcShape())
                        .background(AppColors.background)
                ) {
                    Image(
                        painter = painterResource(R.drawable.freepik__tree__inject_3),
                        contentDescription = null,
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .padding(end = 28.dp)
                            .width(96.dp),
                        contentScale = ContentScale.FillWidth
                    )
                }
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(scrollState)
                        .padding(
                            start = 20.dp,
                            top = WindowInsets.statusBars.asPaddingValues()
                                .calculateTopPadding() + 28.dp,
                            end = 20.dp,
                            bottom = 28.dp
                        )
                ) {
                    Text(
                        text = "Bagaimana Kabar Tanamanmu Hari Ini?",
                        modifier = Modifier.padding(end = 120.dp),
                        color = AppColors.textLight,
                        fontSize = 20.sp,
                        fontFamily = plusJakartaSansFontFamily,
                        fontWeight = FontWeight.W700
                    )
                    Spacer(Modifier.height(28.dp))
                    SearchBox(
                        value = uiState.searchQuery,
                        onValueChange = onSearchQueryChange,
                        placeholder = "Cari Tanaman kamu. . .",
                        containerColor = Color(0xFFF7F8F9),
                        modifier = Modifier.fillMaxWidth(),
                        isShadowEnabled = true
                    )
                    Spacer(Modifier.height(20.dp))
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .shadow(
                                elevation = 8.dp,
                                shape = RoundedCornerShape(12.dp),
                                ambientColor = Color.Black.copy(alpha = 0.4f),
                                spotColor = Color.Black.copy(alpha = 0.4f)
                            )
                            .clip(RoundedCornerShape(12.dp))
                            .background(Color(0xFFFFFFFF))
                            .padding(12.dp)
                    ) {
                        Text(
                            text = "Daftar Tanamanmu",
                            modifier = Modifier.padding(end = 120.dp),
                            color = AppColors.text,
                            fontSize = 14.sp,
                            fontFamily = plusJakartaSansFontFamily,
                            fontWeight = FontWeight.W700
                        )
                        if (uiState.plantProgresses.isNotEmpty()) {
                            uiState.plantProgresses.forEachIndexed { index, plantsProgress ->
                                Spacer(Modifier.height(16.dp))
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(72.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Image(
                                        painter = painterResource(id = plantsProgress.plant.image),
                                        contentDescription = null,
                                        modifier = Modifier
                                            .fillMaxHeight()
                                            .aspectRatio(1f)
                                            .clip(RoundedCornerShape(10.dp)),
                                        contentScale = ContentScale.Crop
                                    )
                                    Spacer(Modifier.width(12.dp))
                                    Column(
                                        modifier = Modifier.fillMaxHeight(),
                                        verticalArrangement = Arrangement.SpaceBetween
                                    ) {
                                        Text(
                                            text = plantsProgress.plant.title,
                                            color = AppColors.text,
                                            fontSize = 14.sp,
                                            fontWeight = FontWeight.W600,
                                            overflow = TextOverflow.Ellipsis,
                                            maxLines = 1
                                        )
                                        Row(
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {
                                            val difficultyColor =
                                                when (plantsProgress.plant.difficulty) {
                                                    Difficulty.EASY -> AppColors.difficultyEasy
                                                    Difficulty.MEDIUM -> AppColors.difficultyMedium
                                                    Difficulty.HARD -> AppColors.difficultyHard
                                                }
                                            Box(
                                                modifier = Modifier
                                                    .size(10.dp)
                                                    .clip(CircleShape)
                                                    .background(difficultyColor)
                                            )
                                            Spacer(Modifier.width(4.dp))
                                            Text(
                                                text = plantsProgress.plant.difficulty.label,
                                                color = difficultyColor,
                                                fontSize = 12.sp,
                                                fontWeight = FontWeight.W400,
                                                fontFamily = plusJakartaSansFontFamily
                                            )
                                        }
                                        Row(
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {
                                            Icon(
                                                painter = painterResource(R.drawable.ic_plant_fill),
                                                contentDescription = null,
                                                modifier = Modifier.size(18.dp),
                                                tint = AppColors.primary
                                            )
                                            Spacer(Modifier.width(4.dp))
                                            Text(
                                                text = "Hari ke-${plantsProgress.day + 1}",
                                                color = AppColors.text,
                                                fontSize = 12.sp,
                                                fontWeight = FontWeight.W400
                                            )
                                        }
                                    }
                                    Spacer(Modifier.weight(1f))
                                    CustomButton(
                                        text = "Pantau",
                                        onClick = {
                                            navController.navigate(
                                                AppDestination.PlantProgress(
                                                    plantsProgress.id
                                                )
                                            )
                                        },
                                        width = 64.dp,
                                        height = 36.dp,
                                        radius = 12.dp,
                                        paddingHorizontal = 0.dp,
                                        fontSize = 12.sp
                                    )
                                }
                                if (index + 1 < uiState.plantProgresses.size) {
                                    Spacer(Modifier.height(16.dp))
                                    HorizontalDivider(
                                        thickness = 1.dp,
                                        color = Color(0xFFEDEDED)
                                    )
                                }
                            }
                        } else {
                            Spacer(Modifier.height(88.dp))
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun MonitorPlantsPreview() {
    HydropomeTheme {
        Surface {
            MonitorPlantsScreen(
                uiState = MonitorPlantsUiState(
                    plantProgresses = listOf(
                        PlantProgress(
                            plant = Plant(
                                title = "Selada Hidroponik",
                                difficulty = Difficulty.EASY,
                                duration = "3-5",
                                image = R.drawable.selada_hidroponik,
                            )
                        ),
                        PlantProgress(
                            plant = Plant(
                                title = "Bayam Hidroponik",
                                difficulty = Difficulty.MEDIUM,
                                duration = "3-4",
                                image = R.drawable.bayam_hidroponik,
                            ),
                            day = 4
                        )
                    )
                ),
                onPlantProgressesRefresh = {},
                onSearchQueryChange = {},
                navController = rememberNavController()
            )
        }
    }
}