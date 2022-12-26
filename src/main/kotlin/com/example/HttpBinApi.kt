package com.example

import io.micronaut.http.annotation.Get
import io.micronaut.http.client.annotation.Client
import reactor.core.publisher.Mono

@Client("https://httpbin.org")
interface HttpBinApi {

    @Get("/get")
    fun asyncGet(): Mono<String>

    @Get("/get")
    fun syncGet(): String
}

