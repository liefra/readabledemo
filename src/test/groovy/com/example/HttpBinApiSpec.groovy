package com.example

import io.micronaut.test.extensions.spock.annotation.MicronautTest
import jakarta.inject.Inject
import spock.lang.Specification



@MicronautTest
class HttpBinApiSpec extends Specification {

    @Inject
    HttpBinApi api


    def "Should execute the async HttpBin get request and return json as string"() {
        when:
        def jsonString = api.asyncGet().block()

        then:
        noExceptionThrown()
    }

    def "Should execute the sync HttpBin get request and return json as string"() {
        when:
        def jsonString = api.syncGet()

        then:
        noExceptionThrown()
    }
}
