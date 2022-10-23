package com.dev.pizzaorderservice.adapters.repository.model

import com.dev.pizzaorderservice.domain.model.Item

data class ItemLocalStorage(val id: Long,
                            val name: String,
                            val slug: String,
                            val price: Double,
                            val quantity: Int,
                            val size: String? = null)

fun ItemLocalStorage.toItem() = Item(this.id, this.name, this.slug, this.price, this.quantity, this.size)