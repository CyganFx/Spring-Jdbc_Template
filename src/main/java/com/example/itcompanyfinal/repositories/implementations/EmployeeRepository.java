package com.example.itcompanyfinal.repositories.implementations;

import com.example.itcompanyfinal.additional.SQLQueriesShortcutter;
import com.example.itcompanyfinal.model.Department;
import com.example.itcompanyfinal.model.Employee;
import com.example.itcompanyfinal.model.Experience;
import com.example.itcompanyfinal.model.Status;
import com.example.itcompanyfinal.repositories.interfaces.MyCrudRepository;
import com.example.itcompanyfinal.repositories.interfaces.ReadRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepository implements MyCrudRepository<Employee> {
    private final JdbcTemplate JDBC_TEMPLATE;
    private final ReadRepository<Experience> EXPERIENCE_REPOSITORY;
    private final ReadRepository<Department> DEPARTMENT_REPOSITORY;
    private final ReadRepository<Status> STATUS_REPOSITORY;
    private String sqlQuery;

    public EmployeeRepository(JdbcTemplate JDBC_TEMPLATE,
                              @Qualifier("experienceRepository") ReadRepository<Experience> EXPERIENCE_REPOSITORY,
                              @Qualifier("departmentRepository") ReadRepository<Department> DEPARTMENT_REPOSITORY,
                              @Qualifier("statusRepository") ReadRepository<Status> STATUS_REPOSITORY) {
        this.JDBC_TEMPLATE = JDBC_TEMPLATE;
        this.EXPERIENCE_REPOSITORY = EXPERIENCE_REPOSITORY;
        this.DEPARTMENT_REPOSITORY = DEPARTMENT_REPOSITORY;
        this.STATUS_REPOSITORY = STATUS_REPOSITORY;
    }

    @Override
    public void insert(Employee employee) {
        sqlQuery = SQLQueriesShortcutter.insert(Employee.TABLE_NAME, 9);
        JDBC_TEMPLATE.update(sqlQuery, employee.getEmployeeId(), employee.getBirthDate(),
                employee.getFirstName(), employee.getLastName(), employee.getGender(),
                employee.getHireDate(), employee.getExperienceId(), employee.getDepartmentId(),
                employee.getStatusId());
    }

    @Override
    public List<Employee> getAll() {
        sqlQuery = SQLQueriesShortcutter.selectAll(Employee.TABLE_NAME);
        return JDBC_TEMPLATE.query(sqlQuery, (resultSet, i) -> {
            Employee employee = new Employee();
            employee.setEmployeeId(resultSet.getInt(1));
            employee.setBirthDate(resultSet.getDate(2));
            employee.setFirstName(resultSet.getString(3));
            employee.setLastName(resultSet.getString(4));
            employee.setGender(resultSet.getString(5));
            employee.setHireDate(resultSet.getDate(6));
            employee.setExperienceId(resultSet.getInt(7));
            employee.setDepartmentId(resultSet.getInt(8));
            employee.setStatusId(resultSet.getInt(9));
            employee.setExperience(EXPERIENCE_REPOSITORY.getById(resultSet.getInt(7)));
            employee.setDepartment(DEPARTMENT_REPOSITORY.getById(resultSet.getInt(8)));
            employee.setStatus(STATUS_REPOSITORY.getById(resultSet.getInt(9)));
            return employee;
        });
    }

    @Override
    public Employee getById(int id) {
        sqlQuery = SQLQueriesShortcutter.select(
                Employee.TABLE_NAME, Employee.ID + " = ?", "*");
        Employee employee = JDBC_TEMPLATE.queryForObject(
                sqlQuery, new Object[]{id}, new BeanPropertyRowMapper<>(Employee.class));
        assert employee != null;
        employee.setExperience(EXPERIENCE_REPOSITORY.getById(employee.getExperienceId()));
        employee.setDepartment(DEPARTMENT_REPOSITORY.getById(employee.getDepartmentId()));
        employee.setStatus(STATUS_REPOSITORY.getById(employee.getStatusId()));
        return employee;
    }

    @Override
    public void update(Employee employee) {
        sqlQuery = SQLQueriesShortcutter.update(Employee.TABLE_NAME,
                Employee.ID + " = ?", Employee.BIRTH_DATE, Employee.FIRST_NAME,
                Employee.LAST_NAME, Employee.GENDER, Employee.HIRE_DATE, Employee.EXPERIENCE_ID,
                Employee.DEPARTMENT_ID, Employee.STATUS_ID);
        JDBC_TEMPLATE.update(sqlQuery, employee.getBirthDate(),
                employee.getFirstName(), employee.getLastName(), employee.getGender(),
                employee.getHireDate(), employee.getExperienceId(), employee.getDepartmentId(),
                employee.getStatusId(), employee.getEmployeeId());
    }

    @Override
    public void deleteById(int id) throws EmptyResultDataAccessException {
        sqlQuery = SQLQueriesShortcutter.delete(
                Employee.TABLE_NAME, Employee.ID + " = ?");
        JDBC_TEMPLATE.update(sqlQuery, id);
    }
}
