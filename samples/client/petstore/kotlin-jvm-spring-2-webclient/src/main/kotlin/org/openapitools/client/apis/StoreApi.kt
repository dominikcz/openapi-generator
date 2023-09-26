/**
 *
 * Please note:
 * This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 *
 */

@file:Suppress(
    "ArrayInDataClass",
    "EnumEntryName",
    "RemoveRedundantQualifierName",
    "UnusedImport"
)

package org.openapitools.client.apis

import com.fasterxml.jackson.annotation.JsonProperty

import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.WebClientResponseException
import org.springframework.http.codec.json.Jackson2JsonDecoder
import org.springframework.http.codec.json.Jackson2JsonEncoder
import org.springframework.http.ResponseEntity
import org.springframework.http.MediaType
import reactor.core.publisher.Mono

import org.openapitools.client.models.Order
import org.openapitools.client.infrastructure.*

class StoreApi(client: WebClient) : ApiClient(client) {

    constructor(baseUrl: String) : this(WebClient.builder()
        .baseUrl(baseUrl)
        .codecs {
            it.defaultCodecs().jackson2JsonEncoder(Jackson2JsonEncoder(Serializer.jacksonObjectMapper, MediaType.APPLICATION_JSON))
            it.defaultCodecs().jackson2JsonDecoder(Jackson2JsonDecoder(Serializer.jacksonObjectMapper, MediaType.APPLICATION_JSON))
        }
        .build()
    )


    @Throws(WebClientResponseException::class)
    fun deleteOrder(orderId: kotlin.String): Mono<Unit> {
        return deleteOrderWithHttpInfo(orderId = orderId)
            .map { it.body }
    }

    @Throws(WebClientResponseException::class)
    fun deleteOrderWithHttpInfo(orderId: kotlin.String): Mono<ResponseEntity<Unit>> {
        val localVariableConfig = deleteOrderRequestConfig(orderId = orderId)
        return request<Unit, Unit>(
            localVariableConfig
        )
    }

    fun deleteOrderRequestConfig(orderId: kotlin.String) : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery = mutableMapOf<kotlin.String, kotlin.collections.List<kotlin.String>>()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        
        return RequestConfig(
            method = RequestMethod.DELETE,
            path = "/store/order/{orderId}".replace("{"+"orderId"+"}", encodeURIComponent(orderId.toString())),
            query = localVariableQuery,
            headers = localVariableHeaders,
            requiresAuthentication = false,
            body = localVariableBody
        )
    }


    @Throws(WebClientResponseException::class)
    fun getInventory(): Mono<kotlin.collections.Map<kotlin.String, kotlin.Int>> {
        return getInventoryWithHttpInfo()
            .map { it.body }
    }

    @Throws(WebClientResponseException::class)
    fun getInventoryWithHttpInfo(): Mono<ResponseEntity<kotlin.collections.Map<kotlin.String, kotlin.Int>>> {
        val localVariableConfig = getInventoryRequestConfig()
        return request<Unit, kotlin.collections.Map<kotlin.String, kotlin.Int>>(
            localVariableConfig
        )
    }

    fun getInventoryRequestConfig() : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery = mutableMapOf<kotlin.String, kotlin.collections.List<kotlin.String>>()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Accept"] = "application/json"

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/store/inventory",
            query = localVariableQuery,
            headers = localVariableHeaders,
            requiresAuthentication = true,
            body = localVariableBody
        )
    }


    @Throws(WebClientResponseException::class)
    fun getOrderById(orderId: kotlin.Long): Mono<Order> {
        return getOrderByIdWithHttpInfo(orderId = orderId)
            .map { it.body }
    }

    @Throws(WebClientResponseException::class)
    fun getOrderByIdWithHttpInfo(orderId: kotlin.Long): Mono<ResponseEntity<Order>> {
        val localVariableConfig = getOrderByIdRequestConfig(orderId = orderId)
        return request<Unit, Order>(
            localVariableConfig
        )
    }

    fun getOrderByIdRequestConfig(orderId: kotlin.Long) : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery = mutableMapOf<kotlin.String, kotlin.collections.List<kotlin.String>>()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Accept"] = "application/xml, application/json"

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/store/order/{orderId}".replace("{"+"orderId"+"}", encodeURIComponent(orderId.toString())),
            query = localVariableQuery,
            headers = localVariableHeaders,
            requiresAuthentication = false,
            body = localVariableBody
        )
    }


    @Throws(WebClientResponseException::class)
    fun placeOrder(order: Order): Mono<Order> {
        return placeOrderWithHttpInfo(order = order)
            .map { it.body }
    }

    @Throws(WebClientResponseException::class)
    fun placeOrderWithHttpInfo(order: Order): Mono<ResponseEntity<Order>> {
        val localVariableConfig = placeOrderRequestConfig(order = order)
        return request<Order, Order>(
            localVariableConfig
        )
    }

    fun placeOrderRequestConfig(order: Order) : RequestConfig<Order> {
        val localVariableBody = order
        val localVariableQuery = mutableMapOf<kotlin.String, kotlin.collections.List<kotlin.String>>()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Content-Type"] = "application/json"
        localVariableHeaders["Accept"] = "application/xml, application/json"

        return RequestConfig(
            method = RequestMethod.POST,
            path = "/store/order",
            query = localVariableQuery,
            headers = localVariableHeaders,
            requiresAuthentication = false,
            body = localVariableBody
        )
    }

}
