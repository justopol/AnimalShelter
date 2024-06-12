package pl.shelter.list.repositories;

import jakarta.inject.Inject;
import org.jboss.logging.Logger;
import pl.shelter.exceptions.AdopterException;
import pl.shelter.exceptions.AppException;
import pl.shelter.repositories.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public abstract class ListRepository<T> implements Repository<T> {
    @Inject
    Logger logger;

    private final List<T> entities = new ArrayList<>();

    protected List<T> getEntities() {
        return entities;
    }

    @Override
    public void add(T entity) throws AppException {
        if (entities.contains(entity)) {
            logger.info(AppException.ENTITY_EXISTS);
            throw new AppException(AppException.ENTITY_EXISTS);
        }
        entities.add(entity);
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
        entities.remove(entity);
    }

    @Override
    public List<T> findBy(Predicate<T> predicate) {
        return entities.stream().filter(predicate).collect(Collectors.toList());
    }

    @Override
    public List<T> getAll() {
        return Collections.unmodifiableList(entities);
    }

    @Override
    public void close() throws Exception {
        //do nothing here
    }
}
