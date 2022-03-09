package gettingstarted

import io.micronaut.context.annotation.Property
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import jakarta.inject.Inject
import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription
import spock.lang.AutoCleanup
import spock.lang.Shared
import spock.lang.Specification

@MicronautTest
@Property(name = 'greeting.prefix', value = 'Bonjour')
class SimpleControllerSpec extends Specification {

    @AutoCleanup
    @Shared
    @Inject
    @Client("/")
    HttpClient client

    void "test simple greeting action"() {
        expect:
            'Hello Jeff' == client.toBlocking().retrieve("/hello/Jeff")
    }

    void "test greeting no params"() {
        expect:
            'Hello World' == client.toBlocking().retrieve("/hello")
    }

    void "test time"() {
        expect:
            client.toBlocking().retrieve("/time")
    }

    void "test greet"() {
        expect:
            "Bonjour" == client.toBlocking().retrieve("/greet")
    }
}