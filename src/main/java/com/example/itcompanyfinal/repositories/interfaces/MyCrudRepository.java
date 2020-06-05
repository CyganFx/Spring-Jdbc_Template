package com.example.itcompanyfinal.repositories.interfaces;

import org.springframework.dao.EmptyResultDataAccessException;

public interface MyCrudRepository<T> extends ReadRepository<T> {
    void insert(T object);
    void update(T object);
    void deleteById(int id) throws EmptyResultDataAccessException;
}
