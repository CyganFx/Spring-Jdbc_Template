package com.example.itcompanyfinal.controller.interfaces;

import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;

public interface ReadController<T> {
    List<T> showAll();
    T showById(int id) throws EmptyResultDataAccessException;
}
