package pl.shelter.map.repositories;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import org.jboss.logging.Logger;

@ApplicationScoped
public class OperationObserver {

    @Inject
    Logger logger;
    public void observeOperations(@Observes OperationEvent event){
        logger.info("Zaobserwowano zdarzenie "+ event.getOperation());
    }
}
