package com.example.itcompanyfinal.controller.interfaces;

import org.springframework.dao.EmptyResultDataAccessException;

public interface MyCrudController<T> extends ReadController<T> {
    String add(T object);
    String edit(T object);
    String removeById(int id) throws EmptyResultDataAccessException;
}
