package com.dev.pizzaorderservice.adapters.repository

import com.dev.pizzaorderservice.adapters.repository.model.ItemLocalStorage
import com.dev.pizzaorderservice.adapters.repository.model.OrderLocalStorage
import com.dev.pizzaorderservice.adapters.repository.model.toOrder
import com.dev.pizzaorderservice.domain.model.Item
import com.dev.pizzaorderservice.domain.model.Order
import com.dev.pizzaorderservice.domain.port.repository.OrderRepository
import jakarta.inject.Singleton
import java.time.LocalDateTime

@Singleton
class OrderLocalStorageRepositoryImpl : OrderRepository {

    val orders = mutableListOf<OrderLocalStorage>()

    override fun create(items: List<Item>, total: Double): Order {
        val order = OrderLocalStorage(
            orders.size + 1L,
            total,
            LocalDateTime.now().toString(),
            items.map { ItemLocalStorage(it.id, it.name, it.slug, it.price, it.quantity, it.size) })
        orders.add(order)

        println(">>>> creating new order ${order.toOrder()}")
        return order.toOrder()
    }
}