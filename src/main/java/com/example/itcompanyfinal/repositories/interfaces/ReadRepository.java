package com.example.itcompanyfinal.repositories.interfaces;

import org.springframework.dao.EmptyResultDataAccessException;

import java.util.List;

public interface ReadRepository<T> {
    List<T> getAll();
    T getById(int id) throws EmptyResultDataAccessException;
}
