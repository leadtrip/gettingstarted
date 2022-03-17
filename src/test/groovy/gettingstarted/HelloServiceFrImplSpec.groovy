package gettingstarted

import io.micronaut.test.annotation.MockBean
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import jakarta.inject.Inject
import spock.lang.Specification

@MicronautTest
class HelloServiceFrImplSpec extends Specification{

    @Inject
    HelloServiceFrImpl helloService

    void "test HelloServiceFrImpl"() {
        when:
            def res = helloService.sayHello(null )
        then:
            1 * helloService.sayHello(null ) >> "Salut le monde"
            res == "Salut le monde"
    }

    @MockBean(HelloServiceFrImpl)           // use mock, no reason here to here of course, just testing out
    HelloServiceFrImpl helloService() {
        Mock(HelloServiceFrImpl)
    }
}
