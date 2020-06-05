package com.example.itcompanyfinal.repositories.implementations;

import com.example.itcompanyfinal.additional.SQLQueriesShortcutter;
import com.example.itcompanyfinal.model.Status;
import com.example.itcompanyfinal.repositories.interfaces.ReadRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StatusRepository implements ReadRepository<Status> {
    private final JdbcTemplate JDBC_TEMPLATE;
    private String sqlQuery;

    public StatusRepository(JdbcTemplate JDBC_TEMPLATE) {
        this.JDBC_TEMPLATE = JDBC_TEMPLATE;
    }

    @Override
    public List<Status> getAll() {
        sqlQuery = SQLQueriesShortcutter.selectAll(Status.TABLE_NAME);
        return JDBC_TEMPLATE.query(sqlQuery, (resultSet, i) -> {
            Status status = new Status();
            status.setStatusId(resultSet.getInt(1));
            status.setStatusName(resultSet.getString(2));
            return status;
        });
    }

    @Override
    public Status getById(int id) throws EmptyResultDataAccessException {
        sqlQuery = SQLQueriesShortcutter.select(
                Status.TABLE_NAME, Status.ID + " = ?", "*");
        return JDBC_TEMPLATE.queryForObject(
                sqlQuery, new Object[]{id}, new BeanPropertyRowMapper<>(Status.class));
    }
}
