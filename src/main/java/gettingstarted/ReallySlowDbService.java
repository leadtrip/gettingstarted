package gettingstarted;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class ReallySlowDbService {

    @Inject
    PersonService personService;

    public Person add(Person person ) {
        hangAround();
        return personService.add(person);
    }

    public Person get(Integer id) {
        hangAround();
        return personService.get(id);
    }

    private void hangAround() {
        try {
            Thread.sleep(500 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
