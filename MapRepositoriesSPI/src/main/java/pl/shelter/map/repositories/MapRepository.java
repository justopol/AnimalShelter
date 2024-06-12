package pl.shelter.map.repositories;

import jakarta.enterprise.event.Event;
import jakarta.inject.Inject;
import model.AbstractEntity;
import org.eclipse.parsson.MapUtil;
import org.jboss.logging.Logger;
import pl.shelter.exceptions.AdopterException;
import pl.shelter.exceptions.AppException;
import pl.shelter.repositories.Repository;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public abstract class MapRepository<T extends AbstractEntity> implements Repository<T> {
    @Inject
    Logger logger;
    @Inject
    Event<OperationEvent> event;

    private final Map<UUID,T> entities = new HashMap<>();

    protected List<T> getEntities() {
        return new ArrayList<> (entities.values());
    }

    @Override
    public void add(T entity) throws AppException {
        if (entities.containsKey(entity.getUuid())) {
            logger.info(AppException.ENTITY_EXISTS);
            throw new AppException(AppException.ENTITY_EXISTS);
        }
        entities.put(entity.getUuid(),entity);
        event.fire(new OperationEvent("ADD"));
    }

    @Override
    public T get(int index) throws AppException {
        try {
            return entities.get(index);
        } catch (IndexOutOfBoundsException ioobe) {
            throw new AdopterException(AdopterException.NOT_FOUND, ioobe);
        }
    }

    @Override
    public void remove(T entity) {
        entities.remove(entity.getUuid());
    }

    @Override
    public List<T> findBy(Predicate<T> predicate) {
        return entities.values().stream().filter(predicate).collect(Collectors.toList());
    }
//to do bo zle przepisane
    @Override
    public List<T> getAll() {
        return Collections.unmodifiableList(new ArrayList<>(entities.values()));
    }

    @Override
    public void close() throws Exception {
        //do nothing here
    }
}
