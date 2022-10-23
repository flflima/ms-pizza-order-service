package com.dev.pizzaorderservice.adapters.broker

import com.dev.pizzaorderservice.domain.model.Order
import com.dev.pizzaorderservice.domain.port.broker.OrderMessageBroker
import jakarta.inject.Singleton

@Singleton
class OrderMessageBrokerLocalImpl: OrderMessageBroker {
    override fun sendOrder(order: Order) {
        println(">>>> sending to queue $order")
    }
}