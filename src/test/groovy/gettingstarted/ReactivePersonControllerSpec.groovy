package gettingstarted

import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import jakarta.inject.Inject
import spock.lang.Specification

@MicronautTest
class ReactivePersonControllerSpec extends Specification{

    @Inject
    @Client("/reactive")
    HttpClient client;

    void testCrudPersonOperations() {
        when:
            HttpRequest request = HttpRequest.POST("/person", Map.of("firstName", "Axl", "secondName", "Rose"));
            HttpResponse response = client.toBlocking().exchange(request)       // use exchange to get response metadata
        then:
            HttpStatus.CREATED == response.getStatus()
        when:
            request.body = new Person( "Bob", "Geldoff" )
            Person p = client.toBlocking().retrieve(request, Person)            // use retrieve to just get the response object
        then:
            p.id == 9
        when:
            p  = client.toBlocking().retrieve( "/person/0", Person )        // person 0 to 7 added in PersonBootstrap
        then:
            p.id == 0
            p.firstName == 'Andy'
            p.secondName == 'Anchovie'
    }
}
