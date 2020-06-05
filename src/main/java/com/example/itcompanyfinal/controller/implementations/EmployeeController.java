package com.example.itcompanyfinal.controller.implementations;

import com.example.itcompanyfinal.additional.SQLSuccessfulQueryMessages;
import com.example.itcompanyfinal.controller.interfaces.MyCrudController;
import com.example.itcompanyfinal.model.Employee;
import com.example.itcompanyfinal.services.interfaces.MyCrudService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController implements MyCrudController<Employee> {
    private final MyCrudService<Employee> SERVICE;

    public EmployeeController(MyCrudService<Employee> SERVICE) {
        this.SERVICE = SERVICE;
    }

    @Override
    @PostMapping("/add")
    public String add(@RequestBody Employee employee) {
        SERVICE.insert(employee);
        return SQLSuccessfulQueryMessages.create(Employee.class.getSimpleName());
    }

    @Override
    @GetMapping("/all")
    public List<Employee> showAll() {
        return SERVICE.getAll();
    }

    @Override
    @GetMapping("/{id}")
    public Employee showById(@PathVariable int id) throws EmptyResultDataAccessException {
        return SERVICE.getById(id);
    }

    @Override
    @PutMapping("/update")
    public String edit(@RequestBody Employee employee) {
        SERVICE.update(employee);
        return SQLSuccessfulQueryMessages.update(Employee.class.getSimpleName());
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public String removeById(@PathVariable int id) throws EmptyResultDataAccessException {
        SERVICE.deleteById(id);
        return SQLSuccessfulQueryMessages.delete(Employee.class.getSimpleName());
    }
}
