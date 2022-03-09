package gettingstarted;

import io.micronaut.core.async.annotation.SingleResult;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import jakarta.inject.Inject;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Mono;

@Controller("/reactive")
public class ReactiveController {

    @Inject
    ReallySlowDbService reallySlowDbService;

    @Inject
    GreetingService greetingService;

    @Get("/greet/{name}")
    public Mono<String> greet(String name) {
        return Mono.just(greetingService.greet( name ) );
    }

    @Post("/person")
    @SingleResult
    public Publisher<HttpResponse<Person>> save(@Body Publisher<Person> person) {
        return Mono.from(person).map(p -> {
                    reallySlowDbService.add(p);
                    return HttpResponse.created(p);
                }
        );
    }

    @Get("/person/{name}")
    public Mono<Person> person(String name) {
        return Mono.just(reallySlowDbService.getByName( name ));
    }

}
