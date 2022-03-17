package gettingstarted;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Singleton
public class ReallySlowDbService {

    private final Random random = new Random();

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
            long sleep = 100 * ThreadLocalRandom.current().nextLong(1, 10 );
            System.out.printf("Slow DB is going to take %s ms to do thi%ns", sleep);
            Thread.sleep( sleep );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
