package com.example.hydropome.common

data class Product(
    val id: String = "",
    val title: String = "",
    val image: String = "",
    val description: String = "",
    val regularPrice: Int = 0,
    val discountedPrice: Int? = null,
    val category: Category = Category.CUSTOMER_PRODUCT,
    val sellerContact: String? = null,
)