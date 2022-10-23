package com.dev.pizzaorderservice.domain.model

data class Item(
    val id: Long,
    val name: String,
    val slug: String,
    val price: Double,
    val quantity: Int,
    val size: String? = null
)
