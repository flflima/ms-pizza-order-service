package com.dev.pizzaorderservice.adapters.api.dto

import io.micronaut.core.annotation.Introspected
import javax.validation.constraints.NotNull

@Introspected
data class OrderDto(
    @field:NotNull
    val items: List<ItemDto>
)