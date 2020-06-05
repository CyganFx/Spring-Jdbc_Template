package com.example.itcompanyfinal.services.implementations;

import com.example.itcompanyfinal.model.Employee;
import com.example.itcompanyfinal.repositories.interfaces.MyCrudRepository;
import com.example.itcompanyfinal.services.interfaces.MyCrudService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements MyCrudService<Employee> {
    private final MyCrudRepository<Employee> REPOSITORY;

    public EmployeeService(@Qualifier("employeeRepository")
                                   MyCrudRepository<Employee> REPOSITORY) {
        this.REPOSITORY = REPOSITORY;
    }

    @Override
    public void insert(Employee employee) {
        REPOSITORY.insert(employee);
    }

    @Override
    public List<Employee> getAll() {
        return REPOSITORY.getAll();
    }

    @Override
    public Employee getById(int id) throws EmptyResultDataAccessException {
        return REPOSITORY.getById(id);
    }

    @Override
    public void update(Employee employee) {
        REPOSITORY.update(employee);
    }

    @Override
    public void deleteById(int id) throws EmptyResultDataAccessException {
        REPOSITORY.deleteById(id);
    }
}
