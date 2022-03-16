package gettingstarted;

import io.micronaut.core.async.annotation.SingleResult;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;
import jakarta.inject.Inject;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Mono;

@ExecuteOn(TaskExecutors.IO) // It is critical that any blocking I/O operations (such as fetching the data from the database) are offloaded to a separate thread pool that does not block the Event loop.
@Controller("/reactive")
public class ReactivePersonController {

    @Inject
    ReallySlowDbService reallySlowDbService;

    @Post("/person")
    @SingleResult
    public Publisher<HttpResponse<Person>> save(@Body Publisher<Person> person) {
        return Mono.from(person).map(p -> HttpResponse.created(reallySlowDbService.add(p))
        );
    }

    @Get("/person/{id}")
    public Mono<Person> person(Integer id) {
        return Mono.just(reallySlowDbService.get( id ));
    }

}
