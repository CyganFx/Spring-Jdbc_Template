package com.example.itcompanyfinal.services.implementations;

import com.example.itcompanyfinal.model.Department;
import com.example.itcompanyfinal.repositories.interfaces.ReadRepository;
import com.example.itcompanyfinal.services.interfaces.ReadService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService implements ReadService<Department> {
    private ReadRepository<Department> REPOSITORY;

    public DepartmentService(@Qualifier("departmentRepository")
                                     ReadRepository<Department> REPOSITORY) {
        this.REPOSITORY = REPOSITORY;
    }

    @Override
    public List<Department> getAll() {
        return REPOSITORY.getAll();
    }

    @Override
    public Department getById(int id) throws EmptyResultDataAccessException {
        return REPOSITORY.getById(id);
    }
}
