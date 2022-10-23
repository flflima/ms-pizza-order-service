package com.dev.pizzaorderservice.domain.model

data class Order(val id: Long, val total: Double, val created_at: String, val items: List<Item>)
