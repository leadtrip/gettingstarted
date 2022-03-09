package gettingstarted;

import jakarta.inject.Inject;

public class GreetingServiceImpl implements GreetingService{

    @Inject
    GreetingConfig config;

    @Override
    public String greet( String name ) {
        return config.getPrefix() + " " + name + (config.excited ? "!" : "");
    }
}
