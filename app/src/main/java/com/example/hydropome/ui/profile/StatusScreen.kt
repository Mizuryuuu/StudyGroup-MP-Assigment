package com.example.hydropome.ui.profile

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hydropome.R
import com.example.hydropome.ui.theme.AbuabuText
import com.example.hydropome.ui.theme.AppColors
import com.example.hydropome.ui.theme.HydropomeTheme

@Composable
fun OrderStatusScreen(
    state: ProfileUiState,
    onBackClick: () -> Unit,
    onTabSelected: (OrderTab) -> Unit
) {
    // Pesanan yang ditampilkan sesuai tab yang dipilih
    val ordersForSelectedTab = state.orders.filter { it.status == state.selectedTab }

    Scaffold(
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = onBackClick) {
                    Icon(
                        painter = painterResource(id = R.drawable.outline_arrow_left_alt_24),
                        contentDescription = "Kembali"
                    )
                }
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Status Pesanan",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = AppColors.text
                )
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 24.dp)
                .fillMaxSize()
        ) {

            Spacer(modifier = Modifier.height(16.dp))

            // ====== TAB STATUS: DIPROSES / DIKIRIM / SELESAI ======
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                StatusTabChip(
                    text = "Diproses",
                    selected = state.selectedTab == OrderTab.DIPROSES,
                    onClick = { onTabSelected(OrderTab.DIPROSES) }
                )
                StatusTabChip(
                    text = "Dikirim",
                    selected = state.selectedTab == OrderTab.DIKIRIM,
                    onClick = { onTabSelected(OrderTab.DIKIRIM) }
                )
                StatusTabChip(
                    text = "Selesai",
                    selected = state.selectedTab == OrderTab.SELESAI,
                    onClick = { onTabSelected(OrderTab.SELESAI) }
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            // ====== KARTU PESANAN (contoh satu kartu) ======
            ordersForSelectedTab.firstOrNull()?.let { order ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(
                            text = order.title,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = AppColors.text
                        )

                        Spacer(modifier = Modifier.height(4.dp))

                        Text(
                            text = order.price,
                            fontSize = 12.sp,
                            color = AbuabuText // abu-abu teks dari palet kamu
                        )

                        Spacer(modifier = Modifier.height(12.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "1 produk",
                                fontSize = 12.sp,
                                color = AbuabuText
                            )
                            Text(
                                text = "Total: ${order.total}",
                                fontSize = 14.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = AppColors.primary // hijau utama
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun StatusTabChip(
    text: String,
    selected: Boolean,
    onClick: () -> Unit
) {
    // Chip tab: kalau selected → hijau, kalau tidak → putih dengan border hijau
    Button(
        onClick = onClick,
        modifier = Modifier
            .height(36.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = if (selected) AppColors.primary else AppColors.textLight,
            contentColor = if (selected) AppColors.textLight else AppColors.primary
        ),
        border = if (selected) null else ButtonDefaults.outlinedButtonBorder
    ) {
        Text(
            text = text,
            fontSize = 12.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Preview(showBackground = true)
@Composable
fun OrderStatusScreenPreview() {
    val dummyOrders = listOf(
        OrderItemUi(
            id = "1",
            title = "Paket Lengkap",
            price = "Rp 25.000",
            total = "Rp 35.000",
            status = OrderTab.DIPROSES
        )
    )

    val dummyState = ProfileUiState(
        isLoading = false,
        name = "Mellafesa",
        email = "mellafesa@gmail.com",
        avatarInitial = "M",
        selectedTab = OrderTab.DIPROSES,
        orders = dummyOrders
    )

    HydropomeTheme {
        OrderStatusScreen(
            state = dummyState,
            onBackClick = {},
            onTabSelected = {}
        )
    }
}
