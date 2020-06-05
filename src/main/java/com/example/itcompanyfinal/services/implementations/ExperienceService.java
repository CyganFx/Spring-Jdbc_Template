package com.example.itcompanyfinal.services.implementations;

import com.example.itcompanyfinal.model.Experience;
import com.example.itcompanyfinal.repositories.interfaces.ReadRepository;
import com.example.itcompanyfinal.services.interfaces.ReadService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperienceService implements ReadService<Experience> {
    private final ReadRepository<Experience> REPOSITORY;

    public ExperienceService(@Qualifier("experienceRepository")
                                     ReadRepository<Experience> REPOSITORY) {
        this.REPOSITORY = REPOSITORY;
    }

    @Override
    public List<Experience> getAll() {
        return REPOSITORY.getAll();
    }

    @Override
    public Experience getById(int id) throws EmptyResultDataAccessException {
        return REPOSITORY.getById(id);
    }
}
