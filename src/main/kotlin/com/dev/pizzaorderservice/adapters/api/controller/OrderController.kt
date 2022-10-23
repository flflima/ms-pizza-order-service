package com.dev.pizzaorderservice.adapters.api.controller

import com.dev.pizzaorderservice.adapters.api.dto.OrderDto
import com.dev.pizzaorderservice.adapters.api.facade.OrderFacade
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Produces
import io.micronaut.validation.Validated
import jakarta.inject.Inject
import javax.validation.Valid

@Validated
@Controller("/orders")
class OrderController {

    @Inject
    lateinit var orderFacade: OrderFacade

    @Post
    @Produces(MediaType.APPLICATION_JSON)
    fun create(@Body @Valid order: OrderDto): HttpResponse<Any> {
        return HttpResponse.status<Any>(HttpStatus.CREATED).body(this.orderFacade.create(order))
    }
}