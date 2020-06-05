package com.example.itcompanyfinal.services.implementations;

import com.example.itcompanyfinal.model.Status;
import com.example.itcompanyfinal.repositories.interfaces.ReadRepository;
import com.example.itcompanyfinal.services.interfaces.ReadService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusService implements ReadService<Status> {
    private final ReadRepository<Status> REPOSITORY;

    public StatusService(@Qualifier("statusRepository")
                                 ReadRepository<Status> REPOSITORY) {
        this.REPOSITORY = REPOSITORY;
    }

    @Override
    public List<Status> getAll() {
        return REPOSITORY.getAll();
    }

    @Override
    public Status getById(int id) throws EmptyResultDataAccessException {
        return REPOSITORY.getById(id);
    }
}
