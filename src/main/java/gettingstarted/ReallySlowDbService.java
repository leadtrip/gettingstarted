package gettingstarted;

import jakarta.inject.Singleton;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Singleton
public class ReallySlowDbService {

    Map<String, Person> inMemoryDatastore = new ConcurrentHashMap<>();

    public Person add(Person person ) {
        System.out.printf("Adding for %s%n", person.firstName);
        hangAround();
        return inMemoryDatastore.put(person.getFirstName(), person);
    }

    public Person getByName(String name) {
        System.out.printf("Looking for %s%n", name);
        hangAround();
        return inMemoryDatastore.getOrDefault(name, new Person("Mr", "Nobody"));
    }

    private void hangAround() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
