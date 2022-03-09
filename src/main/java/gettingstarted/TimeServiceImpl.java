package gettingstarted;

import jakarta.inject.Singleton;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

@Singleton
public class TimeServiceImpl implements TimeService{

    @Override
    public String current() {
        return LocalDateTime.now().format(DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM));
    }
}
