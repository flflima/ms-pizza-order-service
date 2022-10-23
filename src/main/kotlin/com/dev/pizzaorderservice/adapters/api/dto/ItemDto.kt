package com.dev.pizzaorderservice.adapters.api.dto

import com.dev.pizzaorderservice.domain.model.ItemPartial
import io.micronaut.core.annotation.Introspected
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Pattern

@Introspected
data class ItemDto(
    @field:NotBlank
    val id: Long,

    @field:NotBlank
    val quantity: Int,

    @field:Pattern(regexp = "^P|M|G\$")
    val size: String)

fun ItemDto.toItemPartial() = ItemPartial(this.id, this.quantity, this.size)
