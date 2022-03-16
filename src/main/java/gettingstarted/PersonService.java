package gettingstarted;

import jakarta.inject.Singleton;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Singleton
public class PersonService {

    AtomicInteger sequence = new AtomicInteger();
    Map<Integer, Person> inMemoryDatastore = new ConcurrentHashMap<>();

    public Person add(Person person) {
        person.id = sequence.getAndIncrement();
        System.out.printf("Adding %s %s with id %s%n", person.firstName, person.secondName, person.id);
        return inMemoryDatastore.put(person.id, person);
    }

    public Person get(Integer id) {
        return inMemoryDatastore.getOrDefault(id, new Person("Mr", "Nobody"));
    }
}
