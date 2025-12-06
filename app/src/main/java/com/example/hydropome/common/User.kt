package com.example.hydropome.common

data class User(
    val name: String = "",
    val email: String = "",
    val preferences: Map<String, List<Int>> = mapOf()
)