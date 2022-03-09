package gettingstarted;

import io.micronaut.context.annotation.ConfigurationProperties;

@ConfigurationProperties("greeting")
public class GreetingConfig {

    String prefix;

    Boolean excited = false;

    public String getPrefix() {
        return prefix;
    }

    public Boolean getExcited() {
        return excited;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public void setExcited(Boolean excited) {
        this.excited = excited;
    }
}
