package com.example.hydropome.ui.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.example.hydropome.R
import com.example.hydropome.ui.theme.AppColors
import com.example.hydropome.ui.theme.HydropomeTheme

@Composable
fun ProfileScreen(
    state: ProfileUiState,
    onEditProfileClick: () -> Unit,
    onLogoutClick: () -> Unit,
    onOrderStatusClick: () -> Unit
) {
    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .background(AppColors.primary)
            ) {
                Column(
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .padding(start = 24.dp),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = state.name,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = AppColors.textLight
                    )
                    Text(
                        text = state.email,
                        fontSize = 14.sp,
                        color = AppColors.textLight
                    )
                }

                Button(
                    onClick = onEditProfileClick,
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(24.dp),
                    shape = RoundedCornerShape(20.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = AppColors.primary,
                        contentColor = AppColors.textLight
                    )
                ) {
                    Text(text = "Edit Profil", fontSize = 12.sp)
                }

                Box(
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(end = 24.dp, bottom = (-24).dp)
                        .size(56.dp)
                        .clip(CircleShape)
                        .background(AppColors.primary),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = state.avatarInitial,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        color = AppColors.textLight
                    )
                }
            }

            Spacer(modifier = Modifier.height(40.dp))

            // KARTU STATUS PESANAN
            Card(
                modifier = Modifier
                    .padding(horizontal = 24.dp)
                    .fillMaxWidth()
                    .clickable { onOrderStatusClick() },
                shape = RoundedCornerShape(16.dp)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = "Status Pesanan Marketplace",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = AppColors.text
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Icon(
                                painter = painterResource(id = R.drawable.paket),
                                contentDescription = null
                            )
                            Text(text = "Diproses", fontSize = 12.sp)
                        }
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Icon(
                                painter = painterResource(id = R.drawable.shipped),
                                contentDescription = null
                            )
                            Text(text = "Dikirim", fontSize = 12.sp)
                        }
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Icon(
                                painter = painterResource(id = R.drawable.status),
                                contentDescription = null
                            )
                            Text(text = "Selesai", fontSize = 12.sp)
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // PERSONLASI (Dummy)
            Card(
                modifier = Modifier
                    .padding(horizontal = 24.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(16.dp)
            ) {
                Row(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "Personalisasi")
                    Icon(
                        painter = painterResource(id = R.drawable.ill_plant_circle),
                        contentDescription = null
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // LOGOUT
            Card(
                modifier = Modifier
                    .padding(horizontal = 24.dp)
                    .fillMaxWidth()
                    .clickable { onLogoutClick() },
                shape = RoundedCornerShape(16.dp)
            ) {
                Row(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Logout",
                        color = AppColors.difficultyHard,
                        fontWeight = FontWeight.SemiBold
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.logout),
                        contentDescription = null
                    )
                }
            }
        }
    }
}

// ---------- PREVIEW ----------

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    val dummyState = ProfileUiState(
        isLoading = false,
        name = "Mellafesa",
        email = "mellafesa@gmail.com",
        avatarInitial = "M",
        selectedTab = OrderTab.DIPROSES,
        orders = emptyList()
    )

    HydropomeTheme {
        ProfileScreen(
            state = dummyState,
            onEditProfileClick = {},
            onLogoutClick = {},
            onOrderStatusClick = {}
        )
    }
}
