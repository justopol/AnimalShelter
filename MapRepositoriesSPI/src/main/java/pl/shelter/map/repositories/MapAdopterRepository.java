package pl.shelter.map.repositories;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.annotation.Priority;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Alternative;
import jakarta.inject.Inject;
import model.Adopter;
import org.jboss.logging.Logger;
import pl.shelter.exceptions.AppException;

@ApplicationScoped
@Alternative
@Priority(20)
@Logging
public class MapAdopterRepository extends MapRepository<Adopter> {
    //to do przeniesc do maprepository
    @Override
    public void edit(Adopter entity) throws AppException {
        getEntities().removeIf((c) -> c.equals(entity));
        add(entity);
    }


    private Logger logger = Logger.getLogger(MapAdopterRepository.class.getName());

    @Inject
    public MapAdopterRepository(Logger logger) {

        logger.info("Konstruktor MapAdopterRepository");
    }

    @PostConstruct
    public void init() {
        logger.info("INIT");
    }

    @PreDestroy
    public void destroy(){
        logger.info("DESTROY");
    }
}
