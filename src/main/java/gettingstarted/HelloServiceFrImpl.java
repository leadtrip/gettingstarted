package gettingstarted;

import jakarta.inject.Singleton;

import java.util.Optional;

@Singleton
public class HelloServiceFrImpl implements HelloService{
    @Override
    public String sayHello(String name) {
        return "Bonjour " + Optional.ofNullable(name).orElse("le monde");
    }
}
