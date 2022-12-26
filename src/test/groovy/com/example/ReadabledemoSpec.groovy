package com.example

import io.micronaut.http.HttpRequest
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import jakarta.inject.Inject
import spock.lang.Specification

@MicronautTest
class ReadabledemoSpec extends Specification {

    @Inject
    @Client('/')
    HttpClient client

    void 'should execute GET request and return true'() {
        when:
        def exists = client.toBlocking().retrieve(HttpRequest.GET('/'))

        then:
        exists == 'true'

    }

}
