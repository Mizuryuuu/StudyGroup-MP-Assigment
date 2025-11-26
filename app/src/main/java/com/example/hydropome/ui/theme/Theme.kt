package com.example.hydropome.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// Skema warna utama aplikasi
private val LightColorScheme = lightColorScheme(
    primary = BrandGreen,
    background = IntBackground,
    surface = Color.White,
    onPrimary = TextLight,
    onBackground = TextDark,
    onSurface = TextDark
)

/**
 * Fungsi tema utama yang dipakai di MainActivity, Login, Register, dsb.
 */
@Composable
fun HydropomeTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = LightColorScheme,
        typography = Typography,   // Typography sudah ada di Type.kt
        content = content
    )
}
