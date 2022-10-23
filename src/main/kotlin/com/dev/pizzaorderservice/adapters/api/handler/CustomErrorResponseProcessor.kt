package com.dev.pizzaorderservice.adapters.api.handler

import com.dev.pizzaorderservice.adapters.api.dto.error.ApiErrorDto
import io.micronaut.context.annotation.Replaces
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.MediaType
import io.micronaut.http.MutableHttpResponse
import io.micronaut.http.server.exceptions.response.ErrorContext
import io.micronaut.http.server.exceptions.response.ErrorResponseProcessor
import io.micronaut.http.server.exceptions.response.HateoasErrorResponseProcessor
import jakarta.inject.Singleton

@Singleton
@Replaces(HateoasErrorResponseProcessor::class)
class CustomErrorResponseProcessor : ErrorResponseProcessor<ApiErrorDto> {
    override fun processResponse(
        errorContext: ErrorContext,
        response: MutableHttpResponse<*>
    ): MutableHttpResponse<ApiErrorDto> {
// to be logged
//        val errors = errorContext.errors.joinToString { it.message }
//        val rootCause: Throwable? = if (errorContext.rootCause.isPresent) errorContext.rootCause.get() else null

        return if (response.code() in 400..499) {
            HttpResponse.serverError(ApiErrorDto(response.code(),"bad_request"))
                .contentType(MediaType.APPLICATION_JSON_TYPE)
                .status(response.status)
        } else {
            val internalServerError = ApiErrorDto(response.code(),"Internal server error.")
            HttpResponse.serverError(internalServerError)
                .contentType(MediaType.APPLICATION_JSON_TYPE)
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }
}