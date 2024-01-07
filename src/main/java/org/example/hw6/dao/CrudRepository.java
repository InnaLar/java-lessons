package org.example.hw6.dao;

import java.util.List;
import java.util.Optional;

public interface CrudRepository<T, K> {
    List<T> findAll();

    Optional<T> findById(K id);

    T save(T t);

    void deleteById(K id);

    T update(T t);
}
