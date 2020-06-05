package com.example.itcompanyfinal.repositories.implementations;

import com.example.itcompanyfinal.additional.SQLQueriesShortcutter;
import com.example.itcompanyfinal.model.Department;
import com.example.itcompanyfinal.repositories.interfaces.ReadRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DepartmentRepository implements ReadRepository<Department> {
    private final JdbcTemplate JDBC_TEMPLATE;
    private String sqlQuery;

    public DepartmentRepository(JdbcTemplate JDBC_TEMPLATE) {
        this.JDBC_TEMPLATE = JDBC_TEMPLATE;
    }

    @Override
    public List<Department> getAll() {
        sqlQuery = SQLQueriesShortcutter.selectAll(Department.TABLE_NAME);
        return JDBC_TEMPLATE.query(sqlQuery, (resultSet, i) -> {
            Department department = new Department();
            department.setDepartmentId(resultSet.getInt(1));
            department.setDepartmentName(resultSet.getString(2));
            return department;
        });
    }

    @Override
    public Department getById(int id) throws EmptyResultDataAccessException {
        sqlQuery = SQLQueriesShortcutter.select(Department.TABLE_NAME, Department.ID + " = ?", "*");
        return JDBC_TEMPLATE.queryForObject(sqlQuery, new Object[]{id}, new BeanPropertyRowMapper<>(Department.class));
    }
}
