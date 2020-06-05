package com.example.itcompanyfinal.model;

public class Experience {
    public static final String TABLE_NAME = "employee_experience";
    public static final String ID = "experience_id";
    public static final String COMPANY = "company_experience";
    public static final String OVERALL = "overall_experience";

    private int experienceId;
    private int companyExperience;
    private int overallExperience;

    public int getExperienceId() {
        return experienceId;
    }

    public void setExperienceId(int experienceId) {
        this.experienceId = experienceId;
    }

    public int getCompanyExperience() {
        return companyExperience;
    }

    public void setCompanyExperience(int companyExperience) {
        this.companyExperience = companyExperience;
    }

    public int getOverallExperience() {
        return overallExperience;
    }

    public void setOverallExperience(int overallExperience) {
        this.overallExperience = overallExperience;
    }
}
