package com.example.itcompanyfinal.model;

public class Status {
    public static final String TABLE_NAME = "status";
    public static final String ID = "status_id";
    public static final String NAME = "status_name";

    private int statusId;
    private String statusName;

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }
}
