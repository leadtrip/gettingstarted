package gettingstarted;

import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import jakarta.inject.Inject;

@Controller
public class PersonController {

    @Inject
    PersonService personService;

    @Post("/person")
    Person createPerson(@Body Person person) {
        return personService.add(person);
    }

    @Get("/person/{id}")
    Person getPerson( Integer id ) {
        return personService.get(id);
    }

}
