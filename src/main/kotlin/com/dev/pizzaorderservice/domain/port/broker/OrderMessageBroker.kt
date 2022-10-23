package com.dev.pizzaorderservice.domain.port.broker

import com.dev.pizzaorderservice.domain.model.Order

interface OrderMessageBroker {

    fun sendOrder(order: Order)
}