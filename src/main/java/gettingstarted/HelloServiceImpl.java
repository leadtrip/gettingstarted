package gettingstarted;

import jakarta.inject.Singleton;

import java.util.Optional;

@Singleton
public class HelloServiceImpl implements HelloService{

    public String sayHello( final String name ) {
        return "Hello " + Optional.ofNullable(name).orElse("World");
    }
}
