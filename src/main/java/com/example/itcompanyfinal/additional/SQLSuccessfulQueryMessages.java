package com.example.itcompanyfinal.additional;

public abstract class SQLSuccessfulQueryMessages {

    public static String create(String className) {
        return "New " + className  + " added successfully";
    }

    public static String update(String className) {
        return className + " was updated successfully";
    }

    public static String delete(String className) {
        return className + " was deleted successfully";
    }
}
