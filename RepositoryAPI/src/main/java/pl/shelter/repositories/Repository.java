package pl.shelter.repositories;

import pl.shelter.exceptions.AppException;

import java.util.List;
import java.util.function.Predicate;

public interface Repository<T> extends AutoCloseable {
    void add(T entity) throws AppException;
    T get(int index) throws AppException;
    void remove(T entity);
    void edit(T entity) throws AppException;
    List<T> getAll();
    List<T> findBy(Predicate<T> predicate);
}
