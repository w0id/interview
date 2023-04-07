package hw7.api;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

public interface IDatabaseFillerService {
    @EventListener(ApplicationReadyEvent.class)
    void fillDatabaseOnStartup();
}
