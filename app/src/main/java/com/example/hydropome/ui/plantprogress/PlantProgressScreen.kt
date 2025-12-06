package com.example.hydropome.ui.plantprogress

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
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
import com.example.hydropome.ui.common.components.CustomButtonVariant
import com.example.hydropome.ui.common.components.TitleBar
import com.example.hydropome.ui.common.shape.BottomArcShape
import com.example.hydropome.ui.theme.AppColors
import com.example.hydropome.ui.theme.HydropomeTheme
import com.example.hydropome.ui.theme.plusJakartaSansFontFamily

@Composable
fun PlantProgressScreen(
    plantProgressId: String,
    uiState: PlantProgressUiState,
    onPlantProgressRefresh: (String) -> Unit,
    onTaskCompletionChange: (Int) -> Unit,
    onCompleteDay: () -> Unit,
    onCompleteProgress: (() -> Unit) -> Unit,
    navController: NavController
) {
    LaunchedEffect(Unit) {
        onPlantProgressRefresh(plantProgressId)
    }

    Scaffold(
        topBar = {
            TitleBar(
                title = "Pantau Tanaman",
                onNavigationActionClick = {
                    navController.popBackStack(
                        AppDestination.PlantProgress(plantProgressId),
                        true
                    )
                }
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = innerPadding.calculateTopPadding())
        ) {
            val scrollState = rememberScrollState()

            uiState.plantProgress?.let { plantProgress ->
                AnimatedVisibility(
                    visible = scrollState.value == 0,
                    enter = fadeIn() + expandVertically(),
                    exit = shrinkVertically() + fadeOut()
                ) {
                    Image(
                        painter = painterResource(plantProgress.plant.image),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(235.dp)
                            .clip(BottomArcShape()),
                        contentScale = ContentScale.Crop
                    )
                }
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(scrollState)
                        .padding(bottom = innerPadding.calculateBottomPadding())
                ) {
                    Spacer(Modifier.height(235.dp + 20.dp))
                    Text(
                        text = plantProgress.plant.title,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.W700,
                        color = AppColors.text,
                        modifier = Modifier.padding(horizontal = 20.dp),
                        fontFamily = plusJakartaSansFontFamily
                    )
                    Spacer(Modifier.height(12.dp))
                    Row(
                        modifier = Modifier
                            .padding(horizontal = 20.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        val difficultyColor = when (plantProgress.plant.difficulty) {
                            Difficulty.EASY -> AppColors.difficultyEasy
                            Difficulty.MEDIUM -> AppColors.difficultyMedium
                            Difficulty.HARD -> AppColors.difficultyHard
                        }

                        Box(
                            modifier = Modifier
                                .size(12.dp)
                                .clip(CircleShape)
                                .background(difficultyColor)
                        )
                        Spacer(Modifier.width(4.dp))
                        Text(
                            text = plantProgress.plant.difficulty.label,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.W400,
                            color = difficultyColor,
                            fontFamily = plusJakartaSansFontFamily
                        )
                        Spacer(Modifier.width(16.dp))
                        Icon(
                            painter = painterResource(id = R.drawable.ic_plant_fill),
                            contentDescription = null,
                            modifier = Modifier
                                .size(18.dp),
                            tint = AppColors.primary
                        )
                        Spacer(Modifier.width(4.dp))
                        Text(
                            text = "Hari ke-${plantProgress.day + 1}",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.W400,
                            fontFamily = plusJakartaSansFontFamily
                        )
                    }
                    Spacer(Modifier.height(20.dp))
                    Box(
                        modifier = Modifier
                            .padding(horizontal = 12.dp)
                            .fillMaxWidth()
                            .shadow(
                                elevation = 8.dp,
                                shape = RoundedCornerShape(16.dp),
                                ambientColor = Color.Black.copy(alpha = 0.4f),
                                spotColor = Color.Black.copy(alpha = 0.4f)
                            )
                            .clip(RoundedCornerShape(16.dp))
                            .background(Color(0xFFFFFFFF))
                    ) {
                        Image(
                            painter = painterResource(R.drawable.freepik__tree__inject_3),
                            contentDescription = null,
                            modifier = Modifier
                                .align(Alignment.BottomEnd)
                                .padding(end = 12.dp)
                                .width(64.dp),
                            contentScale = ContentScale.FillWidth
                        )
                        Column(
                            modifier = Modifier
                                .padding(12.dp)
                                .padding(end = 88.dp)
                                .align(Alignment.CenterStart)
                        ) {
                            Text(
                                text = "Progress Menanam",
                                color = AppColors.text,
                                fontSize = 14.sp,
                                fontFamily = plusJakartaSansFontFamily,
                                fontWeight = FontWeight.W700,
                            )
                            Spacer(Modifier.height(12.dp))
                            Text(
                                text = "Ayo mulai menanam!",
                                color = AppColors.text,
                                fontSize = 12.sp,
                                fontFamily = plusJakartaSansFontFamily,
                                fontWeight = FontWeight.W400,
                            )
                            Spacer(Modifier.height(8.dp))

                            val progress =
                                plantProgress.day.toFloat() / (plantProgress.plant.tasksByDay.size)
                            val progressColor =
                                if (progress < 0.5) Color(0xFFFB9A23) else AppColors.primary
                            val progressContainerColor =
                                if (progress < 0.5) Color(0xFFFFF5E9) else Color(0xFFE8F5F2)

                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(8.dp)
                                    .clip(CircleShape)
                                    .background(progressContainerColor)
                            ) {
                                Box(
                                    modifier = Modifier
                                        .fillMaxHeight()
                                        .fillMaxWidth(progress)
                                        .clip(CircleShape)
                                        .background(progressColor)
                                )
                            }
                            Spacer(Modifier.height(8.dp))
                            Text(
                                text = "${(progress * 100).toInt()}% Selesai",
                                color = progressColor,
                                fontSize = 12.sp,
                                fontFamily = plusJakartaSansFontFamily,
                                fontWeight = FontWeight.W600
                            )
                        }
                    }
                    Spacer(Modifier.height(28.dp))

                    val lazyListState = rememberLazyListState()

                    LaunchedEffect(plantProgress.day) {
                        lazyListState.animateScrollToItem(plantProgress.day)
                    }

                    LazyRow(
                        state = lazyListState,
                        contentPadding = PaddingValues(horizontal = 20.dp),
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        items(plantProgress.plant.tasksByDay.size) { index ->
                            Column(
                                modifier = Modifier
                                    .width(54.dp)
                                    .height(64.dp)
                                    .clip(RoundedCornerShape(100.dp))
                                    .background(
                                        if (index == plantProgress.day) {
                                            AppColors.primary
                                        } else {
                                            Color(0xFFE8F5F2)
                                        }
                                    ),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                val textColor =
                                    if (index == plantProgress.day) Color(0xFFE8F5F2) else AppColors.primary

                                Text(
                                    text = "Hari",
                                    color = textColor,
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.W600,
                                    fontFamily = plusJakartaSansFontFamily
                                )
                                Text(
                                    text = (index + 1).let {
                                        if (it < 10) "0$it" else it.toString()
                                    },
                                    color = textColor,
                                    fontSize = 12.sp,
                                    fontFamily = plusJakartaSansFontFamily,
                                    fontWeight = FontWeight.W600,
                                )
                            }
                        }
                    }
                    Spacer(Modifier.height(28.dp))
                    Column(
                        modifier = Modifier
                            .padding(horizontal = 20.dp)
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
                            text = "\uD83D\uDCCC Tugas Hari ke-${plantProgress.day + 1}",
                            color = AppColors.text,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.W700,
                            fontFamily = plusJakartaSansFontFamily
                        )
                        Spacer(Modifier.height(8.dp))
                        plantProgress.plant.tasksByDay[plantProgress.day].tasks.forEachIndexed { index, task ->
                            Spacer(Modifier.height(8.dp))
                            Row(
                                modifier = Modifier
                                    .clickable(
                                        interactionSource = remember { MutableInteractionSource() },
                                        indication = null,
                                        onClick = {
                                            onTaskCompletionChange(index)
                                        }
                                    ),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    painter =
                                        if (plantProgress.taskState[index]) painterResource(R.drawable.ic_checkbox_selected) else painterResource(
                                            R.drawable.ic_checkbox_unselected
                                        ),
                                    contentDescription = null,
                                    modifier = Modifier.size(24.dp),
                                    tint = if (plantProgress.taskState[index]) AppColors.primary else Color(
                                        0xFFB4B5B6
                                    )
                                )
                                Spacer(Modifier.width(4.dp))
                                Text(
                                    text = task,
                                    fontFamily = plusJakartaSansFontFamily,
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.W400,
                                    color = AppColors.text
                                )
                            }
                        }
                        Spacer(Modifier.height(16.dp))
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
                                text = "Tips Hari Ini: ",
                                fontFamily = plusJakartaSansFontFamily,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.W700,
                                color = AppColors.text
                            )
                        }
                        Spacer(Modifier.height(8.dp))
                        Text(
                            text = plantProgress.plant.tasksByDay[plantProgress.day].tip,
                            fontFamily = plusJakartaSansFontFamily,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.W400,
                            color = AppColors.text
                        )
                    }
                    Spacer(Modifier.height(24.dp))
                    Image(
                        painter = painterResource(R.drawable.img_ad),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp)
                            .clip(RoundedCornerShape(16.dp)),
                        contentScale = ContentScale.FillWidth
                    )
                    Spacer(Modifier.height(32.dp))
                    CustomButtonVariant(
                        text = "Lihat Panduan",
                        onClick = {
                            AppDestination.PlantDetails(
                                plantProgress.plant.id,
                                false
                            )
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp)
                    )
                    Spacer(Modifier.height(12.dp))
                    CustomButton(
                        text = buildString {
                            if (plantProgress.day < plantProgress.plant.tasksByDay.size - 1) {
                                append("Hari ke-${plantProgress.day + 1} ")
                            }
                            append("Selesai")
                        },
                        onClick = {
                            if (plantProgress.day < plantProgress.plant.tasksByDay.size - 1) {
                                onCompleteDay()
                            } else {
                                onCompleteProgress {
                                    navController.popBackStack(
                                        AppDestination.PlantProgress(
                                            plantProgressId
                                        ),
                                        true
                                    )
                                }
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp),
                        isEnabled = plantProgress.taskState.all { it }
                    )
                    Spacer(Modifier.height(20.dp))
                }
            }
        }
    }
}

@Preview(device = "spec:width=1080px,height=3620px,dpi=440")
@Composable
private fun PlantProgressScreenPreview() {
    HydropomeTheme {
        PlantProgressScreen(
            plantProgressId = "",
            uiState = PlantProgressUiState(
                plantProgress = PlantProgress(
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
                    day = 1,
                    taskState = listOf(
                        true,
                        false,
                        false,
                        false
                    )
                )
            ),
            onPlantProgressRefresh = {},
            onTaskCompletionChange = {_ ->},
            onCompleteDay = {},
            onCompleteProgress = {},
            navController = rememberNavController()
        )
    }
}