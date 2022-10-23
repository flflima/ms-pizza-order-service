package com.dev.pizzaorderservice.adapters.api.dto

import com.dev.pizzaorderservice.domain.model.Order

data class OrderResponseDto(val message: String, val created_at: String) {
    companion object {
        fun from(order: Order) = OrderResponseDto("Pedido Criado!", order.created_at)
    }
}