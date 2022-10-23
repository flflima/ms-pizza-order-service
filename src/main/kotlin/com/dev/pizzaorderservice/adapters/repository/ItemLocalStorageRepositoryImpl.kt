package com.dev.pizzaorderservice.adapters.repository

import com.dev.pizzaorderservice.adapters.repository.model.ItemLocalStorage
import com.dev.pizzaorderservice.adapters.repository.model.toItem
import com.dev.pizzaorderservice.domain.model.Item
import com.dev.pizzaorderservice.domain.port.repository.ItemRepository
import jakarta.inject.Singleton

@Singleton
class ItemLocalStorageRepositoryImpl : ItemRepository {

    val items = listOf(
        ItemLocalStorage(1, "Pizza de quatro queijos", "pizza-quatro-queijo", 37.0, 0, "P")
    )

    override fun get(id: Long): Item {
        println(">>>> fetching item $id")
        return items.filter { it.id == id }.first().toItem()
    }
}