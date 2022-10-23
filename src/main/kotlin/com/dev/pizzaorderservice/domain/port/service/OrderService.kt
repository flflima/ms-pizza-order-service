package com.dev.pizzaorderservice.domain.port.service

import com.dev.pizzaorderservice.domain.model.ItemPartial
import com.dev.pizzaorderservice.domain.model.Order

interface OrderService {

    fun create(items: List<ItemPartial>): Order
}