package com.example.hydropome.ui.main

import androidx.annotation.DrawableRes
import com.example.hydropome.R

enum class NavItem(
    val title: String,
    @DrawableRes val icon: Int
) {
    HOME("Beranda", R.drawable.ic_home),
    MONITOR_PLANTS("Pantau Tanaman", R.drawable.ic_plant_fill),
    MARKETPLACE("Marketplace", R.drawable.ic_bag),
    PROFILE("Profile", R.drawable.ic_profile_circle)
}