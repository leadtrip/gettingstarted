package gettingstarted


import io.micronaut.test.extensions.spock.annotation.MicronautTest
import jakarta.inject.Inject
import spock.lang.Specification

@MicronautTest
class HelloServiceImplSpec extends Specification{

    @Inject
    HelloServiceImpl helloService

    void "test HelloServiceImpl"() {
        expect:
            "Hello World" == helloService.sayHello()
        and:
            "Hello Bob" == helloService.sayHello("Bob" )
    }
}
