package com.example.itcompanyfinal.additional;

import java.util.StringJoiner;

public abstract class SQLQueriesShortcutter {
    private static String sqlQuery;

    public static String insert(String tableName, int numberOfValues) {
        sqlQuery = "INSERT INTO " + tableName + " VALUES (";
        StringJoiner unknowns = new StringJoiner(",");
        for (int i = 0; i < numberOfValues; i++) {
            unknowns.add("?");
        }
        return sqlQuery.concat(unknowns + ")");
    }

    public static String selectAll(String tableName) {
        return "SELECT * FROM " + tableName;
    }

    public static String selectColumns(String tableName, String... columns) {
        sqlQuery = "SELECT ";
        StringJoiner selectedColumns = new StringJoiner(", ");
        for (String column : columns) {
            selectedColumns.add(column);
        }
        return sqlQuery.concat(selectedColumns + " FROM " + tableName);
    }

    public static String select(String tableName, String condition, String... columns) {
        sqlQuery = "SELECT ";
        StringJoiner selectedColumns = new StringJoiner(", ");
        for (String column : columns) {
            selectedColumns.add(column);
        }
        return sqlQuery.concat(selectedColumns + " FROM " + tableName + " WHERE " + condition);
    }

    public static String update(String tableName, String condition, String... columns) {
        sqlQuery = "UPDATE " + tableName + " SET ";
        StringJoiner changedColumns = new StringJoiner(", ");
        for (String column : columns) {
            changedColumns.add(column + " = ?");
        }
        return sqlQuery.concat(String.valueOf(changedColumns))
                .concat(" WHERE " + condition);
    }

    public static String delete(String tableName, String condition) {
        return "DELETE FROM " + tableName + " WHERE " + condition;
    }
}
