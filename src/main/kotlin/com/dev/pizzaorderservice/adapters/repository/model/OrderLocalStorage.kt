package com.dev.pizzaorderservice.adapters.repository.model

import com.dev.pizzaorderservice.domain.model.Item
import com.dev.pizzaorderservice.domain.model.Order

data class OrderLocalStorage(val id: Long, val total: Double, val created_at: String, val items: List<ItemLocalStorage>)

fun OrderLocalStorage.toOrder() = Order(this.id, this.total, this.created_at, this.items.map { it.toItem() })