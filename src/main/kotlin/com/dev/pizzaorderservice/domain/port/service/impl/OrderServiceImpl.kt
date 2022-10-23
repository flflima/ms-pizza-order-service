package com.dev.pizzaorderservice.domain.port.service.impl

import com.dev.pizzaorderservice.domain.model.ItemPartial
import com.dev.pizzaorderservice.domain.model.Order
import com.dev.pizzaorderservice.domain.port.broker.OrderMessageBroker
import com.dev.pizzaorderservice.domain.port.repository.ItemRepository
import com.dev.pizzaorderservice.domain.port.repository.OrderRepository
import com.dev.pizzaorderservice.domain.port.service.OrderService
import jakarta.inject.Inject
import jakarta.inject.Singleton

@Singleton
class OrderServiceImpl : OrderService {

    @Inject
    lateinit var orderRepository: OrderRepository

    @Inject
    lateinit var itemRepository: ItemRepository

    @Inject
    lateinit var orderMessageBroker: OrderMessageBroker

    override fun create(items: List<ItemPartial>): Order {
        return items.map {
            val item = itemRepository.get(it.id)
            item.copy(quantity = it.quantity)
        }.let {
            val total = it.map { it.price * it.quantity }.fold(0.0) { sum, price ->
                sum + price
            }
            orderRepository.create(it, total)
        }.apply {
            orderMessageBroker.sendOrder(this)
        }
    }
}
