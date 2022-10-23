package com.dev.pizzaorderservice.adapters.api.facade

import com.dev.pizzaorderservice.adapters.api.dto.OrderDto
import com.dev.pizzaorderservice.adapters.api.dto.OrderResponseDto
import com.dev.pizzaorderservice.adapters.api.dto.toItemPartial
import com.dev.pizzaorderservice.domain.port.service.OrderService
import jakarta.inject.Inject
import jakarta.inject.Singleton

@Singleton
class OrderFacade {

    @Inject
    lateinit var orderService: OrderService

    fun create(orderDto: OrderDto): OrderResponseDto {
        val order = this.orderService.create(orderDto.items.map { it.toItemPartial() })
        return OrderResponseDto.from(order)
    }
}