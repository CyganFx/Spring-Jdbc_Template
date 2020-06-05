package com.example.itcompanyfinal.repositories.implementations;

import com.example.itcompanyfinal.additional.SQLQueriesShortcutter;
import com.example.itcompanyfinal.model.Experience;
import com.example.itcompanyfinal.repositories.interfaces.ReadRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ExperienceRepository implements ReadRepository<Experience> {
    private final JdbcTemplate JDBC_TEMPLATE;
    private String sqlQuery;

    public ExperienceRepository(JdbcTemplate JDBC_TEMPLATE) {
        this.JDBC_TEMPLATE = JDBC_TEMPLATE;
    }

    @Override
    public List<Experience> getAll() {
        sqlQuery = SQLQueriesShortcutter.selectAll(Experience.TABLE_NAME);
        return JDBC_TEMPLATE.query(sqlQuery, (resultSet, i) -> {
            Experience experience = new Experience();
            experience.setExperienceId(resultSet.getInt(1));
            experience.setCompanyExperience(resultSet.getInt(2));
            experience.setOverallExperience(resultSet.getInt(3));
            return experience;
        });
    }

    @Override
    public Experience getById(int id) throws EmptyResultDataAccessException {
        sqlQuery = SQLQueriesShortcutter.select(
                Experience.TABLE_NAME, Experience.ID + " = ?", "*");
        return JDBC_TEMPLATE.queryForObject(
                sqlQuery, new Object[]{id}, new BeanPropertyRowMapper<>(Experience.class));

    }
}
