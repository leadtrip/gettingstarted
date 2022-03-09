package gettingstarted;

import io.micronaut.core.annotation.Nullable;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Controller
public class SimpleController {

    @Inject
    TimeService timeService;

    @Inject
    GreetingService greetingService;

    HelloService helloService;

    public SimpleController( @Named("HelloServiceImpl") HelloService hs ) {
        helloService = hs;
    }

    @Get("/hello{/name}")
    HttpResponse<String> hello(@Nullable String name) {
        return HttpResponse.ok().body(helloService.sayHello(name));
    }

    @Get( "/time" )
    HttpResponse<String> time() {
        return HttpResponse.ok().body(timeService.current());
    }

    @Get( "/greet{/name}" )
    HttpResponse<String> greet( @Nullable String name ) {
        return HttpResponse.ok().body(greetingService.greet( name ));
    }
}
