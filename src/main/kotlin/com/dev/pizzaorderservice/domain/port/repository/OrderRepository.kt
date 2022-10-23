package com.dev.pizzaorderservice.domain.port.repository

import com.dev.pizzaorderservice.domain.model.Item
import com.dev.pizzaorderservice.domain.model.Order

interface OrderRepository {

    fun create(items: List<Item>, total: Double): Order

}