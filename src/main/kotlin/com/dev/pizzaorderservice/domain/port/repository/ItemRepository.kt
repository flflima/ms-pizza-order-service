package com.dev.pizzaorderservice.domain.port.repository

import com.dev.pizzaorderservice.domain.model.Item

interface ItemRepository {

    fun get(id: Long): Item

}