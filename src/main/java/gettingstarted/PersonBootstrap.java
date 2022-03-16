package gettingstarted;

import io.micronaut.runtime.event.annotation.EventListener;
import io.micronaut.runtime.server.event.ServerStartupEvent;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class PersonBootstrap{

    @Inject
    private PersonService personService;

    @EventListener
    public void onApplicationEvent(ServerStartupEvent serverStartupEvent) {
        personService.add( new Person("Andy", "Anchovie") );
        personService.add( new Person("Bob", "Bass") );
        personService.add( new Person("Carl", "Cod") );
        personService.add( new Person("Dave", "Dace") );
        personService.add( new Person("Eric", "Eel") );
        personService.add( new Person("Fred", "Fish") );
        personService.add( new Person("Gavin", "Gudgeon") );
        personService.add( new Person("Harry", "Haddock") );
    }
}
