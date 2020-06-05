package com.example.itcompanyfinal.model;

public class Department {
    public static final String TABLE_NAME = "departments";
    public static final String ID = "department_id";
    public static final String NAME = "department_name";

    private int departmentId;
    private String departmentName;

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
