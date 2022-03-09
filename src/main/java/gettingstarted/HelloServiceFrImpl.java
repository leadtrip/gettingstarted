package gettingstarted;

import jakarta.inject.Singleton;

@Singleton
public class HelloServiceFrImpl implements HelloService{
    @Override
    public String sayHello(String name) {
        return "Bonjour";
    }
}
